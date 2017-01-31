package buildings.net.client;

import buildings.Building;
import buildings.Buildings;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import buildings.Building;
import buildings.Buildings;
import buildings.factories.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class SerialClient {
    public static void main(String[] args){
        try{
            String firstName = args[0];
            String secondName = args[1];
            String thirdName = args[2];

            Socket socket = new Socket(InetAddress.getLocalHost(), 1235);

            ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());

            BufferedReader fr1 = new BufferedReader(new FileReader(firstName));
            BufferedReader fr2 = new BufferedReader(new FileReader(secondName));
            BufferedWriter fw = new BufferedWriter(new FileWriter(new File(thirdName)));
            String name;
            String cost;
            while ((name = fr2.readLine()) != null){
                switch (name){
                    case "OfficeBuilding":
                        Buildings.setBuildingFactory(new OfficeFactory());
                        break;
                    case "HotelBuilding":
                        Buildings.setBuildingFactory(new HotelFactory());
                        break;
                    case "Dwelling":
                        Buildings.setBuildingFactory(new DwellingFactory());
                        break;
                }
                System.out.println("Sending name " + name);
                objOut.writeObject(name);
                Building building = Buildings.readBuilding(fr1);
                System.out.println("Sending " + building.toString());
                objOut.writeObject(building);
                System.out.println("Waiting for server");
                cost = (String) objIn.readObject();
                System.out.println("Cost: " + cost);
                fw.write(cost);
                fw.write("\r\n");
            }

            fr1.close();
            fr2.close();
            fw.close();
            objIn.close();
            objOut.close();
            socket.close();

        }
        catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.toString());
        }
    }
}