package com.challenge.Alkemy.Controllers;

import com.challenge.Alkemy.Model.Domain.PersonageDTO;
import com.challenge.Alkemy.Services.PersonageService;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @PostMapping
    public Map<String, String> save(@RequestBody @NotNull PersonageDTO dto){
        PersonageDTO personageDTO = personageService.savePersonage(dto);
        HashMap<String, String> map = new HashMap<>();
        map.put("Name: ", personageDTO.getName());
        map.put("message: ", "Saved successfully");
        return map;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonageDTO> getById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(
                personageService.getById(id)
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(
                personageService.delete(id)
        );
    }

    @PutMapping()
    public ResponseEntity<String> put(@RequestBody @NotNull PersonageDTO dto) {
        return ResponseEntity.ok(
                Objects.nonNull(personageService.updatePersonage(dto)) ?
                        "Registro actualizado correctamente" : "No se pudo actualizar el registro"
        );
    }
}
