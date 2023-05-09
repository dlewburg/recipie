package com.dlewburg.Recipie.repos;

import com.dlewburg.Recipie.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    public Recipe getRecipeByIngredients(String ingredients);
}
