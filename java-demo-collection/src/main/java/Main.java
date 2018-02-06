import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        Collection collection = new HashSet();

        Iterator iterator = collection.iterator();

        for (; iterator.hasNext();) {
            Object obj = iterator.next();

        }
    }

}
