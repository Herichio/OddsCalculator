package com.oddscalculator.dealer;

import com.oddscalculator.card.Card;
import com.oddscalculator.deck.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    void getCommunityCardCount() {
        Dealer dealer = new Dealer(new Deck());
        assertEquals(0, dealer.getCommunityCardCount());
    }

    @Test
    void addCommunityCard() {
        Dealer dealer = new Dealer(new Deck());
        dealer.addCommunityCard();
        assertTrue(dealer.getCommunityCardCount() == 1);
    }

    @Test
    void getGlobalDeck() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        assertEquals(deck, dealer.getGlobalDeck());
    }

    @Test
    void getCommunityCard() {
        Dealer dealer = new Dealer(new Deck());
        Card card = dealer.getGlobalDeck().getTopCard();
        dealer.addCommunityCard();
        assertEquals(card, dealer.getCommunityCard(0));
    }
}