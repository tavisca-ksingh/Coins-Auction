package com.auction.pojo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BuyerMain {

    public static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n;

        do{
            System.out.println("\n ***** Main Menu ****** \n"+
                    "1. Coin list Available for bid \n"+
                    "***Any Other Key to Exit***\n"
            );
            n= sc.nextInt();
            switch (n) {
                case 1:

                    break;
                case 2:

                    break;

            }
        }
        while (n>0 && n<3);


    }
}
