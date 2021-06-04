public class Card {
    private Suite suite;
    private Value value;

    public enum Suite{
        DIAMONDS("D"),
        CLUBS("C"),
        HEARTS("H"),
        SPADES("S");

        public final String label;

        private Suite(String label) {
            this.label = label;
        }
    }



    public enum Value{
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K"),
        ACE("A");

        public final String label;

        private Value(String label) {
            this.label = label;
        }
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

    public String displayCard() {
        return this.value.label + this.suite.label;
    }
}
