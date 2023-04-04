package com.example.shipping_by_ship.service.thirdService;

import com.example.shipping_by_ship.repository.IShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class Demo {

    private static final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    IShipRepository iShipRepository;

    public static List<?> request(String message) {
        RequestEntity<?> pre_book_request = RequestEntity.post("http://localhost:8080/api/ships")
                .accept(MediaType.APPLICATION_JSON)
                .header("url", "http://localhost:8080/api/book_ship_demo")
                .header("method", "post")
                .body(message, String.class);
        ResponseEntity<?> book_request = restTemplate.exchange(pre_book_request, List.class);
        return (List<?>) book_request.getBody();
    }

    public static void respone(String message, String url) {
        RequestEntity<?> book_respone = RequestEntity.post(url)
                .accept(MediaType.APPLICATION_JSON)
                .header("url", "http://localhost:8080/api/respone_demo")
                .header("method", "post")
                .body(message, Object.class);
        ResponseEntity<?> book_request = restTemplate.exchange(book_respone, String.class);
        System.out.println(book_respone.getBody());
    }

//    public static ResponseEntity<?> demoRes(){
//        return new ResponseEntity<>("OK bro", HttpStatus.OK);
//    }

    public static boolean final1(String message){
        RequestEntity<?> request = RequestEntity.post("http://localhost:8080/api/ships")
                .accept(MediaType.APPLICATION_JSON)
                .header("url", "http://localhost:8080/api/book_ship_demo")
                .body(message);
        ResponseEntity<?> response = restTemplate.exchange(request, String.class);
        return response.getBody() != null;
    }


}
