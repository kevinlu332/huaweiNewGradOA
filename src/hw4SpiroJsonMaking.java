import java.io.FileWriter;
import java.io.IOException;

public class hw4SpiroJsonMaking {
    private static final double[] tommyTrojan = new double[]{-118.28545813121093, 34.02055457948497};

    public static void main(String[] args){

        try {
            FileWriter writer = new FileWriter("hw4SpiroJsonMaking.txt", true);
            writer.write("[");

            double R  = 8.0, r = 1.0, a=4.0;
            double lon = tommyTrojan[0], lat = tommyTrojan[1];
            double x ,y;
            int nRev = 16;
            for(double t = 0.0; t<= nRev * Math.PI; t +=0.1){
                x = (R+r)*Math.cos((r/R)*t)-a*Math.cos((1+r/R)*t);
                y = (R+r)*Math.sin((r/R)*t)-a*Math.sin((1+r/R)*t);
                writer.write("{\n" +
                        " \"loc\": [");
                writer.write((lon + 0.0002*x) +","+ (lat + 0.0002*y) +"]\n" +
                        "}");
                if (t!= nRev * Math.PI ) writer.write(",\n");
                //////////////////////
                // remember to delete the last "," from the result file
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
