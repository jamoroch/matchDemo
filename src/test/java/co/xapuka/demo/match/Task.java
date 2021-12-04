package co.xapuka.demo.match;

import java.util.Objects;

public class Task {

    public enum TaskType {
        DIFFICULT, IMPOSIBLE
    }

    private final int value;

    public Task(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return value == task.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
