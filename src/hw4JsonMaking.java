import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class hw4JsonMaking {

    public static void main(String[] args) {
        String[] loc = new String[13];
        Double[] lat = new Double[13];
        Double[] lon = new Double[13];
        int[] pop = new int[]{20,60,65,45,40,75,65,90,60,30,35,40,50};
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
            FileWriter writer = new FileWriter("hw4JsonMaking.txt", true);
            writer.write("[");
            for(int i = 0; i< 13; i++){


                writer.write("{\n" +
                        "   \"name\": \"" + loc[i]+ "\",\n" +
                        "   \"popularity\":" + pop[i] + ",\n" +
                        "   \"loc\":[" + lat[i] + ", " + lon[i] + "] \n" +
                        " }");
                if(i < 12) writer.write(",");
                writer.write("\r\n");


            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
