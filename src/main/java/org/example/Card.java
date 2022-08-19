package org.example;

public class Card {
    public String suit;
    public String symbol;
    public int value;
    public static final String[] SUITS = {"U+2661", "U+2663", "U+2666", "U+2660"};
    public static final String[] SYMBOLS = {"2", "3", "4", "5", "6", "7", "8","9","10","J","Q","K","A"};

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("suit='").append(suit).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }

    public Card(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;

        switch(symbol) {
            case "J": this.value = 11;
            break;
            case "Q": this.value = 12;
                break;
            case "K": this.value = 13;
                break;
            case "A": this.value = 14;
                break;
            default:
                this.value = Integer.parseInt(symbol);
        }


    }
}
