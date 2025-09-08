package test;

import Manage.Managers;
import Manage.TaskManager;
import Tasks.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = Managers.getDefault();
    }

    @Test
    void shouldAddAndFindTask() {
        Task task = new Task();
        task.setName("Test Task");
        int taskId = manager.createTask(task);

        Task foundTask = manager.getTaskById(taskId);
        assertNotNull(foundTask, "Задача должна находиться по id");
        assertEquals("Test Task", foundTask.getName(), "Названия задач должны совпадать");
    }
}