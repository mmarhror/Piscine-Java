
import java.io.*;

public class Cat {

    public static void cat(String[] args) throws IOException {
        for (String arg : args) {
            InputStream in = new FileInputStream(arg);

            byte[] buffer = new byte[4096];
            int bytesCnt;

            while ((bytesCnt = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesCnt);
            }
        }
    }
}
