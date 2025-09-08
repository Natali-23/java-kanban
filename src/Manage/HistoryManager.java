package Manage;
import java.util.*;

import Tasks.Task;

public interface HistoryManager {
    void  add(Task task);
    List<Task> getHistory();
}
