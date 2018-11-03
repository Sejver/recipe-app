package jasko.jasmin.recipe.repositories;

import jasko.jasmin.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
