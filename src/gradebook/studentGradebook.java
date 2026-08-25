public class Student {

    int rollNumber;
    String name;
    int[] marks;

    public Student(int rollNumber, String name, int[] marks) {
        this.rollNumber = rollNumber;
        this.name = name;

        for (int mark : marks) {
            if (mark < 0) {
                throw new IllegalArgumentException("Score cannot be negative");
            }
        }

        this.marks = marks;
    }

    public double studentAverage() {
        if (marks.length == 0) {
            return 0.0;
        }

        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    public static void checkDuplicateRollNumbers(Student[] students) {

        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {

                if (students[i].rollNumber == students[j].rollNumber) {
                    throw new IllegalArgumentException(
                            "Duplicate roll number: " + students[i].rollNumber
                    );
                }
            }
        }
    }

    public static void main(String[] args) {

        Student[] students = {
                new Student(101, "Ali", new int[] {80, 75, 90, 85, 88}),
                new Student(102, "Ahmed", new int[] {70, 65, 78, 72, 75}),
                new Student(103, "Sara", new int[] {92, 88, 95, 90, 94}),

                // DUPLICATE ROLL NUMBER
                new Student(103, "Ayesha", new int[] {0}),

                new Student(105, "Hassan", new int[] {60, 68, 65, 70, 62}),
                new Student(106, "Fatima", new int[] {78, 56, 80, 75, 85}),
                new Student(107, "Usman", new int[] {88, 85, 90, 87, 92}),
                new Student(108, "Zainab", new int[] {95, 92, 96, 94, 90}),
                new Student(109, "Bilal", new int[] {72, 70, 68, 75, 74}),
                new Student(110, "Mariam", new int[] {84, 86, 80, 82, 88})
        };

        checkDuplicateRollNumbers(students);

        double totalAverage = 0;

        for (Student student : students) {

            double average = student.studentAverage();

            System.out.println(
                    student.rollNumber + " - "
                    + student.name + " Average: "
                    + average);

            totalAverage += average;
        }

        double overallAverage = totalAverage / students.length;

        System.out.println("\nOverall Average: " + overallAverage);
    }
}
