package main.com.example.tennis;

public class Player {
    private int points = 0;
    private int currentScore = 0;
    private int advantage = 0;
    

    public Player() {
    }

    public Player(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    } 

    public void incrementPoints() {
        if (this.points == 40) {
            this.advantage++;
        }
        if (this.points == 30) {
            this.points = this.points + 10;
        }
        if (this.points < 30) {
            this.points = this.points + 15;
        }
    }

    public Integer getCurrentScore() {
        return this.currentScore;
    }

    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }

    public int getAdvantage() {
        return this.advantage;
    }

    public void decrementAdvantage() {
        this.advantage--;
    }
}
