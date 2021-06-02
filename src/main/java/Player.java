import java.util.ArrayList;

public class Player {
    String name;
    int cardLimit;
    ArrayList<Card> cards;

    public Player(String initialName) {
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

    public void addCard() {

    }
}
