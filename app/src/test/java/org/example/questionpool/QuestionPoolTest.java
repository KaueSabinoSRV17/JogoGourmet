package org.example.questionpool;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.example.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionPoolTest {

    static boolean isPasta = true;
    static Food expectedFirstPastaFood = new Food("Carbonara",
            "Spagheti like dish, with pork fat, parmegiano reggiano and eggs as sauce", isPasta);
    static Food expectedFirstNonPastaFood = new Food("Burguer", "Meat and cheese between 2 buns", !isPasta);

    @Test
    @DisplayName("A game should start with Carbonara and a Burguer as its initial food")
    void a_game_should_start_with_carbonara_and_a_burguer_as_its_initial_food() {
        QuestionPool testQuestionPool = new QuestionPool();
        Food resultFirstFood = testQuestionPool.getFoods().get(0);
        Food resultSecondFood = testQuestionPool.getFoods().get(1);

        assertEquals(expectedFirstPastaFood.getName(), resultFirstFood.getName());
        assertEquals(expectedFirstPastaFood.getClue(), resultFirstFood.getClue());

        assertEquals(expectedFirstNonPastaFood.getName(), resultSecondFood.getName());
        assertEquals(expectedFirstNonPastaFood.getClue(), resultSecondFood.getClue());
    }

    @Test
    @DisplayName("A game should start with one pasta food and one non pasta food")
    void a_game_should_start_with_one_pasta_food_and_one_non_pasta_food() {
        QuestionPool testQuestionPool = new QuestionPool();

        testQuestionPool.setPasta(true);
        List<Food> resultPastaFoods = testQuestionPool.filteredFoods();

        testQuestionPool.setPasta(false);
        List<Food> resultPastaNonFoods = testQuestionPool.filteredFoods();

        assertEquals(resultPastaFoods.size(), 1);
        assertEquals(resultPastaNonFoods.size(), 1);
    }

    // IT IS A STACK!!!!!
    // After the first food is wrong, the list goes from newer to older, always
    // asking by the clue first.
    // when we get back to the first food suggested, it goes right to the name when
    // asking it.

}
