package com.auction.Classess;

import com.auction.pojo.Coin;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Scanner;

public class CoinBuilder {

    public static HashSet<Coin>  coinSet = new HashSet<>();
    static Scanner sc  =  new Scanner(System.in);


    public static void reterieveCoin() {
        HashSet<Coin>  coinSet1 = new HashSet<>();
        Coin coin = new Coin("india",99,2050,100000,"20-10-2019");
        Coin coin2 = new Coin("Australia",99,2050,200000,"20-10-2019");
        Coin coin3 = new Coin("india",99,122,10000,"20-10-2019");
        Coin coin5 = new Coin("Australia",99,122,50000,"20-10-2019");
        Coin coin4 = new Coin("Australia",33,2050,50000,"20-10-2019");
        Coin coin6 = new Coin("Australia",33,2050,10000,"20-10-2019");
        Coin coin7 = new Coin("india",33,2050,100000,"20-10-2019");
        Coin coin8 = new Coin("india",33,2050,100000,"20-10-2019");


        coinSet1.add(coin);
        coinSet1.add(coin2);
        coinSet1.add(coin3);
        coinSet1.add(coin5);
        coinSet1.add(coin6);
        coinSet1.add(coin4);
        coinSet1.add(coin7);
        coinSet1.add(coin8);
        coinSet = coinSet1;
        System.out.println(coinSet);
    }

    public HashSet<Coin> addCoinMenu(int n) {
        HashSet<Coin>  coinSetNew = new HashSet<>();
        for(int i= 0 ;i<n;i++) {
            System.out.println("Enter the Country Name");
            String country = sc.nextLine();
            System.out.println("Enter the denomination");
            int denomination = sc.nextInt();
            System.out.println("Enter the Year of Minting");
            int yearOfMinting = sc.nextInt();
            System.out.println("Enter the Current Value");
            int currentValue = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Acquired Date \"dd-MM-yyyy\" ");
            String acquiredDate = sc.nextLine();
            coinSetNew.add(new Coin(country, denomination, yearOfMinting, currentValue, acquiredDate));
        }
        coinSet.addAll(coinSetNew);
        return coinSetNew;
    }
}
