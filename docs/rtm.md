# Requirements Traceability Matrix — StudentGradebook

## Requirements

- **REQ-1**: The system shall compute a student's average score correctly
  from their recorded scores.
- **REQ-2**: The system shall return an average of `0.0` for a student with
  no recorded scores, instead of crashing.
- **REQ-3**: The system shall reject a negative score with an
  `IllegalArgumentException`.
- **REQ-4**: The system shall accept and store valid non-negative scores.
- **REQ-5**: The system shall not allow two students to be registered with
  the same roll number.
- **REQ-6**: The system shall round the computed average to two decimal
  places for display.
- **REQ-7**: The system shall compare student names for lookup in a
  case-insensitive manner.
- **REQ-8**: `gradebook.java` shall compile without duplicate method
  definitions.

## Matrix

| Requirement | Test Case IDs                  |
| ----------- | ------------------------------- |
| REQ-1       | TC-001, TC-008, TC-012           |
| REQ-2       | TC-002                           |
| REQ-3       | TC-003, TC-011                   |
| REQ-4       | TC-004, TC-005                   |
| REQ-5       | TC-006                           |
| REQ-6       | TC-007                           |
| REQ-7       | TC-009                           |
| REQ-8       | TC-010                           |

## Coverage Check

Every requirement above has at least one linked test case — no untraced
requirements to close a gap on for this cycle. REQ-2, REQ-5, REQ-6, REQ-7,
and REQ-8 each have only a single test case; if this were a longer cycle
I'd add a second case per requirement (e.g. a second duplicate-roll-number
scenario for REQ-5 using different roll number formats), but one case per
requirement is enough to satisfy this lab's coverage bar.
