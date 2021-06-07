package com.oddscalculator.player;

import com.oddscalculator.card.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalPlayerTest {

    @Test
    void setName() {
        NormalPlayer player = new NormalPlayer("Bob");
        player.setName("Jim");
        assertEquals("Jim", player.getName());
    }

    @Test
    void setCardLimit() {
        NormalPlayer player = new NormalPlayer("Bob");
        player.setCardLimit(4);
        assertEquals(4,player.getCardLimit());
    }

    @Test
    void getName() {
        NormalPlayer player = new NormalPlayer("Bob");
        assertEquals("Bob", player.getName());
    }

    @Test
    void getCardLimit() {
        NormalPlayer player = new NormalPlayer("Bob");
        assertEquals(2, player.getCardLimit());
    }

    @Test
    void getCardInHand() {
        NormalPlayer player = new NormalPlayer("Bob");
        Card card = new Card(Card.Suite.DIAMONDS, Card.Value.ACE);
        player.addCard(card);
        assertEquals(card, player.getCardInHand(0));
    }

    @Test
    void getCardCount() {
        NormalPlayer player = new NormalPlayer("Bob");
        assertEquals(0, player.getCardCount());
    }
}