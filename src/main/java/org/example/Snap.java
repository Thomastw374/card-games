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

    public static TimerTask createTimerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (!snapInput.equals("snap")) {
                    System.out.println("You didn't type snap in time!");
                    System.out.println("Press enter to continue");
                }
            }
        };
    }

    public static void getSnapInput() {
        Timer timer = new Timer();
        timer.schedule(createTimerTask(), 6 * 1000);
        System.out.println("Type and enter snap to win!");
        Scanner snapInputScanner = new Scanner(System.in);

        snapInput = snapInputScanner.nextLine();

        timer.cancel();

        if (snapInput.equals("snap")) {
            System.out.println("Snap! " + players.get(currentPlayerIndex).name + " wins!");
        } else {
            System.out.println("You didn't enter snap!");
        }


    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame("Snap");
        Player player1 = new Player(1);
        players.add(player1);
        Player player2 = new Player(2);
        players.add(player2);
        shuffleDeck();
        startingPlayer();
        currentPlayerIndex = firstPlayerIndex;


        for (int round = 0; gameWon = true; round++) {
            getPlayerInput();
            cardsDealt.add(dealCard());
            if (round > 0) {
                System.out.println(cardsDealt.get(round - 1).toString());
            }
            System.out.println(cardsDealt.get(round).toString());


            if (round >= 1 && cardsDealt.get(round).symbol == cardsDealt.get(round - 1).symbol) {
                getSnapInput();
                if (snapInput.toLowerCase().equals("snap")) {
                    return;
                }
            }

            if (currentPlayerIndex == players.size() - 1) {
                currentPlayerIndex -= players.size() - 1;
            } else {
                currentPlayerIndex++;
            }


            System.out.println(players.get(currentPlayerIndex).name + "'s turn.");

            if (deckOfCards.size() == 0) {
                System.out.println("No cards left. It's a draw!");
                return;
            }

        }
    }
}
