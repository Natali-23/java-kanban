public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();


        Task task1 = new Task("Задача 1", "Описание задачи 1");
        Task task2 = new Task("Задача 2", "Описание задачи 2");
        manager.createTask(task1);
        manager.createTask(task2);


        Epic epic1 = new Epic("Эпик 1", "Описание эпика 1");
        manager.createEpic(epic1);

        Subtask sub1 = new Subtask("Подзадача 1", "Описание подзадачи 1", epic1.getId());
        Subtask sub2 = new Subtask("Подзадача 2", "Описание подзадачи 2", epic1.getId());
        manager.createSubtask(sub1);
        manager.createSubtask(sub2);

        Epic epic2 = new Epic("Эпик 2", "Описание эпика 2");
        manager.createEpic(epic2);
        Subtask sub3 = new Subtask("Подзадача 3", "Описание подзадачи 3", epic2.getId());
        manager.createSubtask(sub3);

        // Проверка печати
        System.out.println("Все задачи: " + manager.getAllTasks());
        System.out.println("Все эпики: " + manager.getAllEpics());
        System.out.println("Все подзадачи: " + manager.getAllSubtasks());

        // Меняем статусы подзадач
        sub1.setStatus(Status.DONE);
        manager.updateSubtask(sub1);
        sub2.setStatus(Status.IN_PROGRESS);
        manager.updateSubtask(sub2);

        System.out.println("Эпик 1 после обновления: " + manager.getEpicById(epic1.getId()));


        manager.deleteTaskById(task1.getId());
        manager.deleteEpicById(epic2.getId());

        System.out.println("После удаления:");
        System.out.println("Задачи: " + manager.getAllTasks());
        System.out.println("Эпики: " + manager.getAllEpics());
        System.out.println("Подзадачи: " + manager.getAllSubtasks());
    }
}
