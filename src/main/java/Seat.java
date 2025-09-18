import java.util.Objects;

public class Seat {
    private final char row;
    private final int column;
    private final Grade grade;
    private boolean isReversed;

    public Seat(
        char row,
        int column,
        Grade grade,
        boolean isReversed
    ) {
        this.row = row;
        this.column = column;
        this.grade = grade;
        this.isReversed = isReversed;
    }

    public String getNumber() {
        return row + Integer.toString(column);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (!(object instanceof Seat seat)) return false;

        return row == seat.row &&
            column == seat.column &&
            grade == seat.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, grade);
    }
}
