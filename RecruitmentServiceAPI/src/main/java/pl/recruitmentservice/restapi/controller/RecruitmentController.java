package pl.recruitmentservice.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.recruitmentservice.restapi.dto.PersonSkillsDTOList;
import pl.recruitmentservice.restapi.dto.PersonDTO;
import pl.recruitmentservice.restapi.dto.PersonsDTOtoList;
import pl.recruitmentservice.restapi.dto.PersonsSkillDTO;
import pl.recruitmentservice.restapi.service.IRecruitmentService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    @Autowired
    private final IRecruitmentService recruitmentService;

    @GetMapping("/persons")
    public Iterable<PersonDTO> getPersons() {
        return new PersonsDTOtoList(recruitmentService.getPersons()).getList();
    }

    @GetMapping("/personsSkills")
    public Iterable<PersonsSkillDTO> getPersonsSkills() {
        return new PersonSkillsDTOList(recruitmentService.getPersonSkills()).getList();
    }

    @GetMapping("/personsBySkills")
    public Iterable<PersonDTO> getPersonsBySkills(@RequestParam(value = "id") String idSkills) {
        List<Integer> ids = Arrays.asList(idSkills.split(","));
        return new PersonsDTOtoList(recruitmentService.getPersonsBySkills(ids)).getList();
    }
}

