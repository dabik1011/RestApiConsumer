import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("Введите текст ");
        Scanner scanner = new Scanner(System.in);
        String sentenceToTranslate = scanner.nextLine();

        RestTemplate restTemplate = new RestTemplate();

        String url = "здесь сайт я ндекс облака , который указан в документации";

        //Теперь нужно передать заголовки: 1.показываем, что передаем json
        // 2. Токен , который дает яндекс для защиты, индефикации
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authoriazation", "Bearer " + "токен , который дал яндекс");

        //теперь передадим данные json
        Map<String,String> jsonData = new HashMap<>();
        jsonData.put("folderId", "это имя фолдера тоже дает яяндекс");
        jsonData.put("targetLanguageCode", "en");
        jsonData.put("text", "[" + sentenceToTranslate +"]");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, httpHeaders);

//        String response = restTemplate.postForObject(url, request, String.class);
//        System.out.println(response);// Выведет json перевода

        // Сейчас сделаем , чтобы выводилась только строка с перевода с json с помощью ObjectMapper

        //with the help Jackson
        //Создается, что не использовать доп класс
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(response);
//
//        System.out.println("Перевод: "  + jsonNode.get("translations").get(0).get("text"));

        //Сделаем через отдельные классы
        YandexResponse yandexResponse = restTemplate.postForObject(url, request, YandexResponse.class);
        System.out.println("Перевод: " +  yandexResponse.getTranslations().get(0).getText());
    }
}
