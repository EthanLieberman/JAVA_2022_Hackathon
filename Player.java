import java.util.ArrayList;
import java.util.Random;

public class Player {


    private String name;
    private ArrayList<Card> hand;
    private int sumHand;


    public Player(String name) {

        this.name = name;
        this.hand = new ArrayList<Card>();
        this.sumHand = 0;

    }

    public void hit(Deck deck){
        Random random = new Random();
        int index = random.nextInt(deck.getCards().size());

        // System.out.println("The card Is");

        Card oneCard = deck.getCards().get(index);
        this.hand.add(oneCard);

        deck.removeCard(index);
        // this.sumHand += oneCard.getRank();
    }


    public void handSum(){
        int countAce = 0;

        for (Card card : hand){
            if (card.getRank() == 1 ){
                countAce += 1;
                this.sumHand += 11;
            }
            else if (card.getRank() > 10) {
                this.sumHand += 10;
            }

            else {
                this.sumHand += card.getRank();
            }
        }

        if (this.sumHand > 21 && countAce > 0){
            while (countAce > 0 && this.sumHand > 21){
                countAce--;
                this.sumHand -= 10;
            }
        }

        // this.sumHand += value;
    }


    public void showHand(){
        System.out.println("|===Your Cards===|");
        for (Card card : this.hand){
            card.showCard();
        }
    }


    // getter and setter

    public ArrayList<Card> getHand(){
        return this.hand;
    }

    public void setHand(ArrayList<Card> hand){
        this.hand = hand;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSumHand(){
        return this.sumHand;
    }
}