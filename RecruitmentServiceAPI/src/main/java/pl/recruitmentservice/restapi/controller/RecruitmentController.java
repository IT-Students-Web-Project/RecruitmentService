package pl.recruitmentservice.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.recruitmentservice.restapi.dto.PersonsDTO;
import pl.recruitmentservice.restapi.dto.PersonsDTOtoList;
import pl.recruitmentservice.restapi.service.IRecruitmentService;

@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    @Autowired
    private final IRecruitmentService recruitmentService;

    @GetMapping("/persons")
    public Iterable<PersonsDTO> getPersons() {
        return new PersonsDTOtoList(recruitmentService.getPersons()).getList();
    }


}

