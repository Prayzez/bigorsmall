# BigOrSmall

BigOrSmall is a simple Java console game where the player guesses whether the next random number will be bigger or smaller than the current number.

## How the game works

- The game starts with a random current number.
- The player enters:
  - `b` for bigger
  - `s` for smaller
- The game generates the next random number.
- If the guess is correct, the player earns points.
- If the result is a draw, the round is repeated.
- The game continues until the maximum number of rounds is reached.

## Scoring

- A correct answer gives points.
- Consecutive correct answers increase the score reward.
- An incorrect answer resets the correct-answer streak.
- The final total score is shown at the end of the game.

## Project structure

- `Main.java` – starts the program
- `BigOrSmall.java` – controls the main game flow
- `Round.java` – handles one round of gameplay
- `RandomNumberGenerator.java` – generates random numbers
- `ScoreBoard.java` – stores and displays scores
- `RoundResult.java` – enum for round result types

## How to run

1. Open the project in Eclipse
2. Run the `Main` class
3. Follow the console instructions to play

## Requirements

- Java
- Eclipse IDE

## Notes

This project is a simple console-based game created for practice with:
- object-oriented programming
- classes and methods
- enums
- loops and conditions
- file writing in Java

## Future improvements

Possible improvements for this project:
- use `RoundResult` directly in the game logic
- reuse one `Scanner` instead of creating a new one every round
- improve score saving format
- add input options for game settings such as number of rounds
