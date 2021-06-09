package com.oddscalculator.game;

import com.oddscalculator.dealer.Dealer;
import com.oddscalculator.deck.Deck;
import com.oddscalculator.player.NormalPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private NormalPlayer mainPlayer;
    private Deck globalDeck;
    private Dealer dealer;
    private ArrayList<NormalPlayer> playerArrayList;
    private boolean continuation;

    public Game(String initialCommand) {
        initializeGame(initialCommand);
    }

    public void initializeGame(String initialCommand) {
        this.mainPlayer = new NormalPlayer("Main Player");
        this.globalDeck = new Deck();
        this.dealer = new Dealer(globalDeck);
        this.playerArrayList = new ArrayList<>();
        this.playerArrayList.add(mainPlayer);
        this.globalDeck.shuffleDeck();
        this.continuation = true;

        Scanner input = new Scanner(System.in);
        String commandString = initialCommand;
        command(commandString);
        while (this.continuation) {
            System.out.println("Enter 'Help' for a list of commands");
            displayState();
            commandString = input.nextLine();
            command(commandString);
        }
    }

    public void setGlobalDeck(Deck deck) {
        this.globalDeck = deck;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public NormalPlayer getMainPlayer() {
        return mainPlayer;
    }

    public Deck getGlobalDeck() {
        return globalDeck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public ArrayList<NormalPlayer> getPlayerArrayList() {
        return playerArrayList;
    }

    public void promptPlayerName(NormalPlayer player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter player name:");
        player.setName(input.nextLine());
    }

    public void displayState() {
        // display dealer info
        System.out.println("\nDealer"
                + "\nCards left: " + this.globalDeck.getCardCount()
                + "\nCommunity Cards: ");
        for (int i = 0; i < this.dealer.getCommunityCardCount(); i++) {
            System.out.print(dealer.getCommunityCard(i).displayCard() + " ");
        }
        System.out.print("\n");

        //display info for each player
        for (NormalPlayer p : playerArrayList) {
            System.out.println("\n" + p.getName()
                    + "\nCards in hand: ");
            for (int i = 0; i < p.getCardCount(); i++) {
                System.out.print(p.getCardInHand(i).displayCard() + " ");
            }
        }
        System.out.print("\n");
    }

    public void addCardToPlayer(NormalPlayer player, int amount) {
        for (int i = 0; i < amount; i++) {
            player.addCard(this.globalDeck.getTopCard());
            this.globalDeck.removeTopCard();
        }
    }

    public void addCardToCommunity(int amount) {
        for (int i = 0; i < amount; i++) {
            this.dealer.addCommunityCard();
            this.dealer.getGlobalDeck().removeTopCard();
        }
    }

    public void addPlayer(NormalPlayer player) {
        this.playerArrayList.add(player);
    }

    public void removePlayer(NormalPlayer player) {
        for (int i = 0; i < player.getCardCount(); i++) {
            this.globalDeck.addCard(player.getCardInHand(i));
        }
        this.globalDeck.shuffleDeck();
        this.playerArrayList.remove(player);
    }

    public void command(String s) {
        switch (s) {
            case "Change Name":
            case "CN": {
                Scanner input = new Scanner(System.in);
                System.out.println("Which Player?");
                String temp = input.nextLine();
                for (NormalPlayer p : playerArrayList) {
                    if (p.getName().equals(temp)) {
                        promptPlayerName(p);
                    }
                }
                break;
            }
            case "Add Community Card":
            case "ACC": {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter number of cards to be added:");
                addCardToCommunity(input.nextInt());
                break;
            }
            case "Add Player Card":
            case "APC": {
                Scanner input = new Scanner(System.in);
                System.out.println("Which Player?");
                String temp = input.nextLine();
                for (NormalPlayer p : playerArrayList) {
                    if (p.getName().equals(temp)) {
                        addCardToPlayer(p, 1);
                    }
                }
                break;
            }
            case "Add Player":
            case "AP": {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter new Player name:");
                String temp = input.nextLine();
                NormalPlayer player = new NormalPlayer(temp);
                addPlayer(player);
                break;
            }
            case "Remove Player":
            case "RP": {
                Scanner input = new Scanner(System.in);
                System.out.println("Which Player?");
                String temp = input.nextLine();
                boolean containsPlayer = false;
                NormalPlayer selectedPlayer = null;
                for (NormalPlayer p : playerArrayList) {
                    if (p.getName().equals(temp)) {
                        containsPlayer = true;
                        selectedPlayer = p;
                    }
                }
                if (containsPlayer) {
                    removePlayer(selectedPlayer);
                } else {
                    System.out.println("Invalid Player");
                }
                break;
            }
            case "Help":
                commandUsage();
                break;
            case "Exit":
                continuation = false;
            default:
                System.out.println("Invalid Command");
                break;
        }
    }

    public void commandUsage() {
        System.out.println("Change Name or CN" +
                "\n     - Changes the name of a player" +
                "\nAdd Community Card or ACC" +
                "\n     - Adds an amount of cards to the Community Cards pile" +
                "\nAdd Player Card or APC" +
                "\n     - Adds one card to a player" +
                "\nAdd Player or AP" +
                "\n     - Adds a new player to the game" +
                "\nRemove Player or RP" +
                "\n     - Removes a player from the game" +
                "\nExit" +
                "\n     - Exits the game");
    }
}
