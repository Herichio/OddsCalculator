import java.util.ArrayList;

public class Player {
    String name;
    int cardLimit;
    int cardCount;
    ArrayList<Card> cards;

    public Player(String initialName) {
        this.name = initialName;
        this.cardLimit = 2;
        this.cards = new ArrayList<Card>();
        this.cardCount = this.cards.size();
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

    public Card getCard(int position) {
        return cards.get(position);
    }

    public int getCardCount() {
        this.cardCount = this.cards.size();
        return cardCount;
    }

    public void addCard(Card newCard) {
        this.cards.add(newCard);
    }
}
