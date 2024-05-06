# Project Title

MANCALA GAME

## Description

WE HAVE CREATED A GAME OF MANCALA WITH THE RULES USED ON MATH IS FUN SITE AS STATED IN THE ASSIGNMENT FOLDER

## Getting Started

### Dependencies

GRADLE



### Executing program

* How to build and run the program
* Step-by-step bullets
```
use code blocks for commands
gradle build
gradle echo
java -cp build/classes/java/main ui.TextUI
```
* include the expected output

Mancala Game is Starting...
Enter name for Player One: 1
Enter name for Player Two: 2
Current board:
Player Two's Store 0
_____________________________
| | 4 | 4 | 4 | 4 | 4 | 4 | |
[0]-----------------------[0]
| | 4 | 4 | 4 | 4 | 4 | 4 | |
|___________________________|
Player One's Store 0
It's 1's turn.
Enter the pit number to move stones from(1-6): 6
1 moved 4 stones.

Current board:
Player Two's Store 0
_____________________________
| | 4 | 4 | 4 | 5 | 5 | 5 | |
[0]-----------------------[1]
| | 4 | 4 | 4 | 4 | 4 | 0 | |
|___________________________|
Player One's Store 1
It's 2's turn.
Enter the pit number to move stones from (7-12): 12
2 moved 4 stones.

Current board:
Player Two's Store 1
_____________________________
| | 0 | 4 | 4 | 5 | 5 | 5 | |
[1]-----------------------[1]
| | 5 | 5 | 5 | 4 | 4 | 0 | |
|___________________________|
Player One's Store 1
It's 1's turn.
Enter the pit number to move stones from(1-6): Exception in thread "main" java.util.NoSuchElementException: No line found
        at java.base/java.util.Scanner.nextLine(Scanner.java:1651)
        at ui.TextUI.startGame(TextUI.java:44)
        at ui.TextUI.main(TextUI.java:106)
oer-GP3copy$ java -cp build/classes/java/main ui.TextUI
Mancala Game is Starting...
Enter name for Player One: 1
Enter name for Player Two: 2
Current board:
Player Two's Store 0
_____________________________
| | 4 | 4 | 4 | 4 | 4 | 4 | |
[0]-----------------------[0]
| | 4 | 4 | 4 | 4 | 4 | 4 | |
|___________________________|
Player One's Store 0
It's 1's turn.
Enter the pit number to move stones from(1-6): 4
1 moved 4 stones.

Current board:
Player Two's Store 0
_____________________________
| | 4 | 4 | 4 | 4 | 4 | 5 | |
[0]-----------------------[1]
| | 4 | 4 | 4 | 0 | 5 | 5 | |
|___________________________|
Player One's Store 1
It's 2's turn.
Enter the pit number to move stones from (7-12): 11
2 moved 4 stones.

Current board:
Player Two's Store 1
_____________________________
| | 5 | 0 | 4 | 4 | 4 | 5 | |
[1]-----------------------[1]
| | 5 | 5 | 4 | 0 | 5 | 5 | |
|___________________________|
Player One's Store 1
It's 1's turn.
Enter the pit number to move stones from(1-6):
## Limitations

NONE

## Author Information

Name - Shyaum Bhardwaj
email - shyaum@uoguelph.ca
Student ID - 1235706

## Development History

Keep a log of what things you accomplish when.  You can use git's tagging feature to tag the versions or you can reference commits.

* 0.2
    * Various bug fixes and optimizations
    * See [commit change]() or See [release history]()
    Final code now runs properly
* 0.1
    * Initial Release
    the Ai code had just initialized it correctly but the move has a few logical issues along with the capture not integrated oerfectly but the capture was working perfectly. The distribute is incorrect and then the move stones is als incomplete and unable to work properly

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



