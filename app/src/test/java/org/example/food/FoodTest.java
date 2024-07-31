package org.example.food;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

class AppTest {

    static String expectedName = "Burguer";
    static String expectedClue = "Has meat and cheese between two buns";

    @Test
    @DisplayName("A Food should have a name and a clue that leads to it")
    void a_food_should_have_a_name_and_a_clue_that_leads_to_it() {
        Food testFood = new Food(expectedName, expectedClue);
        assertEquals(expectedName, testFood.getName());
        assertEquals(expectedClue, testFood.getClue());
    }
    
}
