package test;

import Manage.HistoryManager;
import Manage.Managers;
import Manage.TaskManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    void shouldReturnInitializedManagers() {
        TaskManager taskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();

        assertNotNull(taskManager, "Менеджер задач должен быть проинициализирован");
        assertNotNull(historyManager, "Менеджер истории должен быть проинициализирован");
    }
}