class VisitNode {
    Patient patient;
    String visitDate;
    VisitNode next;

    public VisitNode(Patient patient, String visitDate) {
        this.patient = patient;
        this.visitDate = visitDate;
        this.next = null;
    }
}

public class VisitLinkedList {
    private VisitNode head;

    public VisitLinkedList() {
        this.head = null;
    }

    // 1. Add visit record to the end of the list
    public void addVisit(Patient patient, String visitDate) {
        VisitNode newNode = new VisitNode(patient, visitDate);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Visit record added for Patient: " + patient.name + " on " + visitDate);
    }

    // 2. Display all visit records
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        System.out.println("\n--- Patient Visit History (Singly Linked List) ---");
        VisitNode current = head;
        while (current != null) {
            System.out.print("[" + current.visitDate + "] ");
            current.patient.displayPatient();
            current = current.next;
        }
    }
}