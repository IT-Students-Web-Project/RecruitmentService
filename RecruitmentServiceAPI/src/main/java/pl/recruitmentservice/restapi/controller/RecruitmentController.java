package pl.recruitmentservice.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.recruitmentservice.restapi.dto.*;
import pl.recruitmentservice.restapi.service.IRecruitmentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    @Autowired
    private final IRecruitmentService recruitmentService;

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
    public Iterable<PersonDTO> getPersonsBySkills(@RequestParam(value = "idSkills") String idSkills) {
        List<Integer> ids = idsStringToList(idSkills);
        return new PersonsDTOtoList(recruitmentService.getPersonsBySkills(ids)).getList();
    }

    private List<Integer> idsStringToList(String paramsString) {
        List<String> idsStr = Arrays.asList(paramsString.split(","));
        List<Integer> ids = new ArrayList<>();
        for (String s: idsStr) {
            ids.add(Integer.parseInt(s));
        }
        return ids;
    }
}

