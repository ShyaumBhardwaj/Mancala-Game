| Test Method          | Description                   | Expected Outcome       | Actual Outcome (after test execution)    | Pass/Fail |
|----------------------|------------------------------------------------------|----------------------------------------------------|--------------------------------------------|------------|
| `testCaptureStones`  | Capture stones at a specified stopping point.        | 0 stones should be captured initially.             | Result of `captureStones(5)`               | Pass  |
| `testDistributeStones`| Distribute stones from a specified starting point.   | Stones should be added to pits during distribution.| Result of `distributeStones(0)`            | Pass  |
| `testGetNumStones`   | Get the number of stones in a specified pit.         | 4 stones should be in the pit initially.          | Result of `getNumStones(2)`                | Pass  |
| `testIsSideEmpty`    | Check if a side is empty.                            | The side should not be empty initially.           | Result of `isSideEmpty(2)`                 | Pass  |
| `testResetBoard`     | Reset the board to its initial state.                | No exceptions should be thrown.                    | Result of `resetBoard()`                   | Pass |
| `testRegisterPlayers`| Register players with the board.                     | No exceptions should be thrown.                    | Result of `registerPlayers(playerOne, playerTwo)` | Pass  |
