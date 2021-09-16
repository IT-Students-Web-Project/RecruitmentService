package pl.recruitmentservice.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.recruitmentservice.restapi.dto.*;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.model.PersonsSkill;
import pl.recruitmentservice.restapi.model.Skill;
import pl.recruitmentservice.restapi.security.JwtUtil;
import pl.recruitmentservice.restapi.service.IRecruitmentService;
import pl.recruitmentservice.restapi.service.RecruitmentUserDetailService;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RecruitmentController {

    @Autowired
    private IRecruitmentService recruitmentService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RecruitmentUserDetailService userDetailService;
    @Autowired
    private JwtUtil jwtTokenUtil;



    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto login) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
            );

        } catch (BadCredentialsException ex) {
            throw new Exception("Niepoprawny uzytkownik lub haslo", ex);
        }
        UserDetails userDetails = userDetailService.loadUserByUsername(login.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return new TokenDto(token);
    }

    @PutMapping("/person/{id}")
    public Iterable<PersonDTO> editPerson(@PathVariable(value = "id") int personID, @RequestBody PersonDTO personDTO) {
        Optional<Person> optionalPerson = recruitmentService.getPerson(personID);
        if (optionalPerson.isPresent() && personDTO != null){
            Person editedPerson = optionalPerson.get();
            editedPerson.setAddress(personDTO.getAddress().createAddress());
            editedPerson.setFirstName(personDTO.getFirstName());
            editedPerson.setLastName(personDTO.getLastName());
            /*List<PersonsSkillDTO> personsSkillDTOs = personDTO.getPersonSkills();
            List<PersonsSkill> personsSkillList = new ArrayList<>();
            for (PersonsSkillDTO pS: personsSkillDTOs) {
                personsSkillList.add(recruitmentService.getPersonSkill(pS.getId()));
            }
            editedPerson.setPersonsSkills(personsSkillList);*/
            recruitmentService.removePerson(personID);
            recruitmentService.addPerson(editedPerson);
        }
        return getPersons();
    }

    @DeleteMapping("person/{id}")
    public Iterable<PersonDTO> deletePerson(@PathVariable(value = "id") int personID) {
        recruitmentService.removePerson(personID);
        return getPersons();
    }

    @GetMapping("/persons")
    public Iterable<PersonDTO> getPersons() {
        return new PersonsDTOtoList(recruitmentService.getPersons()).getList();
    }

    @GetMapping("/skills")
    public Iterable<SkillDTO> getSkills() {
        return new SkillDTOtoList(recruitmentService.getSkills()).getList();
    }

    @GetMapping("/skill/{id}")
    public SkillDTO getSkillById(@PathVariable(value = "id") int skillId){
        return new SkillDTO(recruitmentService.getSkill(skillId));
    }

    @PostMapping("/addSkill")
    public Iterable<SkillDTO> addSkill(@RequestBody SkillDTO skillDTO){
        recruitmentService.addSkill(new Skill(skillDTO.getName()));
        return getSkills();
    }

    @PutMapping("/skill/{id}")
    public Iterable<SkillDTO> editSkill(@PathVariable(value = "id") int skillId, @RequestBody SkillDTO skillDTO){
        Skill skill = new Skill();
        skill.setId(skillId);
        skill.setName(skillDTO.getName());
        recruitmentService.removeSkill(skillId);
        recruitmentService.addSkill(skill);
        return getSkills();
    }

    @DeleteMapping("/skill/{id}")
    public Iterable<SkillDTO> removeSkill(@PathVariable(value = "id") int skillId){
        System.out.println("Deleted skill " + skillId);
        recruitmentService.removeSkill(skillId);
        return getSkills();
    }

    @GetMapping("/levels")
    public Iterable<LevelDTO> getLevels() {
        return new LevelDTOtoList(recruitmentService.getLevels()).getList();
    }

    @GetMapping("/personsSkills")
    public Iterable<PersonsSkillDTO> getPersonsSkills() { return new PersonSkillsDTOList(recruitmentService.getPersonSkills()).getList(); }

    @GetMapping("/personsBySkills")
    public Iterable<PersonDTO> getPersonsBySkills(
            @RequestParam(value = "idSkills", defaultValue = "") String idSkills,
            @RequestParam(value = "city", defaultValue = "") String city) {

        List<Integer> ids = idsStringToList(idSkills);
        List<Person> people = recruitmentService.getPersonsBySkills(ids);

        if(!city.isEmpty())
            people = filterPeopleByCity(people, city);

        return new PersonsDTOtoList(people).getList();
    }

    @GetMapping("/personsCities")
    public Iterable<String> getPersonsCities() {
        return recruitmentService.getPersonsCities();
    }

    private List<Person> filterPeopleByCity(List<Person> people, String city) {
        return people.stream()
                .filter(p -> p.getAddress().getCity().equals(city))
                .collect(Collectors.toList());
    }

    private List<Integer> idsStringToList(String paramsString) {
        if(paramsString.isEmpty())
            return Collections.emptyList();
        List<String> idsStr = Arrays.asList(paramsString.split(","));
        List<Integer> ids = new ArrayList<>();
        for (String s: idsStr) {
            ids.add(Integer.parseInt(s));
        }
        return ids;
    }
}

