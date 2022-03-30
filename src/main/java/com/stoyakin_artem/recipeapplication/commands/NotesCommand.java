package com.stoyakin_artem.recipeapplication.commands;

import com.stoyakin_artem.recipeapplication.Model.BaseEntity;
import com.stoyakin_artem.recipeapplication.Model.Recipe;
import lombok.*;
import javax.persistence.Lob;


@Data
@EqualsAndHashCode(exclude = {"recipeCommand"})
@NoArgsConstructor
@AllArgsConstructor
public class NotesCommand extends BaseEntity {


    @Lob
    private String recipeNotes;
    private RecipeCommand recipeCommand;

    @Builder
    public NotesCommand(Long id, String recipeNotes, RecipeCommand recipeCommand) {
        super(id);
        this.recipeNotes = recipeNotes;
        this.recipeCommand = recipeCommand;
    }
}
