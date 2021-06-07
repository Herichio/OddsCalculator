package com.oddscalculator.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    public void getSuite() {
        Card card = new Card(Card.Suite.DIAMONDS, Card.Value.ACE);
        assertEquals(Card.Suite.DIAMONDS, card.getSuite());
    }

    @Test
    public void getValue() {
        Card card = new Card(Card.Suite.DIAMONDS, Card.Value.ACE);
        assertEquals(Card.Value.ACE, card.getValue());
    }

    @Test
    public void displayCard() {
        Card card = new Card(Card.Suite.DIAMONDS, Card.Value.ACE);
        assertEquals("AD", card.displayCard());
    }
}