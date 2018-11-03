package jasko.jasmin.recipe.services;

import jasko.jasmin.recipe.domain.Recipe;
import jasko.jasmin.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class RecipeServiceImpl implements RecipeService  {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipies() {

        Set<Recipe> recipesSet=new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipesSet::add);

        return recipesSet;
    }
}
