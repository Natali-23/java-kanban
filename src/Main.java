import Manage.InMemoryTaskManager;
import Tasks.Epic;
import Tasks.Status;
import Tasks.Subtask;
import Tasks.Task;

public class Main {
    public static void main(String[] args) {
        InMemoryTaskManager manager = new InMemoryTaskManager();

        Epic epic = new Epic();
        epic.setName("Эпик 1");
        epic.setDescription("Описание эпика 1");
        int epicId = manager.createEpic(epic);

        Subtask subtask1 = new Subtask();
        subtask1.setName("Сабтаск 1");
        subtask1.setDescription("Описание сабтаска 1");
        subtask1.setEpicId(epicId);
        int subtask1Id = manager.createSubtask(subtask1);

        Subtask subtask2 = new Subtask();
        subtask2.setName("Сабтаск 2");
        subtask2.setDescription("Описание сабтаска 2");
        subtask2.setEpicId(epicId);
        int subtask2Id = manager.createSubtask(subtask2);

        System.out.println("Эпик после добавления сабтасков: " + manager.getEpicById(epicId));

        subtask1.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);
        System.out.println("Эпик после обновления сабтаска 1: " + manager.getEpicById(epicId));

        subtask2.setStatus(Status.DONE);
        manager.updateSubtask(subtask2);
        System.out.println("Эпик после завершения всех сабтасков: " + manager.getEpicById(epicId));

        Task task = new Task();
        task.setName("Обычная задача");
        task.setDescription("Просто тестовая задача");
        manager.createTask(task);

        System.out.println("Все задачи: " + manager.getAllTasks());
        System.out.println("Все эпики: " + manager.getAllEpics());
        System.out.println("Все сабтаски: " + manager.getAllSubtasks());
        System.out.println("История просмотра задачи" + manager.getHistory());
    }
}
