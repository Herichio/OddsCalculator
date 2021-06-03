import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    int cardCount;

    public Deck() {
        Card.Suite[] suite = {Card.Suite.DIAMONDS, Card.Suite.CLUBS, Card.Suite.HEARTS, Card.Suite.SPADES};
        Card.Value[] value = {Card.Value.TWO, Card.Value.THREE, Card.Value.FOUR,
                Card.Value.FIVE, Card.Value.SIX, Card.Value.SEVEN,
                Card.Value.EIGHT, Card.Value.NINE, Card.Value.TEN,
                Card.Value.JACK, Card.Value.QUEEN, Card.Value.KING,
                Card.Value.ACE};
        this.cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new Card(suite[i], value[j]));
            }
        }
    }

    public int getCardCount() {
        this.cardCount = cards.size();
        return cardCount;
    }

    public void removeTopCard(int amount) {
        for (int i = 0; i < amount; i++) {
            this.cards.remove(0);
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public Card getTopCard() {
        return cards.get(0);
    }
}
