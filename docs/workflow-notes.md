## Merge Conflict Write-up

Both `feature/rename-field-a` and `feature/rename-field-b` renamed the same
field (`rollNo`) to different names (`studentId` vs `idNumber`) on the same
line, so Git couldn't auto-merge. Resolved by merging `main` into
`feature/rename-field-b`, keeping `studentId` (already on main), and
removing the conflicting `idNumber` version.

24d9b90 (HEAD -> feature/rename-field-b, origin/feature/rename-field-b, main) Feature/add student (#6)
2e15cbf Merge pull request #4 from masoodkolachi/feature/student-average
d08d224 (origin/feature/student-average, feature/student-average) add studentAverage feature
6637a2e add doc
70282fa docs: add project README
b1caec5 first commit
e951c46 first commit
a6f0fdc Delete README.md
da38e09 Initial commit

## Commit Message Rewrites

- Before: "fix stuff"
  After: "fix(gradebook): correct off-by-one error in average calculation"
  Why: the original gives no indication of what was fixed or where.

- Before: "update"
  After: "docs(readme): add installation instructions"
  Why: specifies both the type of change and its scope.

touch1 for testing.
touch2 for testing.
touch3 for testing.
touch4 for testing.
