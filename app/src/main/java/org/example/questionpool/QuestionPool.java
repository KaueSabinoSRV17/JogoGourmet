package org.example.questionpool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.example.food.Food;

public class QuestionPool {

    private List<Food> foods;
    private boolean isPasta;

    private void startGame() {
        boolean isPasta = true;
        Food firstPastaFood = new Food("Carbonara", "Spagheti like dish, with pork fat, parmegiano reggiano and eggs as sauce", isPasta);
        Food firstNonPastaFood = new Food("Burguer", "Meat and cheese between 2 buns", !isPasta);

        this.foods = new ArrayList<Food>();
        this.foods.add(firstPastaFood);
        this.foods.add(firstNonPastaFood);
    }

    public List<Food> filteredFoods() {
        List<Food> filteredFoods = this.foods
            .stream()
            .filter(Food::isPasta)
            .collect(Collectors.toList());
        return filteredFoods;
    }

    // Thinking of adding another constructor, that receives to food objects instead of fixed initial food
    public QuestionPool() {
        this.startGame();
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public boolean isPasta() {
        return isPasta;
    }

    public void setPasta(boolean isPasta) {
        this.isPasta = isPasta;
    }
}
