package com.example.tennis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TennisApplicationTests {

    @Test
    void shouldWinPlayer1() {
        // given
        Player player1 = new Player(40);
        Player player2 = new Player(30);
        
        // when
        player1.setCurrentScore(9);
        player2.setCurrentScore(3);
        PlayLogic.setPoints(player1, player2);
        Integer result = PlayLogic.checkResult(player1, player2);
        
        //then
        assertEquals(PlayConstants.WIN_PLAYER_ONE, result);
        assertNotEquals(PlayConstants.WIN_PLAYER_TWO, result);
        assertNotEquals(PlayConstants.IN_PLAY, result);
    }

    @Test
    void shouldWinPlayer2() {
        // given
        Player player1 = new Player(40);
        Player player2 = new Player(40);
        
        // when
        player1.setCurrentScore(3);
        player2.setCurrentScore(9);
        PlayLogic.setPoints(player1, player2);
        
        player1.setCurrentScore(4);
        player2.setCurrentScore(8);
        PlayLogic.setPoints(player1, player2);

        Integer result = PlayLogic.checkResult(player1, player2);
        
        // then
        assertEquals(PlayConstants.WIN_PLAYER_TWO, result);
        assertNotEquals(PlayConstants.WIN_PLAYER_ONE, result);
        assertNotEquals(PlayConstants.IN_PLAY, result);
    }

    @Test
    void shouldGameIsInPlay() {
        // given
        Player player1 = new Player(40);
        Player player2 = new Player(40);

        // when
        player1.setCurrentScore(3);
        player2.setCurrentScore(9);
        PlayLogic.setPoints(player1, player2);

        Integer result = PlayLogic.checkResult(player1, player2);
        
        //then
        assertEquals(PlayConstants.IN_PLAY, result);
        assertNotEquals(PlayConstants.WIN_PLAYER_ONE, result);
        assertNotEquals(PlayConstants.WIN_PLAYER_TWO, result);
    }
}
