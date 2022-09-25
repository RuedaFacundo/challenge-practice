package com.challenge.Alkemy.Model.Mappers;

import com.challenge.Alkemy.Model.Domain.CharacterDTO;
import com.challenge.Alkemy.Model.Entities.Character;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "characterMapper")
public class CharacterMapper {

    public CharacterDTO entityToDto(Character entity) {
        return Optional
                .ofNullable(entity)
                .map(
                       ent -> new CharacterDTO(
                               ent.getName(),
                               ent.getAge(),
                               ent.getWeigth(),
                               ent.getHistory(),
                               ent.getImage()
                       )
                ).orElse(new CharacterDTO());
    }

    public Character dtoToEntity(CharacterDTO dto) {
        Character character = new Character();
        character.setName(dto.getName());
        character.setAge(dto.getAge());
        character.setWeigth(dto.getWeigth());
        character.setHistory(dto.getHistory());
        character.setImage(dto.getImage());
        return character;
    }
}
