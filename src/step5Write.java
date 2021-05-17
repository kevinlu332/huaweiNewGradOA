import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class step5Write {

    public static void main(String[] args) {
        String[] loc = new String[13];
        Double[] lat = new Double[13];
        Double[] lon = new Double[13];
        try {
            FileReader reader = new FileReader("locations.txt");


            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if(count%2==0){
                    String[] input = line.split(" ");
                    lat[count/2] = Double.parseDouble(input[0]);
                    lon[count/2] = Double.parseDouble(input[1]);
                }else loc[count/2] = line;
                count++;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //-------------------------
        try {
            FileWriter writer = new FileWriter("step5Cmd.kml", true);

            for(int i = 0; i< 13; i++){
                writer.write("('"+  loc[i] +"','POINT("+lon[i]+" " + lat[i] + ")'),");
                writer.write("\r\n");

            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
