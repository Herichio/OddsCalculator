package com.oddscalculator.chance;

import com.oddscalculator.card.Card;
import com.oddscalculator.player.NormalPlayer;

import java.util.ArrayList;

public class Chance {
    private int playerCount;
    private int cardCountOfDeck;
    private int playerPosition;
    private NormalPlayer player;

    public Chance(int playerCount, int cardCountOfDeck, int playerPosition, NormalPlayer player) {
        this.playerCount = playerCount;
        this.cardCountOfDeck = cardCountOfDeck;
        this.playerPosition = playerPosition;
        this.player = player;
    }

    public double chanceOf(ComboType wantedCombo, ArrayList<Card> communityCards) {
        switch (wantedCombo) {
            case HIGHCARD:
                return 100.0;
            case PAIR:

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
                return 0;
        }
    }
}
