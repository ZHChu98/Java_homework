import java.lang.ProcessBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MASTER {
    public static void main(String[] args) {
        try {
            File SxDir = new File("Sx");
            if (!SxDir.exists()) {
                SxDir.mkdirs();
            }
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File("Sx/Sx1.txt").getAbsolutePath()));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File("Sx/Sx2.txt").getAbsolutePath()));
            BufferedWriter bw3 = new BufferedWriter(new FileWriter(new File("Sx/Sx3.txt").getAbsolutePath()));
            BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
            String strLine = null;
            int countLine = 1;
            while((strLine = br.readLine()) != null) {
                strLine = strLine.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1").replaceAll("^((\r\n)|\n)", "");
                if (strLine.length() == 0) {
                    continue;
                }
                if (countLine % 3 == 1) {
                    bw1.write(strLine + '\n');
                } else if (countLine % 3 == 2) {
                    bw2.write(strLine + '\n');
                } else {
                    bw3.write(strLine + '\n');
                }
                countLine++;
            }
            bw1.close();
            bw2.close();
            bw3.close();
            br.close();

            new ProcessBuilder("bash", "deploy.sh").start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}