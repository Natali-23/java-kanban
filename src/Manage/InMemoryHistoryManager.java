package Manage;

import Tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {

    private final List<Task> history = new LinkedList<>();
    private static final int MAX_HISTORY_SIZE = 10;
    @Override
    public void add(Task task) {

        if (task == null) {
            return;
        }

        history.add(task);
        if ( history.size() > MAX_HISTORY_SIZE) {
            history.remove(0);
        }
    }


    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }


}
