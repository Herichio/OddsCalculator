import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private int cardCount;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Card.Suite suite: Card.Suite.values()) {
            for (Card.Value value: Card.Value.values()) {
                this.cards.add(new Card(suite, value));
            }
        }
    }

    public int getCardCount() {
        this.cardCount = cards.size();
        return cardCount;
    }

    public void removeTopCard() {
        this.cards.remove(0);
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public Card getTopCard() {
        return cards.get(0);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }
}
