import java.io.FileWriter;
import java.io.IOException;

public class step7createKML {
    private static final double[] tommyTrojan = new double[]{-118.28545813121093, 34.02055457948497};

    public static void main(String[] args){

        try {
            FileWriter writer = new FileWriter("mySpiro.kml", true);
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<kml xmlns=\"http://earth.google.com/kml/2.0\">\n" +
                    "<Document>\n" +
                    "<Style id=\"z1\">\n" +
                    "<IconStyle><Icon><href>http://www.google.com/intl/en_us/mapfiles/ms/micons/blue-dot.png</href></Icon></IconStyle>\n" +
                    "</Style>\n" +
                    "\n" +
                    "<Placemark><name>Tommy Trojan</name>\n" +
                    "<styleUrl>#z1</styleUrl><Point><coordinates>-118.28545813121093,34.02055457948497</coordinates></Point>\n" +
                    "</Placemark>\n" +
                    "\n" +
                    "<Placemark><name>The Spirograph</name>\n" +
                    "<LineString>\n" +
                    "<altitudeMode>absolute</altitudeMode>\n" +
                    "<coordinates>");
            double R  = 8.0, r = 1.0, a=4.0;
            double lon = tommyTrojan[0], lat = tommyTrojan[1];
            double x ,y;
            int nRev = 16;
            for(double t = 0.0; t<= nRev * Math.PI; t +=0.01){
                x = (R+r)*Math.cos((r/R)*t)-a*Math.cos((1+r/R)*t);
                y = (R+r)*Math.sin((r/R)*t)-a*Math.sin((1+r/R)*t);
                writer.write((lon + 0.0002*x) +","+ (lat + 0.0002*y) +",100\n");
            }
            writer.write("</coordinates></LineString>" +
                    "</Placemark>" +
                    "</Document></kml>\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
