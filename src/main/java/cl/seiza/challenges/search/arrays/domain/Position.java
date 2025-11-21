package cl.seiza.challenges.search.arrays.domain;

public class Position {
    private int start;
    private int end;

    public Position(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isSamePosition (int expectedStart, int expectedEnd) {
        return this.start == expectedStart && this.end == expectedEnd;
    }
}
