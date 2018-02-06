package news.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is {@link News}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    int id;

    int key;

    String name;

    int order;

}
