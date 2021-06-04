import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int playerCount;
    private Player mainPlayer;
    private Deck globalDeck;
    private Dealer dealer;
    private ArrayList<Player> playerArrayList;

    public Game() {
        this.playerCount = 1;
        this.mainPlayer = new Player("Player 1");
        this.globalDeck = new Deck();
        this.dealer = new Dealer(globalDeck);
        this.playerArrayList = new ArrayList<>();
        this.playerArrayList.add(mainPlayer);
        this.globalDeck.shuffleDeck();
        promptPlayerName(mainPlayer);

        Scanner input = new Scanner(System.in);
        String commandString = "";
        while (!commandString.equals("Exit")) {
            displayState();
            commandString = input.nextLine();
            command(commandString);
        }
    }

    public void promptPlayerName(Player player) {
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
        for (Player p : playerArrayList) {
            System.out.println("\n" + p.getName()
                    + "\nCards in hand: ");
            for (int i = 0; i < p.getCardCount(); i++) {
                System.out.print(p.getCard(i).displayCard() + " ");
            }
        }
        System.out.print("\n");
    }

    public void addCardToPlayer(Player player, int amount) {
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
        this.playerArrayList.add(new Player(name));
    }

    public void removePlayer(Player player) {
        for (int i = 0; i < player.getCardCount(); i++) {
            this.globalDeck.addCard(player.getCard(i));
        }
        this.playerArrayList.remove(player);
    }

    //TODO add command usage

    public void command(String s) {
        if (s.equals("Change Name")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Which Player?");
            String temp = input.nextLine();
            for (Player p: playerArrayList) {
                if (p.getName().equals(temp)) {
                    promptPlayerName(p);
                }
            }
        } else if (s.equals("Add Community Card")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number of cards to be added:");
            addCardToCommunity(input.nextInt());
        } else if (s.equals("Add Player Card")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Which Player?");
            String temp = input.nextLine();
            for (Player p : playerArrayList) {
                if (p.getName().equals(temp)) {
                    addCardToPlayer(p, 1);
                }
            }
        } else if (s.equals("Add Player")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter new Player name:");
            String temp = input.nextLine();
            addPlayer(temp);
        } else if (s.equals("Remove Player")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Which Player?");
            String temp = input.nextLine();
            boolean containsPlayer = false;
            Player selectedPlayer = null;
            for (Player p: playerArrayList) {
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
        } else {
            System.out.println("Invalid Command");
        }
    }
}
