package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (this.gameIsEven()) {
            return this.generateEvenScoreString();
        } else if (this.thereIsWinOrAdvantage()) {
            return this.generateWinOrAdvantageString();
        } else {
            return this.generateNormalScoreString();
        }
    }

    private String generateEvenScoreString() {
        if (player1Score == 4) {
            return "Deuce";
        } else {
            return this.generateScoreStringForPoints(player1Score) + "-All";
        }
    }

    private String generateWinOrAdvantageString() {
        if (this.isWinning(player1Score, player2Score)) {
            return "Win for player1";
        } else if (this.isWinning(player2Score, player1Score)) {
            return "Win for player2";
        } else if (this.hasAdvantage(player1Score, player2Score)) {
            return "Advantage player1";
        } else {
            return "Advantage player2";
        }
    }

    private boolean isWinning(int score, int scoreToBeComparedWith) {
        return (score - scoreToBeComparedWith >= 2);
    }

    private boolean hasAdvantage(int score, int scoreToBeComparedWith) {
        return (score - scoreToBeComparedWith == 1);
    }

    private String generateNormalScoreString() {
        String score = this.generateScoreStringForPoints(player1Score);
        score += "-";
        score += this.generateScoreStringForPoints(player2Score);
        return score;
    }

    private String generateScoreStringForPoints(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }       
    }

    private boolean gameIsEven() {
        return player1Score == player2Score;
    }

    private boolean thereIsWinOrAdvantage() {
        return player1Score >= 4 || player2Score >= 4;
    }
}
