import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int playerCount;
    private NormalPlayer mainPlayer;
    private Deck globalDeck;
    private Dealer dealer;
    private ArrayList<NormalPlayer> playerArrayList;

    public Game() {
        this.playerCount = 1;
        this.mainPlayer = new NormalPlayer("Player 1");
        this.globalDeck = new Deck();
        this.dealer = new Dealer(globalDeck);
        this.playerArrayList = new ArrayList<>();
        this.playerArrayList.add(mainPlayer);
        this.globalDeck.shuffleDeck();
        promptPlayerName(mainPlayer);

        System.out.println(Card.Value.SIX.compareTo(Card.Value.ACE));

        Scanner input = new Scanner(System.in);
        String commandString = "";
        while (true) {
            System.out.println("Enter 'Help' for a list of commands");
            displayState();
            commandString = input.nextLine();
            command(commandString);
        }
    }

    public void promptPlayerName(NormalPlayer player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new name:");
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
                System.out.print(p.getCard(i).displayCard() + " ");
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

    public void addPlayer(String name) {
        this.playerArrayList.add(new NormalPlayer(name));
    }

    public void removePlayer(NormalPlayer player) {
        for (int i = 0; i < player.getCardCount(); i++) {
            this.globalDeck.addCard(player.getCard(i));
        }
        this.playerArrayList.remove(player);
    }

    public void command(String s) {
        if (s.equals("Change Name") || s.equals("CN")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Which Player?");
            String temp = input.nextLine();
            for (NormalPlayer p: playerArrayList) {
                if (p.getName().equals(temp)) {
                    promptPlayerName(p);
                }
            }
        } else if (s.equals("Add Community Card") || s.equals("ACC")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number of cards to be added:");
            addCardToCommunity(input.nextInt());
        } else if (s.equals("Add Player Card") || s.equals("APC")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Which Player?");
            String temp = input.nextLine();
            for (NormalPlayer p : playerArrayList) {
                if (p.getName().equals(temp)) {
                    addCardToPlayer(p, 1);
                }
            }
        } else if (s.equals("Add Player") || s.equals("AP")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter new Player name:");
            String temp = input.nextLine();
            addPlayer(temp);
        } else if (s.equals("Remove Player") || s.equals("RP")) {
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
        } else if (s.equals("Help")) {
            commandUsage();
        } else if (s.equals("Exit")) {
            System.exit(0);
        } else {
            System.out.println("Invalid Command");
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
