package Task3;

import java.util.*;
class Task {
     private String taskName;
     private boolean taskStatus;

    Task(String title){
        taskName = title;
        this.taskStatus = false;
    }

    public String getTaskName(){
        return taskName;
    }
    public boolean getTaskStatus(){
        return taskStatus;
    }
    public void markCompleted(){
        this.taskStatus = true;
    }
    @Override
    public String toString(){
        return taskName + " -> " + (taskStatus ? "✅ Completed" : "❌ Pending");
    }
}

class Operations{
    ArrayList<Task> tasksList = new ArrayList<>();

    //Add new Task method
    public void addTask(String name){
        tasksList.add(new Task(name));
        System.out.println("Task Added Successfully.");
    }

    //method for marking tasks as completed
    public void markTaskCompleted(int index){
        if(index >= 0 && index < tasksList.size()){
            tasksList.get(index).markCompleted();
            System.out.println("Task marked as completed successfully.");
        }
        else{
            System.out.println("Invalid Task number!");
        }
    }

    //method for deleting a task
    public void removeTask(int index){
        if(index >= 0 && index < tasksList.size()){
            tasksList.remove(index);
            System.out.println("Task deleted successfully.");
        }
        else{
            System.out.println("Invalid Task number!");
        }
    }

    //method for displaying all the Tasks in the List.
    public void displayTaskList(){
        if(tasksList.isEmpty()){
            System.out.println("No Tasks Available.");
        }
        else{
            for(int i = 0; i < tasksList.size(); i++){
                System.out.println(i+1 + ". " + tasksList.get(i));
            }
        }
    }
}

public class ToDoList {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        Operations op = new Operations();

        while(true) {
            System.out.println("\n<================ To-Do List ================>");
            System.out.println("1. Add new task.\n2. Mark a task as completed.\n3. Display all tasks.\n4. Delete a task.\n5. exit.");
            System.out.print("Choose one option : ");

            //Input validation for option selection
            if(!sc.hasNextInt()){
                System.out.println("Please enter a valid integer value.");
                sc.next();
                continue;
            }

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    sc.nextLine();//clears the leftover line.
                    System.out.print("Enter new task : ");
                    String name = sc.nextLine();
                    op.addTask(name);
                    break;
                case 2:
                    System.out.println("Enter task number : ");
                    int number1 = sc.nextInt();
                    op.markTaskCompleted(number1-1);
                    break;
                case 3:
                    System.out.println("\n------------------------------------");
                    op.displayTaskList();
                    System.out.println("------------------------------------\n");
                    break;
                case 4:
                    System.out.println("Enter task number : ");
                    int number2 = sc.nextInt();
                    op.removeTask(number2-1);
                    break;
                case 5:
                    System.out.println("To-Do List Exited.");
                    sc.close();
                    return;
                default:
                    System.out.println("Enter a valid option.");
            }
        }

    }

}
