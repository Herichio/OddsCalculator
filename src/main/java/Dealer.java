import java.util.ArrayList;

public class Dealer {
    int cardCount;
    int communityCardCount;
    ArrayList<Card> communityCards;
    Deck globalDeck;

    public Dealer(Deck deck) {
        this.globalDeck = deck;
        this.cardCount = deck.getCardCount();
        this.communityCards = new ArrayList<>();
        this.communityCardCount = communityCards.size();
    }

    public int getCardCount() {
        return cardCount;
    }

    public int getCommunityCardCount() {
        this.communityCardCount = communityCards.size();
        return communityCardCount;
    }

    public void addCommunityCard(int amount) {
        for (int i = 0; i < amount; i++) {
            this.communityCards.add(this.globalDeck.getTopCard());
        }
    }

    public Card getCard(int position) {
        return communityCards.get(position);
    }

}
