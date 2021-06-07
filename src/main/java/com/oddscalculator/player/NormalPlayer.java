package com.oddscalculator.player;

import com.oddscalculator.card.Card;

import java.util.ArrayList;

public class NormalPlayer implements Player {
    private String name;
    private int cardLimit;
    private ArrayList<Card> cards;

    public NormalPlayer(String initialName) {
        this.name = initialName;
        this.cardLimit = 2;
        this.cards = new ArrayList<Card>();
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setCardLimit(int newLimit) {
        this.cardLimit = newLimit;
    }

    public String getName() {
        return name;
    }

    public int getCardLimit() {
        return cardLimit;
    }

    public Card getCardInHand(int position) {
        return cards.get(position);
    }

    public int getCardCount() {
        return cards.size();
    }

    public void addCard(Card newCard) {
        this.cards.add(newCard);
    }
}
