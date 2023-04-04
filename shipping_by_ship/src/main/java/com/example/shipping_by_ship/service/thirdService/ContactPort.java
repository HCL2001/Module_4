package com.example.shipping_by_ship.service.thirdService;

import com.example.shipping_by_ship.service.IShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ContactPort {

    @Autowired
    private IShipService iShipService;

    private RestTemplate restTemplate;

    public void findAll(){
        RequestEntity<?> request = RequestEntity.post("http://192.168.4.75:8080/api/ships-list")
                .accept(MediaType.APPLICATION_JSON)
                .header("url", "http://192.168.4.89")
                .header("secret_key", "@123456")
                .header("signature", "longHoang")
                .body(iShipService.findAll());
        ResponseEntity<?> response = restTemplate.exchange(request, String.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());
    }

    public  void demo(){
        RequestEntity<?> request = RequestEntity.post("http://192.168.4.99:8080/receipt/confirmation")
                .accept(MediaType.APPLICATION_JSON)
                .body("Hello");
        ResponseEntity<?> response = restTemplate.exchange(request, String.class);
        System.out.println(response.getBody());
    }

}
