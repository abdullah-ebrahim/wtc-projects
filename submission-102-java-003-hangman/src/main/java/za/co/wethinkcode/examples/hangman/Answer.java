package za.co.wethinkcode.examples.hangman;

import java.util.Random;

public class Answer {
    private String value;

    public Answer(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public boolean equals(Object obj) {
        // checks if not Caps
        Answer otherAnswer = (Answer) obj;
        return this.value.equalsIgnoreCase(otherAnswer.toString());
    }

    public Answer getHint(Answer guessedAnswer, char guessedLetter) {
        // If Match, update Hint
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.value.length(); i++) {
            if (guessedLetter == this.value.charAt(i)) {
                result.append(guessedLetter);
            } else {
                result.append(guessedAnswer.toString().charAt(i));
            }
        }
        return  new Answer (result.toString());
        // Convert toString
    }

    public boolean hasLetter(char letter) {
        return this.value.indexOf(letter) >= 0;
    }

    public Answer generateRandomHint() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.value.length() - 1);

        String noLetters = "_".repeat(this.value.length());
        return this.getHint( new Answer(noLetters),
                this.value.charAt(randomIndex));
    }

    public boolean isGoodGuess(Answer wordToGuess, char letter) {
        // checks if guess correct, and not previously used
        return wordToGuess.hasLetter(letter) && !this.hasLetter(letter);
    }
}
