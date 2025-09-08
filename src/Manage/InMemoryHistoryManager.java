package Manage;

import Tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {

    private final List<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        history.remove(task);
        history.add(task);
        if (history.size() > 10) {
            history.remove(0);
        }
    }


    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }


}
