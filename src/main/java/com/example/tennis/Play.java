package com.example.tennis;

import java.util.Random;

public class Play {

    public Play() {
    }

    protected void simulation() {
        Player player1 = new Player(0);
        Player player2 = new Player(0);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        Integer gameResult = Integer.valueOf(-1);

        System.out.println("Simulation:");
        do {
            player1.setCurrentScore(Integer.valueOf(rand.nextInt(100)));
            player2.setCurrentScore(Integer.valueOf(rand.nextInt(100)));
            PlayLogic.setPoints(player1, player2);
            gameResult = PlayLogic.checkResult(player1, player2);

            System.out.println(String.format("player 1 currentScore %s, player 2 currentScore %s, " +
                "player 1 points %s advantage %s, player 2 points %s advantage %s", 
                player1.getCurrentScore(), player2.getCurrentScore(), 
                player1.getPoints(), player1.getAdvantage(), player2.getPoints(), player2.getAdvantage()));

        } while (PlayConstants.IN_PLAY.equals(gameResult));
        
        if (PlayConstants.WIN_PLAYER_ONE.equals(gameResult)) {
            System.out.println("player 1 has won");
        }
        if (PlayConstants.WIN_PLAYER_TWO.equals(gameResult)) {
            System.out.println("player 2 has won");
        }
    }
}
