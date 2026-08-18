package gradebook;

import java.util.ArrayList;
import java.util.List;

public class gradebook {
    private String name;
    private String rollNo;
    private List<Double> scores;

    public gradebook(String name, String rollNo) {
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

    public void addScore(double score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }
        scores.add(score);
    }

    public void addScore(double score) {
        scores.add(score);
    }
}