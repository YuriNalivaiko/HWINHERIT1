import java.util.Objects;

public class Task {
    protected int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean matches(String query) {
        // Базовый класс Task не имеет своего контента для поиска
        return false;
    }

    public boolean search(String query) {
        return matches(query);
    }

    public static void main(String[] args) {
        Task task = new Task(1);
        System.out.println("Task id: " + task.getId());
    }
}