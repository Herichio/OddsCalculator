package com.oddscalculator.chance;

import com.oddscalculator.card.Card;
import com.oddscalculator.deck.Deck;
import com.oddscalculator.player.NormalPlayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChanceTest {

    @Test
    void chanceOfPairWithOneUnknown() {
        NormalPlayer player = new NormalPlayer("Bill");
        Deck globalDeck = new Deck();
        globalDeck.shuffleDeck();
        ArrayList<Card> communityCards = new ArrayList<Card>();
        double percentChance;

        communityCards.add(globalDeck.getTopCard());
        globalDeck.removeTopCard();
        communityCards.add(globalDeck.getTopCard());
        globalDeck.removeTopCard();
        communityCards.add(globalDeck.getTopCard());
        globalDeck.removeTopCard();
        communityCards.add(globalDeck.getTopCard());
        globalDeck.removeTopCard();

        player.addCard(globalDeck.getTopCard());
        globalDeck.removeTopCard();
        player.addCard(globalDeck.getTopCard());
        globalDeck.removeTopCard();

        Chance playerChance = new Chance(1, globalDeck, 0, player);
        percentChance = playerChance.chanceOf(ComboType.PAIR, communityCards);

        System.out.println(percentChance);
        assertTrue(0 <= percentChance && percentChance <= 100);
    }

    @Test
    void chanceOfPairWithTwoUnknown() {
        NormalPlayer player = new NormalPlayer("Bill");
        Deck globalDeck = new Deck();
        globalDeck.shuffleDeck();
        ArrayList<Card> communityCards = new ArrayList<Card>();
        double percentChance;

        communityCards.add(globalDeck.getTopCard());
        globalDeck.removeTopCard();
        communityCards.add(globalDeck.getTopCard());
        globalDeck.removeTopCard();
        communityCards.add(globalDeck.getTopCard());
        globalDeck.removeTopCard();

        player.addCard(globalDeck.getTopCard());
        globalDeck.removeTopCard();
        player.addCard(globalDeck.getTopCard());
        globalDeck.removeTopCard();

        Chance playerChance = new Chance(1, globalDeck, 0, player);
        percentChance = playerChance.chanceOf(ComboType.PAIR, communityCards);

        System.out.println(percentChance);
        assertTrue(0 <= percentChance && percentChance <= 100);
    }
}