package pl.recruitmentservice.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.recruitmentservice.restapi.dto.*;
import pl.recruitmentservice.restapi.service.IRecruitmentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public Iterable<PersonsSkillDTO> getPersonsSkills() {
        return new PersonSkillsDTOList(recruitmentService.getPersonSkills()).getList();
    }

    @GetMapping("/personsBySkills")
    public Iterable<PersonDTO> getPersonsBySkills(@RequestParam(value = "id") String idSkills) {
        List<String> idsStr = Arrays.asList(idSkills.split(","));
        List<Integer> ids = new ArrayList<Integer>();
        for (String s: idsStr) {
            ids.add(Integer.parseInt(s));
        }
        return new PersonsDTOtoList(recruitmentService.getPersonsBySkills(ids)).getList();
    }
}

