# Test Plan — StudentGradebook

## 1. Introduction

StudentGradebook is a small Java utility for recording per-student scores and
computing averages, built around the `gradebook` class
(`src/gradebook/gradebook.java`) and a standalone driver,
`studentGradebook.java`. This plan covers testing of the core scoring and
averaging logic, plus the two data-integrity issues (duplicate roll numbers,
score validation) and two known cosmetic bugs (rounding, case-sensitive name
handling) already logged in `docs/triage-log.md` from the previous lab's
triage exercise.

## 2. Test Items

- `gradebook.java` — the `gradebook` class: constructor, `addScore(double)`,
  `average()`.
- `studentGradebook.java` — the driver/demo class that builds a roster and
  prints per-student and overall averages.

## 3. Features to be Tested

- Score addition, including rejection of invalid (negative) scores.
- Average calculation, including the empty-scores edge case.
- Roll-number uniqueness across students (currently unenforced — this is
  exactly the kind of gap this plan is meant to catch).
- The two "Won't Fix" behaviors from the triage log (rounding, case
  sensitivity), tested so their current behavior is documented and doesn't
  regress further.

## 4. Features Not to be Tested

- Any console/UI output formatting in `studentGradebook.main()` — this is a
  demo driver, not a library, and its printed strings are not a contract
  student code should rely on.
- Persistence/storage of gradebook records — no file or database layer exists
  in this codebase, so there is nothing to test.

## 5. Approach

Testing is manual, black-box, at the unit level: each test case calls
`gradebook` methods directly (via a scratch `Main`/REPL-style driver, since
there is no test framework wired into the project yet) and checks the
returned value or thrown exception against the expected result. Test cases
are written before execution (Task 2) and then run once against the current
source (Task 4), so results reflect the code as it exists today, bugs
included.

## 6. Pass/Fail Criteria

The test cycle passes if at least 90% of the 12 test cases pass and there are
zero open Critical defects (build-breaking compile errors count as Critical).
Given that `gradebook.java` currently has a duplicate-method compile error,
this specific cycle is expected to fall short of that bar — that failure is
the primary finding of this lab, not a flaw in the test cases.

## 7. Test Deliverables

- `docs/test-plan.md` (this document)
- `docs/test-cases.md` — 12 test cases with execution results
- `docs/rtm.md` — requirements traceability matrix
- One or more GitHub Issues for any failing test case, linked from the test
  case table

## 8. Environmental Needs

- JDK 17+ and a terminal, to compile and run `gradebook.java` /
  `studentGradebook.java` directly (no build tool or test framework is
  configured in this repo yet).
- Access to the `masoodkolachi/student-gradebook` GitHub repo to file and
  link Issues.

## 9. Schedule

Aligned to the lab's 3-hour block: Test Plan (60 min), Test Cases (75 min),
RTM (30 min), Manual Execution Pass (35 min).

## 10. Risks

- **No existing test scaffolding**: there's no JUnit setup, so every test
  case has to be run by hand through a scratch driver, which is slow and
  error-prone. Mitigation: keep test cases simple enough to eyeball the
  result.
- **The code doesn't currently compile**: `gradebook.java` defines
  `addScore(double)` three times, which is a hard compile error, not a
  runtime bug. This blocks every test case that depends on `gradebook`
  compiling at all, and is called out explicitly in the execution results
  rather than silently worked around.
