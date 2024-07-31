package org.example.food;

public class Food {

    private String name;
    private String clue;

    public Food(String name, String clue) {
        this.name = name;
        this.clue = clue;
    }

    public String getName() {
        return name;
    }

    public String getClue() {
        return clue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

}
