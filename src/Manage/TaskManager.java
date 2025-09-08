package Manage;
import Tasks.Epic;
import Tasks.Subtask;
import Tasks.Task;

import java.util.List;




public interface TaskManager {
    int createTask(Task task);
    int createEpic(Epic epic);
    int createSubtask(Subtask subtask);
    void updateTask(Task task);
    void updateEpic(Epic epic);
    void updateSubtask(Subtask subtask);
    void deleteTaskById(int id);
    void deleteEpicById(int id);
    void deleteSubtaskById(int id);
    void deleteAllTasks();




    Task getTaskById(int id);

    Epic getEpicById(int id);
    Subtask getSubtaskById(int id);
    List<Task> getAllTasks();
    List<Epic> getAllEpics();
    List<Subtask> getAllSubtasks();
    List<Subtask> getSubtasksOfEpic(int epicId);
    List<Task> getHistory();
}
