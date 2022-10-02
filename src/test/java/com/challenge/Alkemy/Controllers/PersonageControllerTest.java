package com.challenge.Alkemy.Controllers;

import com.challenge.Alkemy.AlkemyApplication;
import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Services.PersonageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AlkemyApplication.class})
class PersonageControllerTest {

    @InjectMocks
    private PersonageController personageController;

    @Mock
    private PersonageService personageService;

    private PersonageDTO personageDTO;

    @BeforeEach
    void init() {
        personageDTO = new PersonageDTO(1, "Simba", 30, 80.0F, "Description", "image");
    }

    @Test
    void findAll() {
        List<PersonageDTO> personageDTOList = new ArrayList<>();
        personageDTOList.add(personageDTO);
        when(personageService.findAll()).thenReturn(personageDTOList);
        ResponseEntity<List<PersonageDTO>> responseEntity = personageController.findAll();
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void save() {
        when(personageService.savePersonage(personageDTO)).thenReturn(personageDTO);
        Map<String, String> map = personageController.save(personageDTO);
        assertEquals(true, map.containsValue(personageDTO.getName()));
    }

    @Test
    void getById() {
        when(personageService.getById(1)).thenReturn(personageDTO);
        ResponseEntity<PersonageDTO> result = personageController.getById(1);
        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void delete() {
        String message = "Record deleted successfully";
        when(personageService.delete(1)).thenReturn(message);
        ResponseEntity<String> result = personageController.delete(1);
        assertEquals(200, result.getStatusCodeValue());
        assertEquals(message, result.getBody());
    }

    @Test
    void update() {
        when(personageService.updatePersonage(personageDTO)).thenReturn(personageDTO);
        ResponseEntity<String> result = personageController.update(personageDTO);
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Registry updated successfully", result.getBody());
    }
}