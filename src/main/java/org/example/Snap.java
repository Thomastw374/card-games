package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {

    public static ArrayList<Card> cardsDealt = new ArrayList<Card>();
    public static Boolean gameWon = false;
    public static String snapInput = "";

    public Snap(String name) {
        super(name);
    }

    public static void getPlayerInput() {
        System.out.println("Press enter to draw a card");

        Scanner playerInputScanner = new Scanner(System.in);

        playerInputScanner.nextLine();

        return;
    }

    public static TimerTask snapInputTask = new TimerTask() {
        @Override
        public void run() {
            if(!snapInput.equals("snap")) {
                System.out.println("You didn't type snap in time!");
                System.out.println("Press enter to continue");
            }
        }
    };

    public static void getSnapInput() {
        Timer timer = new Timer();
        timer.schedule(snapInputTask, 3*1000);
        System.out.println("Type and enter snap to win!");
        Scanner snapInputScanner = new Scanner(System.in);

        snapInput = snapInputScanner.nextLine();

        timer.cancel();

        if(snapInput.equals("snap")){
            System.out.println("Snap! " + players.get(currentPlayerIndex).name + " wins!");
        } else {
            System.out.println("You didn't enter snap!");
        }


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

//            apply timer. Wait for snap to be inputted. if it is print out the below. If not continue with loop.

            if(round >= 1 && cardsDealt.get(round).symbol == cardsDealt.get(round-1).symbol ) {
                getSnapInput();
                if(snapInput.toLowerCase().equals("snap")) {
                    return;
                }
            }

            if(currentPlayerIndex == players.size() - 1) {
                currentPlayerIndex -= players.size() -1;
                System.out.println(currentPlayerIndex);
            } else {
                currentPlayerIndex++;
                System.out.println(currentPlayerIndex);
            }


            System.out.println(players.get(currentPlayerIndex).name + "'s turn.");

            if (deckOfCards.size() == 0) {
                System.out.println("No cards left. It's a draw!");
                return;
            }

        }



    }
}
