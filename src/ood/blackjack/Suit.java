package ood.blackjack;

public enum Suit
{
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    SPADES("Spades"),
    CLUBS("Clubs");

    private final String suitText;

    Suit(String suitText)
    {
        this.suitText = suitText;
    }

    public String printSuit() {
        return suitText;
    }
}
