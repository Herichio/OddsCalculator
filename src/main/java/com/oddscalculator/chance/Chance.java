package com.oddscalculator.chance;

import com.oddscalculator.card.Card;
import com.oddscalculator.deck.Deck;
import com.oddscalculator.player.NormalPlayer;

import java.util.ArrayList;

public class Chance {
    private int playerCount;
    private int unknownCards;
    private int playerPosition;
    private NormalPlayer player;
    private Deck globalDeck;

    public Chance(int playerCount, Deck globalDeck, int playerPosition, NormalPlayer player) {
        this.playerCount = playerCount;
        this.globalDeck = globalDeck;
        this.unknownCards = globalDeck.getCardCount() + playerCount * 2;
        this.playerPosition = playerPosition;
        this.player = player;
    }

    public double chanceOf(ComboType wantedCombo, ArrayList<Card> communityCards) {
        final int TOTAL_COMMUNITY_CARDS = 5;
        ArrayList<Card> visibleCards = gatherVisibleCards(communityCards, this.player);
        int numOfHiddenCards = TOTAL_COMMUNITY_CARDS - communityCards.size();
        double result = 0;
        switch (wantedCombo) {
            case HIGHCARD:

                break;
            case PAIR:
                result = pair(visibleCards, numOfHiddenCards);
                break;
            case TWOPAIR:

                break;
            case THREEKIND:

                break;
            case STRAIGHT:

                break;
            case FLUSH:

                break;
            case FULLHOUSE:

                break;
            case FOURKIND:

                break;
            case STRAIGHTFLUSH:

                break;
            case ROYALFLUSH:

                break;
            default:
                result = 0;
        }
        return result;
    }

    private ArrayList<Card> gatherVisibleCards(ArrayList<Card> communityCards, NormalPlayer player) {
        ArrayList<Card> visibleCards = new ArrayList<Card>();
        visibleCards.add(player.getCardInHand(0));
        visibleCards.add(player.getCardInHand(1));
        visibleCards.addAll(communityCards);
        return visibleCards;
    }

    private double pair(ArrayList<Card> visibleCards, int numOfHiddenCards) {
        double pairInstances = 1;
        double totalOutcomes = 1;
        boolean hasPair = false;
        int matchCount = 0;
        for (int i = 0; i < visibleCards.size(); i++) {
            for (int j = 1; j < visibleCards.size() - i; j++) {
                if (visibleCards.get(i).getValue() == visibleCards.get(i + j).getValue()) {
                    matchCount++;
                }
            }
        }
        System.out.println(matchCount);
        if (matchCount == 1) {
            hasPair = true;
        } else if (matchCount > 1) {
            return 0.0;
        }
        for (int i = 0; i < numOfHiddenCards; i++) {
            if (hasPair) {
                pairInstances *= this.unknownCards-- - (visibleCards.size() * 3 - 4);
                totalOutcomes *= this.unknownCards-- + (visibleCards.size() * 3 - 4);
            } else {
                pairInstances *= visibleCards.size() * 3;
                totalOutcomes *= this.unknownCards--;
            }
        }
        return pairInstances / totalOutcomes * 100;
    }
}
