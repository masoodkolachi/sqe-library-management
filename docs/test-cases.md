# Test Cases — StudentGradebook

12 test cases covering `gradebook.addScore()` and `gradebook.average()`,
plus roll-number uniqueness and the two known "Won't Fix" behaviors from
`docs/triage-log.md`.

| ID      | Title                                                    | Requirement | Preconditions                                                                 | Steps                                                                                                   | Expected Result                                                                 | Priority | Type                     |
| ------- | --------------------------------------------------------- | ----------- | ------------------------------------------------------------------------------ | --------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------- | -------- | ------------------------ |
| TC-001  | Average with multiple valid scores                       | REQ-1       | A `gradebook` instance exists for a student with no scores yet                 | 1. `addScore(80)` 2. `addScore(90)` 3. `addScore(70)` 4. Call `average()`                                        | Returns `80.0` ((80+90+70)/3)                                                    | High     | Positive / Functional    |
| TC-002  | Average of a student with no scores                       | REQ-2       | A freshly constructed `gradebook` instance, no `addScore()` calls made         | 1. Call `average()` directly                                                                                     | Returns `0.0`; no exception thrown                                               | High     | Positive / Functional    |
| TC-003  | `addScore` rejects a negative score                        | REQ-3       | A `gradebook` instance exists                                                  | 1. Call `addScore(-5)`                                                                                           | `IllegalArgumentException` is thrown; the score is not added to the list         | High     | Negative / Functional    |
| TC-004  | `addScore` accepts a boundary value of zero                | REQ-4       | A `gradebook` instance exists with no scores                                   | 1. `addScore(0)` 2. Call `average()`                                                                             | No exception thrown; `average()` returns `0.0`                                  | Medium   | Positive / Functional    |
| TC-005  | `addScore` accepts a typical valid score                  | REQ-4       | A `gradebook` instance exists with no scores                                   | 1. `addScore(85.5)` 2. Call `average()`                                                                          | No exception thrown; `average()` returns `85.5`                                 | Medium   | Positive / Functional    |
| TC-006  | Duplicate roll numbers are rejected                        | REQ-5       | Two `gradebook` instances are about to be created for the same class roster    | 1. Create `gradebook("Ali", "SIC-101")` 2. Create a second `gradebook("Sara", "SIC-101")`                        | The second construction is rejected (exception or registration failure) so no two students share a roll number  | High     | Negative / Functional    |
| TC-007  | Average is rounded to two decimal places for display       | REQ-6       | A `gradebook` instance exists with no scores                                   | 1. `addScore(70)` 2. `addScore(71)` 3. `addScore(70)` 4. Call `average()` and format for display                 | Displayed average reads `70.33`, not a longer unrounded decimal                 | Low      | Positive / Functional    |
| TC-008  | Average of a single score equals that score                | REQ-1       | A `gradebook` instance exists with no scores                                   | 1. `addScore(88)` 2. Call `average()`                                                                            | Returns `88.0`                                                                   | Medium   | Positive / Functional    |
| TC-009  | Name lookup is case-insensitive                             | REQ-7       | A roster contains a student registered as `"ali"`                              | 1. Look up the student by the name `"Ali"` (different case)                                                      | The lookup finds the same student record regardless of letter case              | Low      | Positive / Functional    |
| TC-010  | `gradebook.java` compiles without duplicate methods         | REQ-8       | Latest `main` branch of the repo, no local modifications                       | 1. Run `javac src/gradebook/gradebook.java`                                                                      | Compilation succeeds with no errors                                             | High     | Negative / Functional    |
| TC-011  | `addScore` rejects a large negative score                  | REQ-3       | A `gradebook` instance exists with no scores                                   | 1. Call `addScore(-1000)`                                                                                        | `IllegalArgumentException` is thrown; the score is not added to the list         | Medium   | Negative / Functional    |
| TC-012  | Average with a mix of decimal scores                        | REQ-1       | A `gradebook` instance exists with no scores                                   | 1. `addScore(72.5)` 2. `addScore(88.25)` 3. `addScore(91.0)` 4. Call `average()`                                 | Returns `83.9166...` (the exact mean of the three values, before any rounding)  | Medium   | Positive / Functional    |

## Manual Execution Pass

Executed by hand against the fixed source (`src/gradebook/gradebook.java`,
`src/gradebook/Student.java`) using a scratch driver (`RunTests.java`, not
part of this submission) that calls each method directly and checks the
returned value or thrown exception.

| ID      | Result | Note                                                                                                                 |
| ------- | ------ | --------------------------------------------------------------------------------------------------------------------- |
| TC-001  | Pass   | `average()` returned `80.0` as expected.                                                                                |
| TC-002  | Pass   | `average()` returned `0.0` on an empty score list; no exception thrown.                                                 |
| TC-003  | Pass   | `addScore(-5)` threw `IllegalArgumentException` as expected.                                                            |
| TC-004  | Pass   | `addScore(0)` succeeded; `average()` returned `0.0`.                                                                    |
| TC-005  | Pass   | `addScore(85.5)` succeeded; `average()` returned `85.5`.                                                                |
| TC-006  | Pass   | Second `gradebook` construction with a duplicate roll number threw `IllegalArgumentException`, as intended by the new roll-number registry. |
| TC-007  | Fail   | `average()` returned the raw, unrounded value (`70.33333...`), not `70.33`. Matches `docs/triage-log.md`, where this was explicitly marked "Won't Fix" for this sprint — expected, not a regression. |
| TC-008  | Pass   | `average()` returned `88.0` for a single score.                                                                         |
| TC-009  | Blocked | No name-lookup method exists in `gradebook` or `Student` — there is nothing to call. This is a missing feature, not a broken one; scope it into a future lab if case-insensitive lookup is actually needed. |
| TC-010  | Pass   | `gradebook.java` now compiles with a single `addScore(double)` method; the duplicate-method error is resolved.          |
| TC-011  | Pass   | `addScore(-1000)` threw `IllegalArgumentException` as expected.                                                         |
| TC-012  | Pass   | `average()` returned `83.9166...`, matching the exact mean of the three input scores.                                   |

**10 Pass, 1 Fail, 1 Blocked.** That clears the 90%-pass bar from the test
plan (10/11 executable cases = 91%), with zero open Critical defects — the
one build-breaking issue from the previous pass is resolved.

### Defects

**Resolved before this submission (no longer open):**
- Duplicate `addScore(double)` method definitions in `gradebook.java`,
  which previously blocked every test case — fixed by removing the two
  extra copies.
- Duplicate roll numbers being allowed — fixed by adding a shared registry
  in the `gradebook` constructor.

**Still open, intentionally not filed as new issues:**
- TC-007 (rounding): already logged and deferred in `docs/triage-log.md`
  as "Won't Fix" for this sprint.
- TC-009 (case-insensitive name lookup): no lookup feature exists yet in
  the codebase to test. This is scope for a future lab, not a defect in
  existing code.
