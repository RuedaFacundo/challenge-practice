package com.challenge.Alkemy.Services;

import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Model.Mappers.PersonageMapper;
import com.challenge.Alkemy.Model.Repositories.PersonageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonageService {

    private final PersonageRepository personageRepository;
    private final PersonageMapper personageMapper;

    public PersonageService(PersonageRepository personageRepository, PersonageMapper personageMapper) {
        this.personageRepository = personageRepository;
        this.personageMapper = personageMapper;
    }

    public List<PersonageDTO> findAll() {
        return personageRepository.findAll().stream()
                .map(personageMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public PersonageDTO savePersonage(PersonageDTO dto) {
        return personageMapper.entityToDto(
                personageRepository.save(
                        personageMapper.dtoToEntity(dto)));
    }
}
