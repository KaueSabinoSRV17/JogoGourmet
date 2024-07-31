package org.example.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.example.food.Food;
import org.example.questionpool.QuestionPool;

public class ButtonLogic implements ActionListener {

    private Food lasanha;
    private QuestionPool pastaPool;

    private Food chocolateCake;
    private QuestionPool nonPastaPool;

    public ButtonLogic() {
        lasanha = new Food("Lasanha", "N/A");
        pastaPool = new QuestionPool(lasanha);

        chocolateCake = new Food("Bolo de Chocolate", "N/A");
        nonPastaPool = new QuestionPool(chocolateCake);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        int pastaCode = BaseQuestion.show("Sua comida é uma massa?");
        boolean isPasta = pastaCode == 0;

        QuestionPool finalPool = isPasta ? pastaPool : nonPastaPool;

        while (true) {
            int questionCode = BaseQuestion.show(finalPool.askCurrentQuestion());
            if (questionCode == 0) {
                if (finalPool.getCurrentQuestionStack().size() != 1) {
                    questionCode = BaseQuestion.show(finalPool.revealFoodName());
                    if (questionCode == 0) {
                        SucessWindow.show();
                        finalPool.restartGame();
                        break;
                    } else {
                        finalPool.answerNoToCurrentQuestion();
                    }
                } else {
                    SucessWindow.show();
                    finalPool.restartGame();
                    break;
                }

            } else {
                if (finalPool.getCurrentQuestionStack().size() == 1) {
                    String name = JOptionPane.showInputDialog("Qual prato você pensou?");
                    String clue = JOptionPane.showInputDialog(
                        name + " é ________ mas " + finalPool.getCurrentQuestionStack().peek().getName() + " não."
                    );

                    Food correctAnswer = new Food(name, clue);
                    finalPool.addFood(correctAnswer);
                    finalPool.restartGame();
                    break;
                } else {
                    finalPool.answerNoToCurrentQuestion();
                }
            }
        }

    }
}
