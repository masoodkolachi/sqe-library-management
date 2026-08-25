# Triage Log

## Sprint Bug Triage

| Rank | Issue                                                       | Severity | Priority | Sprint Decision |
| ---- | ----------------------------------------------------------- | -------- | -------- | --------------- |
| 1    | Crash when calculating average for a student with no scores | High     | High     | Fix             |
| 2    | Duplicate roll numbers allowed                              | High     | High     | Fix             |
| 3    | Negative score accepted                                     | Medium   | High     | Fix             |
| 4    | Incorrect rounding of averages                              | Medium   | Medium   | Won't Fix       |
| 5    | Case-sensitive name comparison bug                          | Medium   | Medium   | Won't Fix       |

## Reasoning

### 1. Crash on Empty Score List

This is the highest priority because it can crash the application during a normal operation. It should be fixed first.

### 2. Negative Scores

This is medium severity but high priority because invalid scores can enter the gradebook and affect student averages. Although it does not crash the application, preventing invalid data is important.

### Severity vs Priority Trade-offs

**Negative Scores:** This has medium severity but high priority. The program does not crash, but invalid scores can contaminate grade calculations, so it should still be fixed during this sprint.

**Incorrect Rounding:** This has medium severity and medium priority. It produces inaccurate averages, but the application remains usable. It can be scheduled for a later sprint.

**Case-Sensitive Name Comparison:** This has medium severity and medium priority. It affects searching but does not damage student or grade data, so it is less urgent than the other issues.

## Sprint Decision

### Issues to Fix

* Crash when calculating average for a student with no scores
* Duplicate roll numbers allowed
* Negative score accepted

### Issues Not Fixed This Sprint

* Incorrect rounding of averages
* Case-sensitive name comparison bug

These two issues are deferred because they have lower immediate impact than crashes and data-integrity problems. They should be reconsidered in the next sprint.
