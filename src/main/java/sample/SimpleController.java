package sample;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SimpleController {

    @RequestMapping("/")
    @ResponseBody
    String root() { return "root."; }

    @MessageMapping("/batsu")
    @SendTo("/dashboard")
    public Batsu batsu(SimpleMessage message) throws Exception {
        Thread.sleep(1000); // delay
        if (message.getName().equals("Tanaka"))  return new Batsu("Thailand Kick");
        return new Batsu("Ketsu Bat");
    }

}
