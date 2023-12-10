import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String filename = "file.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        String pattern1 = "\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}";
        String pattern2 = "[0-9]{3}-[0-9]{3}-[0-9]{4}";

        Pattern r1 = Pattern.compile(pattern1);
        Pattern r2 = Pattern.compile(pattern2);

        Matcher m1 = r1.matcher(phoneNumber);
        Matcher m2 = r2.matcher(phoneNumber);

        return m1.find() || m2.find();
    }
}