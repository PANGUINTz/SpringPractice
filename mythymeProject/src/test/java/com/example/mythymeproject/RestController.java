package com.example.mythymeproject;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestController {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getIsbnTest(){
        String isbn = "1933988673";
        List resp = restTemplate.getForObject("http://localhost:"+port+"/books?isbn="+isbn,List.class);
        assertEquals(resp.get(0).toString().contains(isbn), true);
    }
@Test
public void getIsbnTestExceptionFail() {
//    String isbn = "11111111";
    String isbn = "1933988673";
    List resp = restTemplate.getForObject("http://localhost:"+port+"/books?isbn="+isbn,List.class);
    if (resp.size() == 0) {
        assertThrows(NullPointerException.class,()-> {
            resp.get(0).toString();
        },"ISBN Exception error was expected");
    } else {
        assertEquals(1, resp.size(), "Didn't not return expected result");
    }
}
    @Test
    public void getIsbnTestHttp() {
        String isbn= "1933988673";
        ResponseEntity<List> resp = restTemplate.getForEntity("http://localhost:"+port+"/books?isbn="+isbn,List.class);
        assertEquals(resp.getStatusCode(), HttpStatus.OK);
    }
}
