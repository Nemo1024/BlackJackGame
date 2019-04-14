package BlackJack;


public class Card {

    private int numar = 0;
    private int culoare = 0;


    Card(int numar, int culoare) {
        this.numar = numar;
        this.culoare = culoare;
    }

    public void print() {
        switch (this.culoare) {
            case 0:
                System.out.println(this.numar + ",R ");
                break;
            case 1:
                System.out.println(this.numar + ",B ");
                break;
            case 2:
                System.out.println(this.numar + ",C ");
                break;
            case 3:
                System.out.println(this.numar + ",D ");
                break;
        }
    }

    public void print(Card c) {
        switch (culoare) {
            case 0:
                System.out.println(c.numar + ",R ");
                break;
            case 1:
                System.out.println(c.numar + ",B ");
                break;
            case 2:
                System.out.println(c.numar + ",C ");
                break;
            case 3:
                System.out.println(c.numar + ",D ");
                break;
        }
        System.out.println();
    }

    public int getNumar() {
        return this.numar;
    }

    public int getValue(Card this) {
        int value;
        switch (this.numar) {

            case 0:
                value = 2;
                break;
            case 1:
                value = 3;
                break;
            case 2:
                value = 4;
                break;
            case 3:
                value = 5;
                break;
            case 4:
                value = 6;
                break;
            case 5:
                value = 7;
                break;
            case 6:
                value = 8;
                break;
            case 7:
                value = 9;
                break;
            case 8:
                value = 10;
                break;
            case 9:
                value = 10;
                break;
            case 10:
                value = 10;
                break;
            case 11:
                value = 10;
                break;
            case 12:
                value = 11;
                break;

            default:
                value = 0;
        }

        return value;
    }

    public String getCard(Card this){
        String x;
        switch (this.numar) {

            case 0:
                x = "2";
                break;
            case 1:
                x = "3";
                break;
            case 2:
                x = "4";
                break;
            case 3:
                x = "5";
                break;
            case 4:
                x = "6";
                break;
            case 5:
                x = "7";
                break;
            case 6:
                x = "8";
                break;
            case 7:
                x = "9";
                break;
            case 8:
                x = "10";
                break;
            case 9:
                x = "J";
                break;
            case 10:
                x = "Q";
                break;
            case 11:
                x = "K";
                break;
            case 12:
                x = "A";
                break;

            default:
                x = "X";
        }

        return x;
    }
}
