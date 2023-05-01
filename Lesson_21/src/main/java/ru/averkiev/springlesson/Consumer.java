package ru.averkiev.springlesson;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Consumer
{
    public static void main( String[] args )
    {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> jsonToSend =  new HashMap<>();
        jsonToSend.put("name", "Test name");
        jsonToSend.put("job", "Test job");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);

        String urlGet = "https://reqres.in/api/users/2";
        String urlPost = "https://reqres.in/api/users";
//        String responseGet = restTemplate.getForObject(urlGet, String.class);

        String responsePost = restTemplate.postForObject(urlPost, request, String.class);
        System.out.println(responsePost);


    }
}
