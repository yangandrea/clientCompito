package com.example;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Main 
{
    public static void main( String[] args )
    {
        try {
            ArrayList inseri= new ArrayList<String>();
            Socket s = new Socket("localhost", 6789);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader inServ = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String stringaServer;
            do {
                System.out.println("inserisci un prodotto");
                String st = in.readLine();
                out.writeBytes(st + '\n');
                stringaServer = inServ.readLine();
                if (stringaServer.equals("1"))
                {
                    s.close();
                }
            }while(Integer.parseInt(stringaServer) != 4);
            System.out.println("hai inserito un prodotto");

            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione!");
            System.exit(1);
        }
}
    }
