public class studentGradebook {

    String name;
    int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double studentAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    public static void main(String[] args) {

        Student[] students = {
                new Student("Ali", new int[] { 80, 75, 90, 85, 88 }),
                new Student("Ahmed", new int[] { 70, 65, 78, 72, 75 }),
                new Student("Sara", new int[] { 92, 88, 95, 90, 94 }),
                new Student("Ayesha", new int[] { 0}),
                new Student("Hassan", new int[] { 60, 68, 65, 70, 62 }),
                new Student("Fatima", new int[] { 78, -56, 80, 75, 85 }),
                new Student("usman", new int[] { 88, 85, 90, 87, 92 }),
                new Student("Zainab", new int[] { 95, 92, 96, 94, 90 }),
                new Student("Bilal", new int[] { 72, 70, 68, -75, 74 }),
                new Student("Mariam", new int[] { 84, 86, 80, 82, 88 })
        };

        double totalAverage = 0;

        for (Student student : students) {
            double average = student.studentAverage();

            System.out.println(
                    student.name + " Average: " + average);

            totalAverage += average;
        }

        int overallAverage = totalAverage / students.length;

        System.out.println("\nOverall Average: " + overallAverage);
    }
}
