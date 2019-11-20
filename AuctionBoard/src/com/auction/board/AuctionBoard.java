package com.auction.board;

import com.auction.pojo.BidableCoins;
import com.auction.pojo.Coin;
import com.auction.pojo.PORTS;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class AuctionBoard {
    static Map<BidableCoins, Stack<Integer>>  AuctionBoard = new HashMap<>();
    static List<BidableCoins> bidableCoins = new ArrayList<>();
    public static Scanner sc= new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n;
        Socket socket = new Socket("localhost", PORTS.PORT_SHOW_BID_DEADLINE);
        do {
            System.out.println("\n ***** Main Menu ****** \n" +
                    "1. Get Bid List \n" );
            n= sc.nextInt();
            sc.nextLine();
            switch (n){
                case 1:
                    getBidlist(n,socket);
            }
        }while (n>0 && n<2);
    }

    public static void getBidlist(int n,Socket socket) {
        try {
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(String.valueOf(n));
            dout.flush();
            System.out.println("Bid List");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            bidableCoins = (List<BidableCoins>) objectInputStream.readObject();
            System.out.println(bidableCoins);
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
