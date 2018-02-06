import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        String str = "https://office.inspur.com/eportal/ui?columnId=2026746&pageId=2026745&viewTemplateId=9d883ed63e094c4aa15bf84c06682309&articleKey=2869684&version=4";
        Pattern pattern = Pattern.compile("articleKey=\\d+");
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            String param = matcher.group(0);
            String[] arr = param.split("=");
            String articleKey = arr[1];
            System.out.println(articleKey);
        }
    }

}
