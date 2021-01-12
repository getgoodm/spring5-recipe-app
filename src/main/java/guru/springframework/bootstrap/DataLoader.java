package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Recipe> recipes = new ArrayList<>();

        UnitOfMeasure eachUom = unitOfMeasureRepository.findByUom("Each").get();
        UnitOfMeasure teaspoonUom = unitOfMeasureRepository.findByUom("Teaspoon").get();
        UnitOfMeasure tablespoonUom = unitOfMeasureRepository.findByUom("Tablespoon").get();
        UnitOfMeasure cupUom = unitOfMeasureRepository.findByUom("Cup").get();
        UnitOfMeasure pinchUom = unitOfMeasureRepository.findByUom("Pinch").get();
        UnitOfMeasure ounceUom = unitOfMeasureRepository.findByUom("Ounce").get();
        UnitOfMeasure dashUom = unitOfMeasureRepository.findByUom("Dash").get();
        UnitOfMeasure pintUom = unitOfMeasureRepository.findByUom("Pint").get();

        Category americanCategory = categoryRepository.findByDescription("American").get();
        Category mexicanCategory = categoryRepository.findByDescription("Mexican").get();


        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        Notes guacNotes = new Notes();
        guacNotes.setRecipe(guacamole);
        guacNotes.setRecipeNotes("Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.");
        guacamole.setNotes(guacNotes);
        guacamole.addIngredient("ripe avocados", BigDecimal.valueOf(2), eachUom);
        guacamole.addIngredient("Salt", new BigDecimal(".5"), teaspoonUom);
        guacamole.addIngredient("Fresh lime juice or lemon juice", BigDecimal.valueOf(2), tablespoonUom);
        guacamole.addIngredient("minced red onion or thinly sliced green onion", BigDecimal.valueOf(2), tablespoonUom);
        guacamole.addIngredient("serrano chiles, stems and seeds removed, minced", BigDecimal.valueOf(2), eachUom);
        guacamole.addIngredient("Cilantro", BigDecimal.valueOf(2), tablespoonUom);
        guacamole.addIngredient("Freshly grated black pepper", BigDecimal.valueOf(2), dashUom);
        guacamole.addIngredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom);

        guacamole.getCategories().add(americanCategory);
        guacamole.getCategories().add(mexicanCategory);

        guacamole.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setServings(4);
        guacamole.setSource("Simply Recipes");

        recipes.add(guacamole);

        Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Taco");
        tacos.setCookTime(9);
        tacos.setPrepTime(20);
        tacos.setDifficulty(Difficulty.MODERATE);

        tacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.");
        tacoNotes.setRecipe(tacos);
        tacos.setNotes(tacoNotes);
        tacos.addIngredient("Ancho Chili Powder", BigDecimal.valueOf(2), tablespoonUom);
        tacos.addIngredient("Dried Oregano", BigDecimal.valueOf(1), teaspoonUom);
        tacos.addIngredient("Dried Cumin", BigDecimal.valueOf(1), teaspoonUom);
        tacos.addIngredient("Sugar", BigDecimal.valueOf(1), teaspoonUom);
        tacos.addIngredient("Salt", new BigDecimal(".5"), teaspoonUom);
        tacos.addIngredient("Clove of Garlic, Choppedr", BigDecimal.valueOf(1), eachUom);
        tacos.addIngredient("finely grated orange zestr", BigDecimal.valueOf(1), tablespoonUom);
        tacos.addIngredient("fresh-squeezed orange juice", BigDecimal.valueOf(3), tablespoonUom);
        tacos.addIngredient("Olive Oil", BigDecimal.valueOf(2), tablespoonUom);
        tacos.addIngredient("boneless chicken thighs", BigDecimal.valueOf(4), tablespoonUom);
        tacos.addIngredient("small corn tortillasr", BigDecimal.valueOf(8), eachUom);
        tacos.addIngredient("packed baby arugula", BigDecimal.valueOf(3), cupUom);
        tacos.addIngredient("medium ripe avocados, slic", BigDecimal.valueOf(2), eachUom);
        tacos.addIngredient("radishes, thinly sliced", BigDecimal.valueOf(4), eachUom);
        tacos.addIngredient("cherry tomatoes, halved", new BigDecimal(".5"), pintUom);
        tacos.addIngredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom);
        tacos.addIngredient("Roughly chopped cilantro", BigDecimal.valueOf(4), eachUom);
        tacos.addIngredient("cup sour cream thinned with 1/4 cup milk", BigDecimal.valueOf(4), cupUom);
        tacos.addIngredient("lime, cut into wedges", BigDecimal.valueOf(4), eachUom);

        tacos.getCategories().add(americanCategory);
        tacos.getCategories().add(mexicanCategory);
        tacos.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacos.setServings(4);
        tacos.setSource("Simply Recipes");

        recipes.add(tacos);
        recipeRepository.save(guacamole);
        recipeRepository.save(tacos);

    }
}
