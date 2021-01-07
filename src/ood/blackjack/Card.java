package ood.blackjack;

public class Card
{
    private Suit suit;
    private Rank rank;
    private boolean isFaceUp;

    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
        isFaceUp = false;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public String printRank(){
        return rank.printRank();
    }
    public Rank getRank()
    {
        return rank;
    }

    public boolean isFaceUp()
    {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp)
    {
        isFaceUp = faceUp;
    }

    public void flipCard(){
        isFaceUp = !isFaceUp;
    }

    public  String toString(){
        String str = "";
        if(isFaceUp) {
            str += rank.printRank() + "of "+ suit.printSuit();
        }else{
            str = "Face Down (nothing to see here)";
        }
        return str;
    }

}
