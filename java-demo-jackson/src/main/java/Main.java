import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        String s1 = "sha256:0d00815ab2a92300dec7a9ee34e97b08645dc75ed519c5e4790a25af6d439e9b";
//
//        String s12 = "0d00815ab2a92300dec7a9ee34e97b08645dc75ed519c5e4790a25af6d439e9b";
//
//        String s2 = "sha256:ccec1a82e9d3834a2f0ac7fcd0ac8f920b0856c0f272e62b8c9eaef3d009a4f0";
//
//        String s22 = "0d00815ab2a92300dec7a9ee34e97b08645dc75ed519c5e4790a25af6d439e9b";
//
//        String s3 = "d00815ab2a92300dec7a9ee34e97b08645dc75ed519c5e4790a25af6d439e9b";
//
//        String s4 = "bc913fa0ba7e25bbdac2789e2c7a49b88a99a208";
//
//        System.out.println(s3.length());
//
//        System.out.println(s1.length() + "   " + s2.length());
//
//        System.out.println(s12.length() + "   " + s22.length());
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        Map<Resource, Integer> map = new HashMap<Resource, Integer>();
//        Resource resourceA = new Resource(1, "chair");
//        Resource resourceB = new Resource(2, "desk");
//        map.put(resourceA, 23);
//        map.put(resourceB, 30);
//
//        String result = mapper.writeValueAsString(map);
//        System.out.println("this is the test for json: " + result);

//        Map mapResource = (Map) mapper.readerFor(Map.class).readValues("{\"id\":\"123\"}");
//        System.out.println("this is the test for deserialization: " + mapResource);

        String str = "{\"time\": {\"new\": 123, \"old\": 456}}";
        ObjectMapper mapper1 = new ObjectMapper();
        JsonNode node = mapper1.readTree(str);
        System.out.println(node);



    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Resource {
        int id;
        String name;
    }

}
