package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes extends BaseEntity{


    @Lob
    private String recipeNotes;

    public Notes() {
    }

    @OneToOne(mappedBy = "notes")
    private Recipe recipe;


    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

}
