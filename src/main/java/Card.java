public class Card {
    Suite suite;
    Value value;

    public enum Suite{
        DIAMONDS, CLUBS, HEARTS, SPADES
    }

    public enum Value{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public Card(Suite initialSuite, Value initialValue) {
        this.suite = initialSuite;
        this.value = initialValue;
    }

    public Suite getSuite() {
        return suite;
    }

    public Value getValue() {
        return value;
    }
}
