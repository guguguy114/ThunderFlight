package model;

public class Player {
    private int score;
    private int totalScore;
    private int maxCompleteLevel;
    private String playerName;
    private String playerAccount;

    public Player(String playerAccount, int maxCompleteLevel, String playerName){
        this.playerAccount = playerAccount;
        this.maxCompleteLevel = maxCompleteLevel;
        this.playerName = playerName;
    }

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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
