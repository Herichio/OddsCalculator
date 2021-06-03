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

    public String displayCard() {
        String displaySuite = "";
        String displayValue = "";
        switch (suite) {
            case DIAMONDS:
                displaySuite = "D";
                break;
            case CLUBS:
                displaySuite = "C";
                break;
            case HEARTS:
                displaySuite = "H";
                break;
            case SPADES:
                displaySuite = "S";
                break;
        }

        switch (value) {
            case TWO:
                displayValue = "2";
                break;
            case THREE:
                displayValue = "3";
                break;
            case FOUR:
                displayValue = "4";
                break;
            case FIVE:
                displayValue = "5";
                break;
            case SIX:
                displayValue = "6";
                break;
            case SEVEN:
                displayValue = "7";
                break;
            case EIGHT:
                displayValue = "8";
                break;
            case NINE:
                displayValue = "9";
                break;
            case TEN:
                displayValue = "10";
                break;
            case JACK:
                displayValue = "J";
                break;
            case QUEEN:
                displayValue = "Q";
                break;
            case KING:
                displayValue = "K";
                break;
            case ACE:
                displayValue = "A";
                break;
        }

        return displayValue + displaySuite;
    }
}
