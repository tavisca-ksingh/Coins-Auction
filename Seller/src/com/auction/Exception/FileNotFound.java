package com.auction.Exception;

import java.io.FileNotFoundException;

public class FileNotFound extends Exception {


    public FileNotFound(String s){
        super("FIle not Found " + s);
    }
}
