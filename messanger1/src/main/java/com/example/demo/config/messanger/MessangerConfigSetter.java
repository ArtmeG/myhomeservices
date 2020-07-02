package com.example.demo.config.messanger;

import com.example.demo.config.consts.messanger.MessengerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MessangerConfigSetter {

    @Autowired
    private Environment enviroment;

    @Bean
    public MessengerConfig messangerConfig() {

        return new MessengerConfig(
                enviroment.getProperty("messanger.url"),
                enviroment.getProperty("api.tokkens"),
                enviroment.getProperty("chat.id")
        );
    }


}
