package org.example;

import java.util.Scanner;

public class Player {

    public String name;
    public int wins = 0;
    public int playerNum;
    public int round;

    public Player(int playerNum) {

        System.out.println("Enter player " + playerNum + "'s name:");

        Scanner playerNameScanner = new Scanner(System.in);

        this.name = playerNameScanner.nextLine();

    }

    public Player() {

    }
}
