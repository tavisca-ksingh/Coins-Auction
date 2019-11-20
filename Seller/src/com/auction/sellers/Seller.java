package com.auction.sellers;

import com.auction.Classess.CoinBuilder;
import com.auction.Exception.FileNotFound;
import com.auction.pojo.BidableCoins;
import com.auction.pojo.Coin;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Seller  {
    static Map<String, HashSet<Coin>> sellerList = new HashMap<>();
    static Scanner sc  =  new Scanner(System.in);


    public  void addSellers()  {
        CoinBuilder coinBuilder = new CoinBuilder();
        System.out.println("Enter the name of the Sellers : ");
        String name = sc.nextLine();
        System.out.println("Enter the number of coins : ");
        int n =  sc.nextInt();
        sc.nextLine();
        sellerList.put(name,coinBuilder.addCoinMenu(n));
    }

    public Map<String, HashSet<Coin>> searchSeller(String sellerName){

        Map<String, HashSet<Coin>> result = sellerList.entrySet()
                .stream()
                .filter(map -> sellerName.equalsIgnoreCase(map.getKey()) )
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        System.out.println(result);
      return result;
    }

    public static Map<String, HashSet<Coin>> getSellerList() {
        return sellerList;
    }




    public void createData() throws FileNotFound {
        System.out.println("Enter the seller Name : ");
        String name = sc.nextLine();
        HashSet<Coin> coins = new HashSet<Coin>();
        try {
            BufferedReader  br= new BufferedReader(new FileReader(name+".csv"));
            String sellerName = br.readLine();
            String line="";
            while ((line=br.readLine())!=null) {
                String[] fields = line.split(",");
                coins.add(new Coin(fields[0],Integer.valueOf(fields[1]),Integer.valueOf(fields[2]),Integer.valueOf(fields[3]),fields[4]));
                sellerList.put(sellerName,coins);
                CoinBuilder.coinSet.addAll(coins);
            }
        }catch ( Exception f){
            throw new FileNotFound(name);
        }
        System.out.println(sellerList);
    }
}
