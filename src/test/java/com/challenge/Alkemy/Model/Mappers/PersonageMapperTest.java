package com.challenge.Alkemy.Model.Mappers;

import com.challenge.Alkemy.AlkemyApplication;
import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Model.Entities.Personage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AlkemyApplication.class})
class PersonageMapperTest {

    @InjectMocks
    private PersonageMapper personageMapper;

    @Test
    void entityToDto() {
        Personage personage = new Personage(1, "Simba", 30, 80.0F, "Description", "image");
        PersonageDTO personageDTO = personageMapper.entityToDto(personage);
        assertAll("Should be equal fields",
                () -> assertEquals(personageDTO.getId(), personage.getId()),
                () -> assertEquals(personageDTO.getAge(), personage.getAge()),
                () -> assertEquals(personageDTO.getName(), personage.getName()),
                () -> assertEquals(personageDTO.getHistory(), personage.getHistory()),
                () -> assertEquals(personageDTO.getWeigth(), personage.getWeigth()),
                () -> assertEquals(personageDTO.getImage(), personage.getImage())
        );
    }

    @Test
    void dtoToEntity() {
        PersonageDTO personageDTO = new PersonageDTO(1, "Simba", 30, 80.0F, "Description", "image");
        Personage personage = personageMapper.dtoToEntity(personageDTO);
        assertAll("Should be equal fields",
                () -> assertEquals(personage.getId(), personageDTO.getId()),
                () -> assertEquals(personage.getAge(), personageDTO.getAge()),
                () -> assertEquals(personage.getName(), personageDTO.getName()),
                () -> assertEquals(personage.getHistory(), personageDTO.getHistory()),
                () -> assertEquals(personage.getWeigth(), personageDTO.getWeigth()),
                () -> assertEquals(personage.getImage(), personageDTO.getImage())
        );
    }
}