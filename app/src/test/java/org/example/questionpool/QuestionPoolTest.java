package org.example.questionpool;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.example.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuestionPoolTest {

    static boolean isPasta = true;
    static Food expectedFirstFood = new Food("Burguer", "Meat and cheese between 2 buns", !isPasta);

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

        assertEquals(testQuestionPool.askCurrentQuestion(), friedChicken.getClue());

        testQuestionPool.answerNoToCurrentQuestion();
        assertEquals(testQuestionPool.askCurrentQuestion(), expectedFirstFood.getName());
    }

    // IT IS A STACK!!!!!
    // After the first food is wrong, the list goes from newer to older, always
    // asking by the clue first.
    // when we get back to the first food suggested, it goes right to the name when
    // asking it.

}
