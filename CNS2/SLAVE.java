import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SLAVE {
    private Map<String, Integer> dataMap = new HashMap<String, Integer>();
    public static void main(String[] args) {
        String id = args[0];
        if (args[1].equals("0")) {
            System.out.println("test mode");
            try {
                new ProcessBuilder("sh", "cmdTest.sh").start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } else if (args[1].equals("1")) {
            try {
                File SMPath = new File("SM");
                if (!SMPath.exists()) {
                    SMPath.mkdir();
                }
                BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File("SM/SM1"+id+".txt").getAbsolutePath()));
                BufferedWriter bw2 = new BufferedWriter(new FileWriter(new File("SM/SM2"+id+".txt").getAbsolutePath()));
                BufferedWriter bw3 = new BufferedWriter(new FileWriter(new File("SM/SM3"+id+".txt").getAbsolutePath()));
                BufferedReader br = new BufferedReader(new FileReader(new File(args[2])));
                String strLine = null;
                while((strLine = br.readLine()) != null) {
                    String[] words = strLine.split(" ");
                    for (String word : words) {
                        if (word.compareTo("R") < 0) {
                            bw1.write(word + '\n');
                        } else if (word.compareTo("i") < 0) {
                            bw2.write(word + '\n');
                        } else {
                            bw3.write(word + '\n');
                        }
                    }
                }
                bw1.close();
                bw2.close();
                bw3.close();
                br.close();

                File SSPath = new File("SS");
                if (!SSPath.exists()) {
                    SSPath.mkdir();
                }
                new ProcessBuilder("scp", "SM/SM1"+id+".txt", "worker1:/tmp/SS").start();
                new ProcessBuilder("scp", "SM/SM2"+id+".txt", "worker2:/tmp/SS").start();
                new ProcessBuilder("scp", "SM/SM3"+id+".txt", "worker3:/tmp/SS").start();
            } catch (IOException e) {
                e.printStackTrace();
            } 
        } else if (args[1].equals("2")) {
            File[] files = new File("/tmp/SS").listFiles();
            BufferedReader br;
            try {
                for (File file : files) {
                    br = new BufferedReader(new FileReader(file));
                    String word = null;
                    while ((word = br.readLine()) != null) {
                        
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

// ABCDEFJ HIJKLMN OPQ
// RSTUVWX YZabcde fgh
// ijklmno pqrstuv wxyz