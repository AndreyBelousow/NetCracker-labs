package buildings.net.client;

import buildings.Building;
import buildings.Buildings;
import buildings.factories.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class BinaryClient {

    public static void main(String[] args) throws IOException {
        try{
            String buildingsFile = args[0];
            String buildingTypesFile = args[1];
            String costFile = args[2];

            Socket socket = new Socket(InetAddress.getLocalHost(), 1235);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            DataInputStream inputStream = new DataInputStream(in);
            DataOutputStream outputStream = new DataOutputStream(out);

            BufferedReader fr1 = new BufferedReader(new FileReader(buildingsFile));
            BufferedReader fr2 = new BufferedReader(new FileReader(buildingTypesFile));
            BufferedWriter fw = new BufferedWriter(new FileWriter(new File(costFile)));

            String s1;
            String s2;
            while ((s1 = fr2.readLine()) != null){
                switch (s1){
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
                System.out.println("Sending name " + s1);
                outputStream.writeUTF(s1);
                Building building = Buildings.readBuilding(fr1);
                System.out.println("Sending " + building.toString());
                Buildings.outputBuilding(building, out);
                System.out.println("Waiting for server");
                s2 = inputStream.readUTF();
                System.out.println("Cost: " + s2);
                fw.write(s2);
                fw.write("\r\n");
            }

            fr1.close();
            fr2.close();
            fw.close();
            inputStream.close();
            outputStream.close();
            in.close();
            out.close();
            socket.close();

        }
        catch (IOException ex){
            System.err.println(ex.toString());
        }
    }

}
