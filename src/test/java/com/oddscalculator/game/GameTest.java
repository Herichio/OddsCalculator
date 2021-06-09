package com.oddscalculator.game;

import com.oddscalculator.dealer.Dealer;
import com.oddscalculator.deck.Deck;
import com.oddscalculator.player.NormalPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void setGlobalDeck() {
        Game game = new Game("Exit");
        Deck deck = new Deck();
        game.setGlobalDeck(deck);
        assertEquals(deck, game.getGlobalDeck());
    }

    @Test
    void setDealer() {
        Game game = new Game("Exit");
        Dealer dealer = new Dealer(new Deck());
        game.setDealer(dealer);
        assertEquals(dealer, game.getDealer());
    }

    @Test
    void getMainPlayer() {
        Game game = new Game("Exit");
        assertEquals("Main Player", game.getMainPlayer().getName());
    }

    @Test
    void addCardToPlayer() {
        Game game = new Game("Exit");
        NormalPlayer player = new NormalPlayer("Bob");
        game.addPlayer(player);
        game.addCardToPlayer(player, 1);
        assertEquals(1, game.getPlayerArrayList().get(1).getCardCount());
    }

    @Test
    void addCardToCommunity() {
        Game game = new Game("Exit");
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        game.setDealer(dealer);
        game.addCardToCommunity(2);
        assertEquals(2, game.getDealer().getCommunityCardCount());
    }

    @Test
    void addPlayer() {
        Game game = new Game("Exit");
        NormalPlayer player = new NormalPlayer("Bob");
        game.addPlayer(player);
        assertEquals(2, game.getPlayerArrayList().size());
    }

    @Test
    void removePlayer() throws Exception{
        Game game = new Game("Exit");
        game.removePlayer(game.getMainPlayer());
        assertEquals(0, game.getPlayerArrayList().size());
    }
}