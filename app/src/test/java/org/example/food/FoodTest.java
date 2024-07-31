package org.example.food;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

class AppTest {

    static String expectedName = "Burguer";
    static String expectedClue = "Has meat and cheese between two buns";
    static boolean burguerEqualsToPasta = false;

    @Test
    @DisplayName("A Food should have a name and a clue that leads to it")
    void a_food_should_have_a_name_and_a_clue_that_leads_to_it() {
        Food testFood = new Food(expectedName, expectedClue, burguerEqualsToPasta);
        assertEquals(expectedName, testFood.getName());
        assertEquals(expectedClue, testFood.getClue());
    }

    @Test
    @DisplayName("A burguer should not be considered pasta")
    void a_burguer_should_not_be_considered_pasta() {
        Food testFood = new Food(expectedName, expectedClue, burguerEqualsToPasta);
        assertFalse(testFood.isPasta());
    }
}
