package model;

public class Player {
    private int score;
    private int totalScore;
    private int maxCompleteLevel;
    private int playerName;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getMaxCompleteLevel() {
        return maxCompleteLevel;
    }

    public void setMaxCompleteLevel(int maxCompleteLevel) {
        this.maxCompleteLevel = maxCompleteLevel;
    }

    public int getPlayerName() {
        return playerName;
    }

    public void setPlayerName(int playerName) {
        this.playerName = playerName;
    }
}
