public class PatientBST {
    private Patient root = null;

    public PatientBST() {
    }

    // Insert Patient
    public void insert(int id, String name, int age, String contact, String condition) {
        this.root = this.insertRec(this.root, new Patient(id, name, age, contact, condition));
        System.out.println("Patient added successfully!");
    }

    private Patient insertRec(Patient root, Patient newPatient) {
        if (root == null) {
            return newPatient;
        }

        if (newPatient.patientId < root.patientId) {
            root.left = this.insertRec(root.left, newPatient);
        } else if (newPatient.patientId > root.patientId) {
            root.right = this.insertRec(root.right, newPatient);
        } else {
            System.out.println("Patient ID already exists!");
        }

        return root;
    }

    // Search Patient
    public Patient search(int id) {
        return this.searchRec(this.root, id);
    }

    private Patient searchRec(Patient root, int id) {
        if (root == null || root.patientId == id) {
            return root;
        }

        if (id < root.patientId) {
            return this.searchRec(root.left, id);
        } else {
            return this.searchRec(root.right, id);
        }
    }

    // Delete Patient
    public void delete(int id) {
        if (search(id) == null) {
            System.out.println("Patient ID not found.");
            return;
        }
        this.root = this.deleteRec(this.root, id);
        System.out.println("Patient deleted successfully.");
    }

    private Patient deleteRec(Patient root, int id) {
        if (root == null) {
            return null;
        }

        if (id < root.patientId) {
            root.left = this.deleteRec(root.left, id);
        } else if (id > root.patientId) {
            root.right = this.deleteRec(root.right, id);
        } else {
            // Case 1 & Case 2: Node with 0 or 1 child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node with 2 children
            Patient successor = this.minValueNode(root.right);
            
            // Copy all patient data (not just ID)
            root.patientId = successor.patientId;
            root.name = successor.name;
            root.age = successor.age;
            root.contactNumber = successor.contactNumber;
            root.medicalCondition = successor.medicalCondition;

            // Delete the successor
            root.right = this.deleteRec(root.right, successor.patientId);
        }

        return root;
    }

    private Patient minValueNode(Patient root) {
        Patient current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Display All Patients
    public void displayAll() {
        if (this.root == null) {
            System.out.println("No patient records available.");
        } else {
            System.out.println("\n--- Patient Records (Sorted by ID) ---");
            this.inOrderRec(this.root);
        }
    }

    private void inOrderRec(Patient root) {
        if (root != null) {
            this.inOrderRec(root.left);
            root.displayPatient();
            this.inOrderRec(root.right);
        }
    }
}