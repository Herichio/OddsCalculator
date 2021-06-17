package com.oddscalculator.chance;

public enum ComboType {
    HIGHCARD(10),
    PAIR(9),
    TWOPAIR(8),
    THREEKIND(7),
    STRAIGHT(6),
    FLUSH(5),
    FULLHOUSE(4),
    FOURKIND(3),
    STRAIGHTFLUSH(2),
    ROYALFLUSH(1);

    public final int value;

    private ComboType(int value) {
        this.value = value;
    }
}
