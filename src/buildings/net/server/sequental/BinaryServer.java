package buildings.net.server.sequental;

import buildings.Building;
import buildings.Buildings;
import buildings.exceptions.BuildingUnderArrestException;
import buildings.factories.DwellingFactory;
import buildings.factories.HotelFactory;
import buildings.factories.OfficeFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class BinaryServer {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(1235);
            System.out.println("Waiting for client");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Completed");
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            DataInputStream inputStream = new DataInputStream(in);
            DataOutputStream outputStream = new DataOutputStream(out);
            String name;
            while ((name = inputStream.readUTF()) != null &&
                    inputStream.read() != -1){
                System.out.println("Name " + name);
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
                System.out.println("Waiting for client");
                Building building = Buildings.inputBuilding(in);
                System.out.println("Building " + building.toString());
                try{
                    outputStream.writeUTF(rateBuilding(building, name));
                }
                catch (BuildingUnderArrestException ex){
                    outputStream.writeUTF("Building is under arrest");
                }
            }
            inputStream.close();
            outputStream.close();
            in.close();
            out.close();
        }
        catch (IOException ex){
            System.out.println(ex.toString());
        }
    }

    public static String rateBuilding(Building building, String name)
            throws BuildingUnderArrestException{
        if (isBuildingUnderArrest()){
            throw new BuildingUnderArrestException();
        }
        switch (name){
            case "OfficeBuilding":
                return (building.getTotalArea() * 1500) + "$";
            case "HotelBuilding":
                return (building.getTotalArea() * 2000) + "$";
            case "Dwelling":
                return (building.getTotalArea() * 1000) + "$";
        }
        return null;
    }

    private static boolean isBuildingUnderArrest(){
        int seed = new Random().nextInt(100);
        return (seed >= 20 && seed < 30);
    }
}
