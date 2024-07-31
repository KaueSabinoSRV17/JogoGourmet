package org.example.questionpool;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.example.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionPoolTest {

    static boolean isPasta = true;
    static Food expectedFirstFood = new Food("Burguer", "Meat and cheese between 2 buns");

    @Test
    @DisplayName("After starting a question stack with a burguer, its top should be a burger")
    void after_starting_a_question_stack_with_a_burguer_its_top_should_be_a_burger() {
        QuestionPool testQuestionPool = new QuestionPool(expectedFirstFood);
        assertEquals(testQuestionPool.getCurrentQuestionStack().peek().getName(), expectedFirstFood.getName());
    }

    @Test
    @DisplayName("After starting a question stack with a burguer, adding fried chicken and restarting the game, the current list should have both again")
    void after_starting_a_question_stack_with_a_burguer_adding_fried_chicken_and_restarting_the_game_the_current_list_should_have_both_again() {
        QuestionPool testQuestionPool = new QuestionPool(expectedFirstFood);
        Food friedChicken = new Food("Fried Chicken", "farm bird deep fried");
        testQuestionPool.addFood(friedChicken);
        testQuestionPool.restartGame();

        assertEquals(testQuestionPool.askCurrentQuestion(), String.format("Sua comida é %s?", friedChicken.getClue()));

        testQuestionPool.answerNoToCurrentQuestion();
        assertEquals(testQuestionPool.askCurrentQuestion(), String.format("Sua comida é %s?", expectedFirstFood.getName()));
    }
    
}
