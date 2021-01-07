package ood.blackjack;
import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> cards;

    public Hand()
    {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void clear(){
        cards.clear();
    }

    public String showHand(){
        StringBuilder str = new StringBuilder();
        cards.forEach(card -> str.append(card.toString()));
        return str.toString();
    }
    public boolean give(Card card, Hand otherHand){
        if(!cards.contains(card)){
            return false;
        }else{
            cards.remove(card);
            otherHand.addCard(card);
            return true;
        }
    }

    public int getTotal(){
        int totalPoints = 0;
        boolean hasAce = false;
        //Getting total points(any aces by deafult will be 1)

        for(int i = 0;i<cards.size();i++){
            totalPoints +=cards.get(i).getRank().getRank();
            if(cards.get(i).getRank() == Rank.ACE){
                hasAce = true;
            }

            if(hasAce && totalPoints <=11){
                totalPoints +=10;
            }

        }
        return totalPoints;
    }

    public ArrayList<Card> getCards()
    {
        return cards;
    }


}

/*

Attributes
 -- cards

Methods
 -- clear()
 --- add(card)
 --give(card, otherHand)

 */

/*
Deck Class

specialised type of hand class

Attributes
cards

methods
populate()
shuffle()
deal()
 */
