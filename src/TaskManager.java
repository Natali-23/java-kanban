import java.util.*;

public class TaskManager {
    private int nextId = 1;

    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer, Epic> epics = new HashMap<>();
    private Map<Integer, Subtask> subtasks = new HashMap<>();

    private int generateId() {
        return nextId++;
    }


    public List<Task> getAllTasks() { return new ArrayList<>(tasks.values()); }

    public void deleteAllTasks() { tasks.clear(); }

    public Task getTaskById(int id) { return tasks.get(id); }

    public void createTask(Task task) {
        task.setId(generateId());
        tasks.put(task.getId(), task);
    }

    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
    }

    public void deleteTaskById(int id) { tasks.remove(id); }


    public List<Epic> getAllEpics() { return new ArrayList<>(epics.values()); }

    public void deleteAllEpics() {
        epics.clear();
        subtasks.clear();
    }

    public Epic getEpicById(int id) { return epics.get(id); }

    public void createEpic(Epic epic) {
        epic.setId(generateId());
        epics.put(epic.getId(), epic);
    }

    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
            updateEpicStatus(epic);
        }
    }

    public void deleteEpicById(int id) {
        Epic epic = epics.remove(id);
        if (epic != null) {
            for (int subId : epic.getSubtaskIds()) {
                subtasks.remove(subId);
            }
        }
    }


    public List<Subtask> getAllSubtasks() { return new ArrayList<>(subtasks.values()); }

    public void deleteAllSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.clearSubtaskIds();
            updateEpicStatus(epic);
        }
    }

    public Subtask getSubtaskById(int id) { return subtasks.get(id); }

    public void createSubtask(Subtask subtask) {
        subtask.setId(generateId());
        subtasks.put(subtask.getId(), subtask);

        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.addSubtaskId(subtask.getId());
            updateEpicStatus(epic);
        }
    }

    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
            Epic epic = epics.get(subtask.getEpicId());
            if (epic != null) {
                updateEpicStatus(epic);
            }
        }
    }

    public void deleteSubtaskById(int id) {
        Subtask subtask = subtasks.remove(id);
        if (subtask != null) {
            Epic epic = epics.get(subtask.getEpicId());
            if (epic != null) {
                epic.removeSubtaskId(id);
                updateEpicStatus(epic);
            }
        }
    }


    public List<Subtask> getSubtasksOfEpic(int epicId) {
        Epic epic = epics.get(epicId);
        List<Subtask> result = new ArrayList<>();
        if (epic != null) {
            for (int subId : epic.getSubtaskIds()) {
                result.add(subtasks.get(subId));
            }
        }
        return result;
    }


    private void updateEpicStatus(Epic epic) {
        List<Integer> subIds = epic.getSubtaskIds();

        if (subIds.isEmpty()) {
            epic.updateStatus(Status.NEW);
            return;
        }

        boolean allNew = true;
        boolean allDone = true;

        for (int subId : subIds) {
            Subtask subtask = subtasks.get(subId);
            if (subtask == null) continue;

            if (subtask.getStatus() != Status.NEW) allNew = false;
            if (subtask.getStatus() != Status.DONE) allDone = false;
        }

        if (allNew) {
            epic.updateStatus(Status.NEW);
        } else if (allDone) {
            epic.updateStatus(Status.DONE);
        } else {
            epic.updateStatus(Status.IN_PROGRESS);
        }
    }
}
