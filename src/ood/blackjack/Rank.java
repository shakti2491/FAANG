package ood.blackjack;

public enum Rank
{
    ACE(1,"Ace"), DEUCE(2,"Deuce"), THREE(3,"Three"),
    FOUR(4,"Four"), FIVE(5,"Five"),
    SIX(6,"Six"), SEVEN(7,"Seven"), EIGHT(8,"Eight"),
    NINE(9,"Nine"), TEN(10,"Ten"),
    JACK(10,"Jack"), QUEEN(10,"Queen"), KING(10,"King");

    private final int rankValue;
    private final String rankString;

    Rank(int rankValue, String rankString)
    {
        this.rankValue = rankValue;
        this.rankString = rankString;
    }

    public int getRank(){
        return rankValue;
    }

    public String printRank(){
        return rankString;
    }
}
