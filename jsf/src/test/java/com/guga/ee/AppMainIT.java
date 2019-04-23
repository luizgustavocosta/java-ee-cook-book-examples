package com.guga.ee;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppMainIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void given_a_request_when_page_is_found_then_return_ok() {
        webTestClient.get().uri("/ui/index.xhtml").exchange().expectStatus().isOk();
    }

    @Test
    void given_a_request_when_page_is_not_found_then_return_error() {
        webTestClient.get().uri("/ui/other_page.xhtml").exchange().expectStatus().is4xxClientError();
    }
}