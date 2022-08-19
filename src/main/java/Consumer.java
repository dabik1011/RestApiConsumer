import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        //1 Get
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "https://reqres.in/api/users/2";

//        String response = restTemplate.getForObject(url, String.class);
//
//        System.out.println(response);


        //2 Post

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://reqres.in/api/users";

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Some test name");
        jsonToSend.put("job", "Some job test");

        HttpEntity<Map<String ,String >> request = new HttpEntity<>(jsonToSend);

        String response = restTemplate.postForObject(url, request, String.class);

        System.out.println(response);
    }
}
