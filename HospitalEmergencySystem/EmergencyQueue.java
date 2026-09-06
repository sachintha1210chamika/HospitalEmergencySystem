import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {
    private Queue<Patient> queue;

    public EmergencyQueue() {
        this.queue = new LinkedList<>();
    }

    // 1. Enqueue - Add patient to emergency waiting queue
    public void enqueue(Patient patient) {
        if (patient != null) {
            queue.add(patient);
            System.out.println("Patient " + patient.name + " (ID: " + patient.patientId + ") added to Emergency Queue.");
        } else {
            System.out.println("Invalid patient details.");
        }
    }

    // 2. Dequeue - Remove patient for treatment
    public Patient dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Emergency Queue is empty! No patients waiting.");
            return null;
        }
        Patient treatedPatient = queue.poll();
        System.out.println("Patient " + treatedPatient.name + " (ID: " + treatedPatient.patientId + ") called for treatment.");
        return treatedPatient;
    }

    // 3. Display all waiting patients
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Emergency Queue is currently empty.");
            return;
        }
        System.out.println("\n--- Emergency Patients Waiting Queue (FIFO) ---");
        for (Patient p : queue) {
            p.displayPatient();
        }
    }
}