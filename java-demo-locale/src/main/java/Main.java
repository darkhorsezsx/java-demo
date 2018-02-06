import java.util.List;
import java.util.Locale;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Locale localeDefault = Locale.getDefault();
        System.out.println("Default Locale: " + localeDefault);

        Locale.setDefault(new Locale("zh", "TW"));
        localeDefault = Locale.getDefault();
        System.out.println("Default Locale after set: " + localeDefault);

        Locale[] availableLocales = Locale.getAvailableLocales();
        System.out.println("availableLocales");
        for (Locale locale : availableLocales) {
            System.out.print(locale + "  ");
        }
        System.out.println();

        String[] isoCountries = Locale.getISOCountries();
        System.out.println("isoCountries");
        for (String str : isoCountries) {
            System.out.print(str + "  ");
        }
        System.out.println();
        String[] isoLanguages = Locale.getISOLanguages();
        System.out.println("isoLanguages");
        for (String str : isoLanguages) {
            System.out.print(str + "  ");
        }
        System.out.println();

        Locale locale = new Locale("en", Locale.US.getCountry());
        System.out.println(locale.getCountry());
        System.out.println(locale.getISO3Country());
        System.out.println(locale.getISO3Language());
        System.out.println(locale.getDisplayName());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayVariant() + "sss");
        System.out.println(locale.getVariant());
        System.out.println(locale.toLanguageTag());
        System.out.println(locale);

    }

}
