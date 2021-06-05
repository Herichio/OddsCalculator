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
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 11),
        QUEEN("Q", 12),
        KING("K", 13),
        ACE("A", 14);

        public final String label;
        public final int intValue;

        private Value(String label, int intValue) {
            this.label = label;
            this.intValue = intValue;
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
