package com.stoyakin_artem.recipeapplication.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notes extends BaseEntity{


    @Lob
    private String recipeNotes;

    @OneToOne(mappedBy = "notes")
    private Recipe recipe;


    @Builder
    public Notes(Long id, String recipeNotes, Recipe recipe) {
        super(id);
        this.recipeNotes = recipeNotes;
        this.recipe = recipe;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Notes;
    }

}
