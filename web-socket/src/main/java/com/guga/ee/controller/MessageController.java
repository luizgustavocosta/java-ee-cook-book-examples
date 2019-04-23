package com.guga.ee.controller;

import com.guga.ee.message.MyResponse;
import com.guga.ee.message.MyRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public MyResponse newMessage(MyRequest message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new MyResponse("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
