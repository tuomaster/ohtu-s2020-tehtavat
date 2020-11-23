package ohtu;

public class TennisGame {

    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;
    private String player1;
    private String player2;

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            pointsPlayer1 += 1;
        } else {
            pointsPlayer2 += 1;
        }
    }

    public String getScore() {
        if (pointsEven()) {
            return getScoreWhenPointsEven();
        } else if (onePlayerHasFourOrMorePoints()) {
            return getScoreWhenAdvantageOrWin();
        } else {
            return getScoreForPlayer(pointsPlayer1) + "-" + getScoreForPlayer(pointsPlayer2);
        }
    }

    private String getScoreWhenPointsEven() {
        switch (pointsPlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private String getScoreWhenAdvantageOrWin() {
        if (player1LeadsByOnePoint()) {
            return "Advantage player1";
        } else if (player2LeadsByOnePoint()) {
            return "Advantage player2";
        } else if (player1LeadsByMoreThanTwoPoints()) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getScoreForPlayer(int playersPoints) {
        switch (playersPoints) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private boolean pointsEven() {
        if (pointsPlayer1 == pointsPlayer2) {
            return true;
        }
        return false;
    }

    private boolean onePlayerHasFourOrMorePoints() {
        if (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) {
            return true;
        }
        return false;
    }

    private boolean player1LeadsByOnePoint() {
        if (pointsPlayer1 - pointsPlayer2 == 1) {
            return true;
        }
        return false;
    }

    private boolean player2LeadsByOnePoint() {
        if (pointsPlayer1 - pointsPlayer2 == -1) {
            return true;
        }
        return false;
    }

    private boolean player1LeadsByMoreThanTwoPoints() {
        if (pointsPlayer1 - pointsPlayer2 >= 2) {
            return true;
        }
        return false;
    }
}
