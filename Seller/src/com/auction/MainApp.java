package com.auction;

import com.auction.pojo.BidableCoins;
import com.auction.threads.BidListThread;
import com.auction.threads.MainMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args)  {
        List<BidableCoins> bidableCoinsList = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        int k;
        do {
            System.out.println("\n ***** Main Menu ****** \n"+
                    "1. listen client \n"+
                    "2. Main Menu \n");
            k = sc.nextInt();
            switch (k){
                case 1:
                    Thread t1 = new Thread(new BidListThread(bidableCoinsList));
                    t1.start();
                    break;
                case 2:
                    Thread t2 = new Thread(new MainMenu(bidableCoinsList));
                    t2.start();
                    break;
            }
        }while (k>0 && k<3);

    }



}
