package com.challenge.Alkemy.Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "personage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED")
    public Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    public String name;

    @Column(name = "age", columnDefinition = "INTEGER")
    public Integer age;

    @Column(name = "weigth", columnDefinition = "FLOAT")
    public Float weigth;

    @Column(name = "history", columnDefinition = "VARCHAR(45)")
    public String history;

    @Column(name = "image", columnDefinition = "VARCHAR(45)")
    public String image;
}
