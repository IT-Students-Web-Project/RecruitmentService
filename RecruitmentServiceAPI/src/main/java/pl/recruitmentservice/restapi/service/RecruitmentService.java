package pl.recruitmentservice.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.recruitmentservice.restapi.model.Person;
import pl.recruitmentservice.restapi.repository.PersonsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitmentService implements IRecruitmentService{
    @Autowired
    private final PersonsRepository personsRepository;

    @Override
    public List<Person> getPersons() {
        return personsRepository.findAll();
    }
}