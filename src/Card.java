public class Card {

    private CharSequence value;
    private boolean guess = false;

    public Card(CharSequence value) {
        this.value = value;
    }

    public CharSequence getValue() {
        return value;
    }

    public void setValue(CharSequence value) {
        this.value = value;
    }

    public boolean getGuess() {
        return this.guess = guess;
    }

    public void setGuess(boolean guess) {
        this.guess = guess;
    }

}
