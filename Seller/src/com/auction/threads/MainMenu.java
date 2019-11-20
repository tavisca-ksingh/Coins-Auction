package com.auction.threads;

import com.auction.Classess.CoinBuilder;
import com.auction.Classess.SearchCoins;
import com.auction.Exception.FileNotFound;
import com.auction.pojo.BidableCoins;
import com.auction.pojo.Coin;
import com.auction.sellers.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainMenu implements Runnable {

    public final List<BidableCoins> bidableCoinsList;

    public MainMenu(List<BidableCoins> bidableCoinsList) {
        this.bidableCoinsList = bidableCoinsList;
    }
   static Scanner sc= new Scanner(System.in);

    @Override
    public void run() {

        Seller seller =new Seller();
            int n;
            do{
                System.out.println("\n ***** Main Menu ****** \n"+
                        "1. Enter new Seller \n"+
                        "2. For Search Menu \n"+
                        "3. Search Seller \n"+
                        "4. Create data \n"+
                        "5. Mark specific Coins for auction with deadline \n"+
                        "6. Get Bid coins \n"+
                        "***Any Other Key to Exit***\n"
                );
                n= sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1:
                        seller.addSellers();
                        break;
                    case 2:
                        SearchCoins.serchMenu();
                        break;
                    case 3:
                        System.out.println("Enter the name of the Sellers : ");
                        String sellerName = sc.nextLine();

                        if(!seller.searchSeller(sellerName).isEmpty()){
                            System.out.println("No seller found");
                        }else
                            seller.searchSeller(sellerName);
                        break;
                    case 4:
                        try{
                            seller.createData();
                        }catch (FileNotFound f){
                            System.out.println(f.getLocalizedMessage());
                        }
                        break;
                    case 5:
                        System.out.println("Enter the name of the Sellers : ");
                        String sName = sc.nextLine();
                        markDeadlineForAuction(sName);
                        break;
                    case 6:
                        System.out.println(bidableCoinsList.hashCode());
                        System.out.println(bidableCoinsList);
                        break;
                }
            }
            while (n>0 && n<7);
        }


    public  void markDeadlineForAuction(String sellerName){
        Seller seller =new Seller();
        if(seller.searchSeller(sellerName).isEmpty()){
            System.out.println("No seller found");
        }
        else {
            System.out.println("Enter the id to mark deadline");
            int id = sc.nextInt();
            sc.nextLine();
            Coin coin = CoinBuilder.coinSet.stream().filter(coinValue -> coinValue.getId() == id).collect(Collectors.toList()).get(0);
            if(coin == null){
                System.out.println(" No Coins Found");
            }else{
                try {
                    System.out.println("Enter the deadline (\"dd-mm-yyyy\")");
                    String date= sc.nextLine();
                    SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
                    Date date1=format.parse(date);
                    bidableCoinsList.add(new BidableCoins(sellerName,coin,date1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
