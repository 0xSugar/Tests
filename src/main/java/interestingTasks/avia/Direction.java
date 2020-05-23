package interestingTasks.avia;

import java.util.Objects;

/**
 * вот что я хотел зделать.. но забыл)
 * Переопределение нужно для того, что бы адекватно работала мапа
 */

public class Direction {
    private City from;
    private City to;

    public Direction(City from, City to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return from == direction.from &&
                to == direction.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return String.format("Direction: from %s to %s", from, to);
    }
}
