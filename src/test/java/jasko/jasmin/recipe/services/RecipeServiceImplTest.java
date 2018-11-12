package jasko.jasmin.recipe.services;

import jasko.jasmin.recipe.domain.Recipe;
import jasko.jasmin.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService=new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipies() {
        Recipe recipe=new Recipe();

        HashSet  hashSet=new HashSet();
        hashSet.add(recipe);

        when(recipeService.getRecipies()).thenReturn(hashSet);

        Set<Recipe> recipes=recipeService.getRecipies();
        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }
}