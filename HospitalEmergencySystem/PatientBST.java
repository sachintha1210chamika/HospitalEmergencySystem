public class PatientBST {
    private Patient root;

    public PatientBST() {
        this.root = null;
    }

    // 1. Insert Patient
    public void insert(int id, String name, int age, String contact, String condition) {
        root = insertRec(root, new Patient(id, name, age, contact, condition));
        System.out.println("Patient added successfully!");
    }

    private Patient insertRec(Patient root, Patient newPatient) {
        if (root == null) {
            return newPatient;
        }
        if (newPatient.patientId < root.patientId) {
            root.left = insertRec(root.left, newPatient);
        } else if (newPatient.patientId > root.patientId) {
            root.right = insertRec(root.right, newPatient);
        } else {
            System.out.println("Patient ID already exists!");
        }
        return root;
    }

    // 2. Search Patient
    public Patient search(int id) {
        return searchRec(root, id);
    }

    private Patient searchRec(Patient root, int id) {
        if (root == null || root.patientId == id) {
            return root;
        }
        if (id < root.patientId) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }

    // 3. Delete Patient
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Patient deleteRec(Patient root, int id) {
        if (root == null) {
            System.out.println("Patient ID not found.");
            return root;
        }
        if (id < root.patientId) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.patientId) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.patientId = minValue(root.right);
            root.right = deleteRec(root.right, root.patientId);
            System.out.println("Patient deleted successfully.");
        }
        return root;
    }

    private int minValue(Patient root) {
        int minVal = root.patientId;
        while (root.left != null) {
            minVal = root.left.patientId;
            root = root.left;
        }
        return minVal;
    }

    // 4. In-order Traversal (Display All Patients in Ascending Order)
    public void displayAll() {
        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }
        System.out.println("\n--- Patient Records (Sorted by ID) ---");
        inOrderRec(root);
    }

    private void inOrderRec(Patient root) {
        if (root != null) {
            inOrderRec(root.left);
            root.displayPatient();
            inOrderRec(root.right);
        }
    }
}