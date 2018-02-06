import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) {

        String str = "13299" + "2017-05-13sssssssss";
        String str1 = "13298" + "2017-05-14";

        Date dateStart = new Date();
        System.out.println(dateStart.getTime());
        String strHash = Hashing.murmur3_128().hashString(str, StandardCharsets.UTF_8).toString();
        System.out.println(strHash);
        System.out.println(new Date().getTime());
    }

}
