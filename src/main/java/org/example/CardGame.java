package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CardGame {
    public static ArrayList<Card> deckOfCards = new ArrayList<>();
    public static String name;
    public static ArrayList<Player> players = new ArrayList<>();
    public static int firstPlayerIndex;
    public static int currentPlayerIndex;

    public CardGame(String name) {
        this.name = name;
        for(String suit : Card.SUITS)
            for(String symbol : Card.SYMBOLS) {
                Card card = new Card(suit, symbol);
                deckOfCards.add(card);
            }
    }

    public static void startingPlayer() {
        Random random = new Random();
//        random int between 0 and number of players
        int playerNumber = random.nextInt((players.size()));

        firstPlayerIndex = playerNumber;

        System.out.println(("Player " + (playerNumber + 1) + ", " + players.get((playerNumber)).name + ", goes first"));
    }

    public static void getDeck() {
        String heartsCardList = new String();
        String clubsCardList = new String();
        String diamondsCardList = new String();
        String spadesCardList = new String();
        heartsCardList += "This deck contains the ";

        for(Card card : deckOfCards) {

            switch(card.suit){
                case "U+2661": heartsCardList += card.symbol + " of " + "Hearts, ";
                break;
                case "U+2663": clubsCardList += card.symbol + " of " + "Clubs, ";
                break;
                case "U+2666": diamondsCardList += card.symbol + " of " + "Diamonds, ";
                break;
                case "U+2660": spadesCardList += card.symbol + " of " + "Spades, ";
                break;
            }
//            spadesCardList = spadesCardList.substring(0, (spadesCardList.length() - 1));

        }

        System.out.println(heartsCardList);
        System.out.println(clubsCardList);
        System.out.println(diamondsCardList);
        System.out.println(spadesCardList);
    }

    public static Card dealCard() {
        Card dealtCard = deckOfCards.get(deckOfCards.size() - 1);
        deckOfCards.remove(deckOfCards.size() - 1);
        return dealtCard;
    }

    public static ArrayList<Card> sortDeckInNumberOrder() {
        ArrayList<Card> deckSortedByNum;
        deckOfCards.sort((a,b) -> a.value - b.value );

        return deckOfCards;
    }

    public static ArrayList<Card> sortDeckIntoSuits() {
//        sorted by suit based on the order of suits in Card
        deckOfCards.sort((a,b) -> Arrays.asList(Card.SUITS).indexOf(a.suit) - Arrays.asList(Card.SUITS).indexOf(b.suit));

        return deckOfCards;
    }

    public static ArrayList<Card> shuffleDeck() {
        Random random = new Random();
        deckOfCards.sort((a,b) -> (a.value + random.nextInt(100)) - (b.value + random.nextInt(100)) );

        return deckOfCards;
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame("Snap");
        CardGame.getDeck();
        System.out.println(dealCard());
        System.out.println(sortDeckInNumberOrder());
        System.out.println(sortDeckIntoSuits());
        System.out.println(shuffleDeck());
    }
}
