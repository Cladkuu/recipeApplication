package com.stoyakin_artem.recipeapplication.Model;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String recipeNotes;

    public Notes() {
    }

    @OneToOne(mappedBy = "notes")
    private Recipe recipe;
}
