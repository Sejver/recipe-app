package jasko.jasmin.recipe.services;

import jasko.jasmin.recipe.domain.Recipe;
import jasko.jasmin.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService  {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipies() {
        log.debug("I m in the service");

        Set<Recipe> recipesSet=new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipesSet::add);

        return recipesSet;
    }
}
