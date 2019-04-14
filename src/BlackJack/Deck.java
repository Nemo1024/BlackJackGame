package BlackJack;

import java.util.*;

public class Deck {

    private ArrayList<Card> deck = null;

    Deck() {
        deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(j, i));
            }
        }

        Collections.shuffle(deck);
    }

    public void printDeck() {
        Iterator<Card> it = deck.iterator();
        while (it.hasNext()) {
            it.next().print();
        }
    }

    public Card dealCard(){
        Card c = deck.get(0);
        deck.remove(0);
        return  c;
    }


}
