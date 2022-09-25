package com.challenge.Alkemy.Model.Mappers;

import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Model.Entities.Personage;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "personageMapper")
public class PersonageMapper {

    public PersonageDTO entityToDto(Personage entity) {
        return Optional
                .ofNullable(entity)
                .map(
                       ent -> new PersonageDTO(
                               ent.getName(),
                               ent.getAge(),
                               ent.getWeigth(),
                               ent.getHistory(),
                               ent.getImage()
                       )
                ).orElse(new PersonageDTO());
    }

    public Personage dtoToEntity(PersonageDTO dto) {
        Personage personage = new Personage();
        personage.setName(dto.getName());
        personage.setAge(dto.getAge());
        personage.setWeigth(dto.getWeigth());
        personage.setHistory(dto.getHistory());
        personage.setImage(dto.getImage());
        return personage;
    }
}
