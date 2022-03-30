package com.stoyakin_artem.recipeapplication.converters;
import com.stoyakin_artem.recipeapplication.Model.Notes;
import com.stoyakin_artem.recipeapplication.commands.NotesCommand;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NotesConverter implements Converter<NotesCommand, Notes>{

    private final RecipesConverter recipesConverter;

    @Synchronized
    @Override
    public NotesCommand convertToCommand(Notes notes) {
        if (notes==null) return null;
        return NotesCommand.builder()
                .recipeNotes(notes.getRecipeNotes())
                .recipeCommand(recipesConverter.convertToCommand(notes.getRecipe()))
                .id(notes.getId())
                .build();
    }

    @Synchronized
    @Override
    public Notes convertToEntity(NotesCommand notesCommand) {
        if (notesCommand==null) return null;
        return Notes.builder()
                .recipeNotes(notesCommand.getRecipeNotes())
                .recipe(recipesConverter.convertToEntity(notesCommand.getRecipeCommand()))
                .id(notesCommand.getId())
                .build();

    }
}
