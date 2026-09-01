package gradebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class gradebook {
    // Tracks every roll number already registered, across all instances,
    // so two students can't be created with the same roll number.
    // (Fixes the "Duplicate roll numbers allowed" item in docs/triage-log.md.)
    private static final Set<String> registeredRollNumbers = new HashSet<>();

    private String name;
    private String rollNo;
    private List<Double> scores;

    public gradebook(String name, String rollNo) {
        if (!registeredRollNumbers.add(rollNo)) {
            throw new IllegalArgumentException(
                    "Roll number already in use: " + rollNo);
        }
        this.name = name;
        this.rollNo = rollNo;
        this.scores = new ArrayList<>();
    }

    public double average() {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double s : scores) {
            sum += s;
        }
        return sum / scores.size();
    }

    /**
     * Adds a score to this student's record.
     *
     * @param score the score to add; must be non-negative
     * @throws IllegalArgumentException if score is negative
     */
    public void addScore(double score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }
        scores.add(score);
    }
}