package com.challenge.Alkemy.Services;

import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Model.Entities.Personage;
import com.challenge.Alkemy.Model.Mappers.PersonageMapper;
import com.challenge.Alkemy.Model.Repositories.PersonageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    public PersonageDTO getById(int id) {
        if (personageRepository.existsById(id)) {
            return personageMapper.entityToDto(
                    personageRepository.getById(Integer.valueOf(id)));
        } else {
            // TODO Add the persongae exception
            return null;
        }
    }

    public PersonageDTO updatePersonage(PersonageDTO dto) {
        Optional<Personage> personage = personageRepository.findById(dto.getId());
        if (Objects.nonNull(personage)  && personage.isPresent()) {
            // TODO Check the optional handle, if its better with orElseThrow
            return personageMapper.entityToDto(
                    personageRepository.save(
                            personageMapper.dtoToEntity(dto)));
        } else {
            // TODO Add the persongae exception
            return null;
        }
    }

    public String delete(int id) {
        if (personageRepository.existsById(id)) {
            personageRepository.deleteById(id);
            return "Registro eliminado";
        } else {
            // TODO Add the persongae exception
            return null;
        }
    }

}
