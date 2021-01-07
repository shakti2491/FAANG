package ood.blackjack;

import java.util.Random;

public class Deck extends Hand
{
    Random random = new Random();
    public void populate(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                Card card = new Card(suit,rank);
                this.addCard(card);
            }
        }
    }

    public void shuffle(){
        for(int i=this.getCards().size()-1;i>0;i--){
            // swap a random card b/w the beginning
            // last card
            int pick = random.nextInt(i);
            getCards().set(i,getCards().get(pick));
            getCards().set(pick,getCards().get(i));

        }
    }

    public void deal(Hand[] hands, int perHand){
        for(Hand hand : hands){
            for(int i =0;i<perHand;i++){
                this.give(getCards().get(0),hand);
            }
        }
    }
}
