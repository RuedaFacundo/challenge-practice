package com.challenge.Alkemy.Controllers;

import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Services.PersonageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personage")
public class PersonageController {

    private final PersonageService personageService;

    public PersonageController(PersonageService personageService) {
        this.personageService = personageService;
    }

    @GetMapping
    public ResponseEntity<List<PersonageDTO>> findAll() {
        return ResponseEntity.ok(
                personageService.findAll()
        );
    }
}
