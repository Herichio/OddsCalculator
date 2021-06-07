package com.oddscalculator.dealer;

import com.oddscalculator.card.Card;
import com.oddscalculator.deck.Deck;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> communityCards;
    private Deck globalDeck;

    public Dealer(Deck deck) {
        this.globalDeck = deck;
        this.communityCards = new ArrayList<>();
    }

    public int getCommunityCardCount() {
        return communityCards.size();
    }

    public Card addCommunityCard() {
        this.communityCards.add(this.globalDeck.getTopCard());
        return globalDeck.getTopCard();
    }

    public Deck getGlobalDeck() {
        return globalDeck;
    }

    public Card getCommunityCard(int position) {
        return communityCards.get(position);
    }

}
