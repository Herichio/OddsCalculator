import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    int playerCount;
    Player mainPlayer;
    Deck globalDeck;
    Dealer dealer;
    ArrayList<Player> playerArrayList;

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
            commandString = input.nextLine();
            display();
            command(commandString);
        }
    }

    public void promptPlayerName(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new name:");
        player.setName(input.nextLine());
    }

    public void display() {
        // display dealer info
        System.out.println("\nDealer"
                + "\nCards left: " + this.globalDeck.getCardCount()
                + "\nCommunity Cards: ");
        for (int i = 0; i < this.dealer.getCommunityCardCount(); i++) {
            System.out.print(dealer.getCard(i).displayCard() + " ");
        }

        //display info for each player
        for (Player p : playerArrayList) {
            System.out.println("\n" + p.getName()
                    + "\nCards in hand: ");
            for (int i = 0; i < p.getCardCount(); i++) {
                System.out.print(p.getCard(i).displayCard() + " ");
            }
        }
    }

    public void addCardToPlayer(Player player, int amount) {
        for (int i = 0; i < amount; i++) {
            player.addCard(this.globalDeck.getTopCard());
            this.globalDeck.removeTopCard(1);
        }
    }

    public void addCardToCommunity(int amount) {
        this.dealer.addCommunityCard(amount);
        this.globalDeck.removeTopCard(amount);
    }

    public void addPlayer(String name) {
        playerArrayList.add(new Player(name));
    }

    public void command(String s) {
        if (s.equals("Change Name")) {
            Scanner input = new Scanner(System.in);
            String temp = input.nextLine();
            for (Player p: playerArrayList) {
                if (p.getName().equals(temp)) {
                    p.setName(temp);
                } else {
                    System.out.println("Invalid Player");
                }
            }
        } else if (s.equals("Add Community Card")) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number of cards to be added:");
            addCardToCommunity(input.nextInt());
        } else if (s.equals("Add Player Card")) {
            Scanner input = new Scanner(System.in);
            String temp = input.nextLine();
            for (Player p: playerArrayList) {
                if (p.getName().equals(temp)) {
                    addCardToPlayer(p, 1);
                } else {
                    System.out.println("Invalid Player");
                }
            }
        } else {
            System.out.println("Invalid Command");
        }
    }


}
