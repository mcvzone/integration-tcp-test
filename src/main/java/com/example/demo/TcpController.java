package com.example.demo;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TcpController {
    
    final GenericXmlApplicationContext context;
    final SimpleGateway simpleGateway;
    
    public TcpController(){
        this.context = new GenericXmlApplicationContext();
        context.load("classpath:/META-INF/tcpClientServerDemo-context.xml");
        context.registerShutdownHook();
        context.refresh();
        
        this.simpleGateway = context.getBean(SimpleGateway.class);
    }
    
    @RequestMapping("/tcp/test")
    public String test(String name) {
        //SimpleGateway simpleGateway = context.getBean(SimpleGateway.class);
        String result = simpleGateway.send(name);
        System.out.println("result : " + result);
        return result;
    }

}
