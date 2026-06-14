package StudentSystem.main;

import StudentSystem.model.Student;
import StudentSystem.service.StudentService;

import java.util.*;

public class MainApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while(true) {

            System.out.println("\n===== STUDENT SYSTEM =====");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    service.add(new Student(id, name));
                    System.out.println("Added!");
                    break;

                case 2:
                    for(Student s : service.getAll()) {
                        System.out.println(s.getId() + " " + s.getName());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();

                    Student s = service.getById(sid);
                    if(s != null)
                        System.out.println(s.getId() + " " + s.getName());
                    else
                        System.out.println("Not Found");
                    break;

                case 4:
                    System.out.print("ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    service.update(new Student(uid, newName));
                    System.out.println("Updated!");
                    break;

                case 5:
                    System.out.print("ID: ");
                    int did = sc.nextInt();

                    service.delete(did);
                    System.out.println("Deleted!");
                    break;

                case 6:
                    System.exit(0);
            }
            sc.close();
        }
      
    }
}
