package org.example.food;

public class Food {
    private String name;
    private String clue;
    private boolean isPasta;

    public Food(String name, String clue, boolean isPasta) {
        this.name = name;
        this.clue = clue;
        this.isPasta = isPasta;
    }

    public String getName() {
        return name;
    }

    public String getClue() {
        return clue;
    }

    public boolean isPasta() {
        return isPasta;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public void setPasta(boolean isPasta) {
        this.isPasta = isPasta;
    }
}
