import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {

    @Test
    public void testSearchMultipleTasksFound() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Write documentation"));
        todos.add(new SimpleTask(2, "Read a book"));
        todos.add(new SimpleTask(3, "Write tests"));

        Task[] result = todos.search("Write");

        Assertions.assertEquals(2, result.length);
        Assertions.assertArrayEquals(
                new String[]{"Write documentation", "Write tests"},
                new String[]{((SimpleTask) result[0]).getTitle(), ((SimpleTask) result[1]).getTitle()}
        );
    }

    @Test
    public void testSearchSingleTaskFound() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Write documentation"));

        Task[] result = todos.search("Write");

        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals("Write documentation", ((SimpleTask) result[0]).getTitle());
    }

    @Test
    public void testSearchNoTaskFound() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Write documentation"));

        Task[] result = todos.search("Read");

        Assertions.assertEquals(0, result.length);
    }
}
