public class Patient {
    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;
    Patient left;
    Patient right;

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.left = null;
        this.right = null;
    }

    public void displayPatient() {
        System.out.println("ID: " + patientId + " | Name: " + name + " | Age: " + age + 
                           " | Contact: " + contactNumber + " | Condition: " + medicalCondition);
    }
}