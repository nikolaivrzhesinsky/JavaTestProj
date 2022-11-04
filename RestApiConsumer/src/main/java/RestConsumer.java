import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestConsumer {

    public static void main(String[] args) {

        RestTemplate restTemplate= new RestTemplate();

        String urlGet= "https://reqres.in/api/users/2";
        String response= restTemplate.getForObject(urlGet,String.class);

        String urlPost="https://reqres.in/api/users/";
        HashMap<String,String> requestData= new HashMap<String, String>();
        requestData.put("name","Jorge");
        requestData.put("job","SexPutan");
        HttpEntity<HashMap<String,String>> request= new HttpEntity<>(requestData);
        String response2= restTemplate.postForObject(urlPost,request,String.class);

        System.out.println(response);
        System.out.println(response2);
    }

}
