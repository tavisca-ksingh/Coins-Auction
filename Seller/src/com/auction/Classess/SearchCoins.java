package com.auction.Classess;

import com.auction.pojo.Coin;

import java.sql.DriverManager;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchCoins {
    static Scanner sc = new Scanner(System.in);



    public static void serchMenu()  {

        CoinBuilder.reterieveCoin();
       int n;

        do{
            System.out.println("\n ***** Search Menu ****** \n"+
                    "1. Search By Country \n"+
                    "2. Search By Year of Minting \n"+
                    "3. Search By Current Value \n"+
                    "4. Search By Country + Denomination \n"+
                    "5. Country + Year of Minting\n" +
                    "6. Country + Denomination + Year of Minting\n" +
                    "7. Acquired Date + Country\n" +
                    "***Any Other Key to Exit***\n"
                    );
            n= sc.nextInt();
            switch (n) {
                case 1:
                    searchByCountry();
                    break;
                case 2:
                    findYearOfMinting();
                    break;
                case 3:
                    findCurrentValue();
                    break;
                case 4:
                    findByCountryAndDenomination ();
                    break;
                case 5:
                    findByCountryAndYearOfMinting ();
                    break;
                case 6:
                    findByCountryAndDenominationAndYearOfMinting ();
                    break;
                case 7:
                    break;
            }
        }
        while (n>0 && n<8);
    }

    public static void searchByCountry(){
        sc.nextLine();
        System.out.println("Enter Country Name");
        String country = sc.nextLine();
        List<Coin> searchResult=  CoinBuilder.coinSet.stream().filter(coin -> coin.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        System.out.println(searchResult);
    }

    public static void findYearOfMinting(){
        sc.nextLine();
        System.out.println("Enter Year of Minting ");
        int year = sc.nextInt();
        List<Coin> searchResult=  CoinBuilder.coinSet.stream().filter(coin -> coin.getYearOfMinting() == (year))
               .collect(Collectors.toList());
        System.out.println(searchResult);
    }

    public static void findCurrentValue(){
        sc.nextLine();
        System.out.println("Enter Current Value ");
        int value = sc.nextInt();
        List<Coin> searchResult=  CoinBuilder.coinSet.stream()
                .sorted(Comparator.comparing(Coin::getCurrentValue)) .collect(Collectors.toList());
        System.out.println(searchResult);
    }

    public static void findByCountryAndDenomination (){
        sc.nextLine();
        System.out.println("Enter Country Name");
        String country = sc.nextLine();
        System.out.println("Enter Denomination Value ");
        int value = sc.nextInt();
        List<Coin> searchResult=  CoinBuilder.coinSet.stream().filter(coin -> (coin.getDenomination() == value && coin.getCountry().equalsIgnoreCase(country)))
                .collect(Collectors.toList());
        System.out.println(searchResult);
    }

    public static void findByCountryAndYearOfMinting (){
        sc.nextLine();
        System.out.println("Enter Country Name");
        String country = sc.nextLine();
        System.out.println("Enter Year of Minting ");
        int value = sc.nextInt();
        List<Coin> searchResult=  CoinBuilder.coinSet.stream().filter(coin -> (coin.getYearOfMinting() == value && coin.getCountry().equalsIgnoreCase(country)))
                .collect(Collectors.toList());
        System.out.println(searchResult);
    }

    public static void findByCountryAndDenominationAndYearOfMinting (){
        sc.nextLine();
        System.out.println("Enter Country Name");
        String country = sc.nextLine();
        System.out.println("Enter denomination ");
        int denomination =  sc.nextInt();
        System.out.println("Enter Year of Minting ");
        int value = sc.nextInt();
        List<Coin> searchResult=  CoinBuilder.coinSet.stream().filter(coin -> (coin.getYearOfMinting() == value && coin.getDenomination() == denomination &&
                coin.getCountry().equalsIgnoreCase(country))).collect(Collectors.toList());
        System.out.println(searchResult);
    }



}
