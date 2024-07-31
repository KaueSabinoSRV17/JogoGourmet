package org.example.questionpool;

import java.util.EmptyStackException;
import java.util.Stack;

import org.example.food.Food;

public class QuestionPool {

    private Stack<Food> mainQuestionStack;
    private Stack<Food> currentQuestionStack;

    public QuestionPool(Food firstFood) {
        mainQuestionStack = new Stack<Food>();
        currentQuestionStack = new Stack<Food>();
        mainQuestionStack.add(firstFood);
        currentQuestionStack.add(firstFood);
    }

    public void addFood(Food food) {
        mainQuestionStack.add(food);
    }

    public Food answerNoToCurrentQuestion() {
        if (currentQuestionStack.isEmpty())
            throw new EmptyStackException();

        Food food = currentQuestionStack.pop();
        return food;
    }

    public String askCurrentQuestion() {
        if (currentQuestionStack.isEmpty())
            throw new EmptyStackException();

        Food currentQuestion = currentQuestionStack.peek();
        if (currentQuestionStack.size() == 1) {
            return currentQuestion.getName();
        } else {
            return currentQuestion.getClue();
        }
    }

    public void restartGame() {
        currentQuestionStack.clear();
        currentQuestionStack.addAll(mainQuestionStack);
    }

    public Stack<Food> getCurrentQuestionStack() {
        return currentQuestionStack;
    }
}
