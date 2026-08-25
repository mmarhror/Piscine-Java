
import java.io.*;

public class CatInFile {

    public static void cat(String[] args) throws IOException {
        for (String arg : args) {
            OutputStream out = new FileOutputStream(arg);

            byte[] buffer = new byte[4096];
            int bytesCnt;

            while ((bytesCnt = System.in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesCnt);
            }

        }
    }
}
