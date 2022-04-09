package com.stoyakin_artem.recipeapplication.services;

import com.stoyakin_artem.recipeapplication.commands.UnitOfMeasureCommand;

import javax.transaction.Transactional;
import java.util.Set;

@Transactional
public interface UoMService {

    Set<UnitOfMeasureCommand> AllUoMs();
}
