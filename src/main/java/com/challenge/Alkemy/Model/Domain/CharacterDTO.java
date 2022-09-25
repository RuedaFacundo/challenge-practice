package com.challenge.Alkemy.Model.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

    public String name;
    public Integer age;
    public Float weigth;
    public String history;
    public String image;
}
