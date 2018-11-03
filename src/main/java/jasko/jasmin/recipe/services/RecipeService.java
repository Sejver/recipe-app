package jasko.jasmin.recipe.services;

import jasko.jasmin.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService   {

    Set<Recipe> getRecipies();
}
