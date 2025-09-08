package Tasks;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private final List<Integer> subtaskIds = new ArrayList<>();

    public void addSubtask(int id) {
        subtaskIds.add(id);
    }

    public void removeSubtask(int id) {
        subtaskIds.remove((Integer) id);
    }

    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", status=" + getStatus() +
                ", subtasks=" + subtaskIds +
                '}';
    }
}
