package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    public static ArrayList<Card> cardsDealt = new ArrayList<Card>();
    public static Boolean gameWon = false;

    public Snap(String name) {
        super(name);
    }

    public static void getPlayerInput() {
        System.out.println("Press enter to draw a card");

        Scanner playerInputScanner = new Scanner(System.in);

        playerInputScanner.nextLine();
    }
// Now just implement a way to track the round of the play. It should allow for randomising which player starts.
    public static void main(String[] args) {
        CardGame cardGame = new CardGame("Snap");
        Player player1 = new Player(1);
        players.add(player1);
        Player player2 = new Player(2);
        players.add(player2);
        shuffleDeck();
        startingPlayer();
        currentPlayerIndex = firstPlayerIndex;


        for(int round = 0; gameWon = true; round++) {
            getPlayerInput();
            cardsDealt.add(dealCard());
            System.out.println(cardsDealt);


            if(round >= 1 && cardsDealt.get(round).symbol == cardsDealt.get(round-1).symbol ) {
                System.out.println("Snap! You win!");
                return;
            }

            if(currentPlayerIndex == players.size() - 1) {
                currentPlayerIndex -= players.size() -1;
                System.out.println(currentPlayerIndex);
            } else {
                currentPlayerIndex++;
                System.out.println(currentPlayerIndex);
            }

//            assign the given round to the relevant player. When for loop exits, check to see who's round it was.
//            give winning credit to them. Make sure to remove redundant code.









        }



    }
}
