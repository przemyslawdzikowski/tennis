package com.example.tennis;

public class PlayLogic {
    
    protected static void setPoints(Player player1, Player player2) {
        if (player1.getCurrentScore() > player2.getCurrentScore()) {
            if ((player2.getAdvantage() - player1.getAdvantage()) <= 0) {
                player1.incrementPoints();
            }    
            if (player2.getAdvantage() > 0) {
                player2.decrementAdvantage();
            }
        }
        if (player2.getCurrentScore() > player1.getCurrentScore()) {
            if ((player1.getAdvantage() - player2.getAdvantage()) <= 0) {
                player2.incrementPoints();
            }
            if (player1.getAdvantage() > 0) {
                player1.decrementAdvantage();
            }
        }
    }

    protected static Integer checkResult(Player player1, Player player2) {
        Integer result = PlayConstants.IN_PLAY;
        if ((player1.getPoints() == PlayConstants.VALUE_OF_FOURTY)
            && (player1.getAdvantage() == 1)
            && (player2.getPoints() < PlayConstants.VALUE_OF_FOURTY)) {
            result = PlayConstants.WIN_PLAYER_ONE;
        }
        if ((player2.getPoints() == PlayConstants.VALUE_OF_FOURTY)
            && (player2.getAdvantage() == 1)
            && (player1.getPoints() < PlayConstants.VALUE_OF_FOURTY)) {
            result = PlayConstants.WIN_PLAYER_TWO;
        }
        if ((player1.getPoints() == PlayConstants.VALUE_OF_FOURTY)
            && (player2.getPoints() == PlayConstants.VALUE_OF_FOURTY)) {
            if ((player1.getAdvantage() == 2) && (player2.getAdvantage() == 0)) {
                result = PlayConstants.WIN_PLAYER_ONE;
            }
            if ((player1.getAdvantage() == 0) && (player2.getAdvantage() == 2)) {
                result = PlayConstants.WIN_PLAYER_TWO;
            }
        }
        return result;
    }
}
