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
import pl.recruitmentservice.restapi.security.JwtUtil;
import pl.recruitmentservice.restapi.service.IRecruitmentService;
import pl.recruitmentservice.restapi.service.RecruitmentUserDetailService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    public String login(@RequestBody LoginDto loginDto) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("Niepoprawny uzytkownik lub haslo", ex);
        }
        UserDetails userDetails = userDetailService.loadUserByUsername(loginDto.getUsername());
        return jwtTokenUtil.generateToken(userDetails);
    }

    @GetMapping("/persons")
    public Iterable<PersonDTO> getPersons() {
        return new PersonsDTOtoList(recruitmentService.getPersons()).getList();
    }

    @GetMapping("/skills")
    public Iterable<SkillDTO> getSkills() {
        return new SkillDTOtoList(recruitmentService.getSkills()).getList();
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

