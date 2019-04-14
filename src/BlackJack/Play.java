package BlackJack;

import java.util.Scanner;

public class Play {

    private static double money = 5000;
    //private int bet = 0;
    private int hand = 0;
    private int splitedHand = 0;
    private int dealerHand = 0;

    private Deck dk =new Deck();


    public int getDealerHand(){
        Card first = dk.dealCard();
        Card second =dk.dealCard();
        dealerHand =first.getValue()+second.getValue();
        return  dealerHand;
    }

    public int getCardValue(Card d){
        return d.getValue();
    }

    public  int bet() {
        System.out.println("You have " + money + "$");
        System.out.println("How much whould you like to bet? ");
        Scanner in = new Scanner(System.in);
        int bet = in.nextInt();
        if(bet < money){
            return bet;
        }else {
            System.out.println("Not enough money ");
            return this.bet();
        }

    }

    public void play (){
        while(money>0){

            this.deal(this.bet());
            dk =new Deck();
            hand = 0;
            dealerHand= 0;
        }
    }
    public void checkWinner(int hand, int dhand, int b){
        if(hand>21){
            money-=b;
            System.out.println("You've lost");
        }else{
            if(dhand>21){
                money+=b;
                System.out.println("You have won");
            }else{
                if(hand>dhand){
                    money+=b;
                    System.out.println("You have won");
                }else{
                    if(hand==dhand){
                        System.out.println("Draw");
                    }else{
                        money-=b;
                        System.out.println("You've lost");
                    }
                }
            }
        }
    }

    public int dealerDraw(int dhand){
        //while(dhand<17){
            if(dhand<17){
            Card m =dk.dealCard();
            System.out.println("Dealer's hit card is :"+m.getCard());
            dhand += m.getValue();
            System.out.println("Dealer's hand is :"+dhand);
            // dealerHand =+ m.getValue();
            return dealerDraw(dhand);
        }
        return  dhand;
    }

    public void deal(int b){
        Boolean fin= false ;
        Card c = dk.dealCard();
        Card d = dk.dealCard();
        System.out.println("Dealer's card is : "+c.getCard());

        Card e = dk.dealCard();
        Card f = dk.dealCard();
        System.out.println("Your cards are : "+e.getCard()+" "+f.getCard());
        hand = e.getValue()+f.getValue();
        if(hand==21){
            System.out.println("BlackJack!    You won");
            money +=+b*2.5;
            System.out.println("You have "+money+"$");
        }
        else{
            while (hand < 21 && !fin) {

                System.out.print("Do you want one more card?    H = Hit    S = Stay    D = Double");
                if(e.getValue() == f.getValue()){
                    System.out.print("    Sp = Split");
                }
                System.out.println();
                Scanner hit = new Scanner(System.in);
                String a = hit.next();

                if (a.equals("H")) {
                    Card n = dk.dealCard();
                    hand += n.getValue();
                    System.out.println(n.getCard() + "     Your hand is:" + hand);
                    if (hand > 21) {
                        fin =true;
                        System.out.println("You've lost");
                        money -= b;
                        // System.out.println("You have " + money + "$");
                    }
                }
                if (a.equals("S")) {
                    System.out.println("Your hand is " + hand);
                    System.out.println("Dealer's cards are : " + c.getCard() + " " + d.getCard());
                    dealerHand =c.getValue()+d.getValue();
                    dealerHand=dealerDraw(dealerHand);
                    checkWinner(hand,dealerHand,b);
                    fin=true;
                }
                if(a.equals("D")){
                    Card p = dk.dealCard();
                    hand+=p.getValue();
                    System.out.println("Your hand is " + hand);
                    // money-=b;
                    System.out.println("Dealer's cards are : " + c.getCard() + " " + d.getCard());
                    dealerHand =c.getValue()+d.getValue();
                    dealerHand=dealerDraw(dealerHand);
                    dealerHand=dealerDraw(dealerHand);
                    checkWinner(hand,dealerHand,2*b);
                    fin=true;
                }
                if(a.equals("Sp")){
                    System.out.println("You have splited the "+e.getCard());
                    Card h = dk.dealCard();
                    hand = e.getValue()+h.getValue();
                }
            }



        }
        // end deal()
    }

}
