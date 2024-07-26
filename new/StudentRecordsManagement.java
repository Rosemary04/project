import java.util.Scanner;

public class StudentRecordsManagement {

    public static void main(String[] args) {
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Records Management System");
            System.out.println("1. Insert Student Record");
            System.out.println("2. Search Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    Student student = new Student(id, name, age);
                    bst.insert(student);
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    Student searchedStudent = bst.search(searchId);
                    if (searchedStudent != null) {
                        System.out.println("Student Found: " + searchedStudent);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    bst.delete(deleteId);
                    System.out.println("Student record deleted.");
                    break;
                case 4:
                    System.out.println("All Student Records:");
                    bst.inorder();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
