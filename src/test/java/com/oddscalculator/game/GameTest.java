package com.oddscalculator.game;

import com.oddscalculator.deck.Deck;
import com.oddscalculator.player.NormalPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testRemovePlayer() {
        Game game = new Game();
        Deck deck = new Deck();


        game.addPlayer("Bob");
        for (NormalPlayer p : game.getPlayerArrayList()) {
            if (p.getName().equals("Bob")) {
                game.removePlayer(p);
                assertTrue(!game.getPlayerArrayList().contains(p));
                break;
            }
        }
    }
}