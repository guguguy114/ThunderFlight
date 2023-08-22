package model;

public class Player {
    private final String playerAccount;
    private final String playerName;
    private int score;
    private int totalScore;
    private int maxCompleteLevel;
    public Player(String playerAccount, int maxCompleteLevel, String playerName, int totalScore) {
        this.playerAccount = playerAccount;
        this.maxCompleteLevel = maxCompleteLevel;
        this.playerName = playerName;
        this.totalScore = totalScore;
    }

    public String getPlayerAccount() {
        return playerAccount;
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
}
