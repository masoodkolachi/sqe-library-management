package gradebook;

public class studentGradebook {

    public static void main(String[] args) {

        gradebook[] students = {
                createStudent("Ali", "001", 80, 75, 90, 85, 88),
                createStudent("Ahmed", "002", 70, 65, 78, 72, 75),
                createStudent("Sara", "003", 92, 88, 95, 90, 94),
                createStudent("Ayesha", "004", 85, 80, 82, 88, 90),
                createStudent("Hassan", "005", 60, 68, 65, 70, 62),
                createStudent("Fatima", "006", 78, 82, 80, 75, 85),
                createStudent("Usman", "007", 88, 85, 90, 87, 92),
                createStudent("Zainab", "008", 95, 92, 96, 94, 90),
                createStudent("Bilal", "009", 72, 70, 68, 75, 74),
                createStudent("Mariam", "010", 84, 86, 80, 82, 88)
        };

        double totalAverage = 0.0;

        for (gradebook student : students) {
            double average = student.average();

            System.out.println(
                    student.getName() + " (" + student.getRollNo() + ") Average: " + average);

            totalAverage += average;
        }

        double overallAverage = totalAverage / students.length;

        System.out.println("\nOverall Average: " + overallAverage);
    }

    private static gradebook createStudent(String name, String rollNo, double... scores) {
        gradebook student = new gradebook(name, rollNo);

        for (double score : scores) {
            student.addScore(score);
        }

        return student;
    }
}
