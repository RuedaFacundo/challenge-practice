package com.challenge.Alkemy.Services;

import com.challenge.Alkemy.AlkemyApplication;
import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Model.Entities.Personage;
import com.challenge.Alkemy.Model.Mappers.PersonageMapper;
import com.challenge.Alkemy.Model.Repositories.PersonageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AlkemyApplication.class})
class PersonageServiceTest {

    @InjectMocks
    private PersonageService personageService;

    @Mock
    private PersonageRepository personageRepository;

    @Mock
    private PersonageMapper personageMapper;

    private Personage simba;
    private PersonageDTO simbaDTO;

    @BeforeEach
    void init() {
        simba = new Personage(1, "Simba", 30, 80.0F, "Description", "image");
        simbaDTO = new PersonageDTO(1, "Simba", 30, 80.0F, "Description", "image");
    }

    @Test
    void findAll() {
        List<Personage> personageList = new ArrayList<>();
        Personage pluto = new Personage(2, "Pluto", 10, 70.0F, "Description", "image");
        Personage mickey = new Personage(3, "Mickey", 20, 50.0F, "Description", "image");
        personageList.add(simba);
        personageList.add(pluto);
        personageList.add(mickey);
        PersonageDTO plutoDTO =new PersonageDTO(2, "Pluto", 10, 70.0F, "Description", "image");
        PersonageDTO mickeyDTO =new PersonageDTO(3, "Mickey", 20, 50.0F, "Description", "image");
        when(personageRepository.findAll()).thenReturn(personageList);
        when(personageMapper.entityToDto(simba)).thenReturn(simbaDTO);
        when(personageMapper.entityToDto(pluto)).thenReturn(plutoDTO);
        when(personageMapper.entityToDto(mickey)).thenReturn(mickeyDTO);
        List<PersonageDTO> result = personageService.findAll();
        assertEquals(true, !result.isEmpty());

    }

    @Test
    void savePersonage() {
        when(personageMapper.dtoToEntity(simbaDTO)).thenReturn(simba);
        when(personageMapper.entityToDto(simba)).thenReturn(simbaDTO);
        when(personageRepository.save(simba)).then(returnsFirstArg());
        PersonageDTO result = personageService.savePersonage(simbaDTO);
        assertEquals("Simba", result.getName());
    }

    @Test
    void whenPersonageExistsGetById() {
        when(personageRepository.existsById(1)).thenReturn(true);
        when(personageRepository.getById(1)).thenReturn(simba);
        when(personageMapper.entityToDto(simba)).thenReturn(simbaDTO);
        PersonageDTO result = personageService.getById(1);
        assertEquals(1, result.getId());
    }

    @Test
    void whenPersonageDoesNotExistsGetById() {
        when(personageRepository.existsById(1)).thenReturn(false);
        PersonageDTO personageDTO = personageService.getById(1);
        assertEquals(null, personageDTO);
    }

    @Test
    void whenExistsUpdatePersonage() {
        when(personageRepository.findById(1)).thenReturn(Optional.ofNullable(simba));
        when(personageMapper.dtoToEntity(simbaDTO)).thenReturn(simba);
        when(personageMapper.entityToDto(simba)).thenReturn(simbaDTO);
        when(personageRepository.save(simba)).then(returnsFirstArg());
        PersonageDTO result = personageService.updatePersonage(simbaDTO);
        assertEquals(1, result.getId());
    }

    @Test
    void whenDoesNotExistsUpdatePersonage() {
        when(personageRepository.findById(1)).thenReturn(null);
        PersonageDTO personageDTO = personageService.updatePersonage(simbaDTO);
        assertEquals(null, personageDTO);
    }

    @Test
    void whenExistsDelete() {
        when(personageRepository.existsById(1)).thenReturn(true);
        String result = personageService.delete(1);
        assertEquals("Record deleted successfully", result);
    }

    @Test
    void whenDoesNotExistsDelete() {
        when(personageRepository.existsById(1)).thenReturn(false);
        String result = personageService.delete(1);
        assertEquals(null, result);
    }

}