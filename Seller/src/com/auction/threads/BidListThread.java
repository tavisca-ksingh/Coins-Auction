package com.auction.threads;

import com.auction.pojo.BidableCoins;
import com.auction.sellers.Seller;

import java.util.List;

public class BidListThread implements Runnable {
    public final List<BidableCoins> bidableCoinsList;

    public BidListThread(List<BidableCoins> bidableCoinsList) {
        this.bidableCoinsList = bidableCoinsList;
    }
    @Override
    public void run() {
//            try {
                System.out.println(bidableCoinsList.hashCode());
                System.out.println(bidableCoinsList);

//                System.out.println("listening from client");
//                ServerSocket ss= new ServerSocket(PORTS.PORT_SHOW_BID_DEADLINE);
//                Socket s=ss.accept();
//                DataInputStream dis = new DataInputStream(s.getInputStream());
//                String  str=(String)dis.readUTF();
//                System.out.println(str);
//                while(!str.equals("e")) {
//                    if (str.equals("1")) {
//                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());
//                        objectOutputStream.writeObject(seller.bidableCoinsList);
//                        objectOutputStream.flush();
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

