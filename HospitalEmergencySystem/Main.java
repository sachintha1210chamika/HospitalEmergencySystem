import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        VisitLinkedList linkedList = new VisitLinkedList();

        while (true) {
            System.out.println("\n===========================================");
            System.out.println(" HOSPITAL EMERGENCY MANAGEMENT SYSTEM ");
            System.out.println("===========================================");
            System.out.println("1. Add Patient Record (BST)");
            System.out.println("2. Search Patient Record (BST)");
            System.out.println("3. Delete Patient Record (BST)");
            System.out.println("4. Display All Patient Records (BST)");
            System.out.println("5. Add Patient to Emergency Queue (Queue)");
            System.out.println("6. Call Patient for Treatment (Queue -> Stack)");
            System.out.println("7. Display Emergency Queue (Queue)");
            System.out.println("8. Undo Last Treatment (Stack)");
            System.out.println("9. Display Treatment History (Stack)");
            System.out.println("10. Add Visit Record (Linked List)");
            System.out.println("11. Display Visit History (Linked List)");
            System.out.println("12. Exit");
            System.out.print("Enter your choice (1-12): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Condition: ");
                    String condition = scanner.nextLine();
                    
                    bst.insert(id, name, age, contact, condition);
                    break;

                case 2:
                    System.out.print("Enter Patient ID to Search: ");
                    int searchId = scanner.nextInt();
                    Patient found = bst.search(searchId);
                    if (found != null) {
                        System.out.println("Patient Found:");
                        found.displayPatient();
                    } else {
                        System.out.println("Patient not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Patient ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    bst.delete(deleteId);
                    break;

                case 4:
                    bst.displayAll();
                    break;

                case 5:
                    System.out.print("Enter Patient ID for Emergency Queue: ");
                    int qId = scanner.nextInt();
                    Patient qPatient = bst.search(qId);
                    if (qPatient != null) {
                        queue.enqueue(qPatient);
                    } else {
                        System.out.println("Patient ID not found in records! Add patient to BST first.");
                    }
                    break;

                case 6:
                    Patient treated = queue.dequeue();
                    if (treated != null) {
                        stack.push(treated);
                    }
                    break;

                case 7:
                    queue.displayQueue();
                    break;

                case 8:
                    stack.pop();
                    break;

                case 9:
                    stack.displayStack();
                    break;

                case 10:
                    System.out.print("Enter Patient ID for Visit Record: ");
                    int vId = scanner.nextInt();
                    scanner.nextLine();
                    Patient vPatient = bst.search(vId);
                    if (vPatient != null) {
                        System.out.print("Enter Visit Date (e.g., YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        linkedList.addVisit(vPatient, date);
                    } else {
                        System.out.println("Patient ID not found in records!");
                    }
                    break;

                case 11:
                    linkedList.displayVisits();
                    break;

                case 12:
                    System.out.println("Exiting System. Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please select between 1 and 12.");
            }
        }
    }
}