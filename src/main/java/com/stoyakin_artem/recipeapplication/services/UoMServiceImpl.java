package com.stoyakin_artem.recipeapplication.services;

import com.stoyakin_artem.recipeapplication.commands.UnitOfMeasureCommand;
import com.stoyakin_artem.recipeapplication.converters.UnitOfMeasureConverter;
import com.stoyakin_artem.recipeapplication.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UoMServiceImpl implements UoMService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureConverter converter;

    @Override
    public Set<UnitOfMeasureCommand> AllUoMs() {
        Set<UnitOfMeasureCommand> unitOfMeasureCommands = new HashSet<>();
        unitOfMeasureRepository.findAll()
                .forEach(unitOfMeasure -> unitOfMeasureCommands.add(converter.convertToCommand(unitOfMeasure)));


        return unitOfMeasureCommands;
    }
}
