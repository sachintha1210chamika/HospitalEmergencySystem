import java.util.Stack;

public class TreatmentStack {
    private final Stack<Patient> stack;

    public TreatmentStack() {
        this.stack = new Stack<>();
    }

    // 1. Push - Add treated patient to history stack
    public void push(Patient patient) {
        if (patient != null) {
            stack.push(patient);
            System.out.println("Patient " + patient.name + " added to Treatment History.");
        }
    }

    // 2. Pop - Undo last treatment action
    public Patient pop() {
        if (stack.isEmpty()) {
            System.out.println("Treatment history is empty! Nothing to undo.");
            return null;
        }
        Patient removedPatient = stack.pop();
        System.out.println("Undone last treatment for Patient: " + removedPatient.name);
        return removedPatient;
    }

    // 3. Display treatment history (Most recent first)
    public void displayStack() {
        if (stack.isEmpty()) {
            System.out.println("No treatment history available.");
            return;
        }
        System.out.println("\n--- Treatment History (LIFO - Recent First) ---");
        for (int i = stack.size() - 1; i >= 0; i--) {
            stack.get(i).displayPatient();
        }
    }
}