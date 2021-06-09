package com.oddscalculator.deck;

import com.oddscalculator.card.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void getCardCount() {
        Deck deck = new Deck();
        assertEquals(52, deck.getCardCount());
    }

    @Test
    void removeTopCard() {
        Deck deck = new Deck();
        Card card1 = deck.getTopCard();
        Card card2 = deck.removeTopCard();
        assertTrue(deck.getCardCount() == 51 && card1 == card2);
    }

    @Test
    void shuffleDeck() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck2.shuffleDeck();
        assertNotSame(deck1, deck2);
    }

    @Test
    void getTopCard() {
        Deck deck = new Deck();
        Card card = deck.getTopCard();
        assertTrue(card.getSuite() == Card.Suite.DIAMONDS && card.getValue() == Card.Value.TWO);
    }

    @Test
    void addCard() {
        Deck deck = new Deck();
        Card card = new Card(Card.Suite.DIAMONDS, Card.Value.ACE);
        deck.addCard(card);
        assertEquals(53, deck.getCardCount());
    }
}