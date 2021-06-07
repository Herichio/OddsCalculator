package com.oddscalculator.player;

import com.oddscalculator.card.Card;

public interface Player {
    void setName(String newName);
    void setCardLimit(int newLimit);
    String getName();
    int getCardLimit();
    Card getCardInHand(int position);
    void addCard(Card newCard);
}
