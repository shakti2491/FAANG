package ood.blackjack;

public class Game
{
    public static void main(String[] args)
    {

        Card c1,c2;
        c1 = new Card(Suit.HEARTS,Rank.ACE);
        c2 = new Card(Suit.HEARTS,Rank.JACK);
        c1.flipCard();
        c2.flipCard();


        Hand  h1 = new Hand();
        Hand h2 = new Hand();

        h1.addCard(c1);
        h1.addCard(c2);

        System.out.println(h1.showHand());

        h1.give(c1,h2);

        System.out.println("Hand 1 is: "+ h1.showHand()+"\n"+"Hand 2 is now: "+ h2.showHand());

    }
}
