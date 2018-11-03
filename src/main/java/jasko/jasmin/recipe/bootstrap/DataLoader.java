package jasko.jasmin.recipe.bootstrap;

import jasko.jasmin.recipe.domain.*;
import jasko.jasmin.recipe.repositories.CategoryRepository;
import jasko.jasmin.recipe.repositories.RecipeRepository;
import jasko.jasmin.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {



    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        recipeRepository.saveAll(getRecipes());
    }
    private List<Recipe> getRecipes(){

        List<Recipe> recipes= new ArrayList<>(2);


        Optional<UnitOfMeasure> eachUnitOfMeasure= unitOfMeasureRepository.findByDescription("Each");

        if(!eachUnitOfMeasure.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }


        Optional<UnitOfMeasure> tableSpoonUOM=unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUOM.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }


        Optional<UnitOfMeasure> teaSpoonUOM= unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUOM.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> dashUOM=unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUOM.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> pintUOM=unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUOM.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }

        Optional<UnitOfMeasure> coupsUOM=unitOfMeasureRepository.findByDescription("Cup");

        if(!pintUOM.isPresent()){
            throw new RuntimeException("Expected Unit of measure not found");
        }


        UnitOfMeasure eachUOMget=eachUnitOfMeasure.get();
        UnitOfMeasure tableSpoonUOMget=tableSpoonUOM.get();
        UnitOfMeasure teaSpoonUOMget= teaSpoonUOM.get();
        UnitOfMeasure dashUOMget= dashUOM.get();
        UnitOfMeasure pintUOMget= pintUOM.get();
        UnitOfMeasure cupUOMget=coupsUOM.get();


        Optional<Category> americanCategoryOp=categoryRepository.findByDescription("American");
        if(!americanCategoryOp.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanCategoryOp=categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOp.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Category americanCategory= americanCategoryOp.get();
        Category mexicanCategory =mexicanCategoryOp.get();


        Recipe guacRecipe= new Recipe();

        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPreTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl."+
                "\n"+
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n"+
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.");

        Notes guacNotes=new Notes();

        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avacoda",new BigDecimal(2),eachUOMget,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("kosher sault",new BigDecimal(".5"),teaSpoonUOMget,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon",new BigDecimal(2),tableSpoonUOMget,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion",new BigDecimal(2),tableSpoonUOMget,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("serrano chiles stems and seeds removed",new BigDecimal(2),eachUOMget,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Cilantro",new BigDecimal(2),tableSpoonUOMget,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("freashly grated black papper",new BigDecimal(2),dashUOMget,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient( "ripe tomato",new BigDecimal(".5"),teaSpoonUOMget,guacRecipe));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);

        Recipe tacosRecipe=new Recipe();

        tacosRecipe.setDescription("Spicy grilled chicken tacos");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPreTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings. 3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges."
        );

        Notes tacosNotes=new Notes();
        tacosNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!"
        );
        tacosNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacosNotes);

        tacosRecipe.getIngredients().add(new Ingredient("Ancho chili Powder",new BigDecimal(2),eachUOMget,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Oregano",new BigDecimal(".5"),teaSpoonUOMget,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Sugar",new BigDecimal(2),tableSpoonUOMget,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("salt",new BigDecimal(2),tableSpoonUOMget,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("small corn tortillas",new BigDecimal(2),eachUOMget,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("cherry tomato",new BigDecimal(2),tableSpoonUOMget,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("red onion, thingy sliced",new BigDecimal(2),dashUOMget,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("lime,cut into wedges",new BigDecimal(".5"),eachUOMget,tacosRecipe));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);
        recipes.add(tacosRecipe);
        return recipes;
}

}
