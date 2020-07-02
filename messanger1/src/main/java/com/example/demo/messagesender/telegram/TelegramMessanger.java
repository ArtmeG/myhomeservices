/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.messagesender.telegram;

import com.example.demo.config.consts.messanger.MessengerConfig;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author andrey_zatvornitskiy
 */
@Component
public class TelegramMessanger{

    private MessengerConfig messengerConfig;

    public TelegramMessanger(MessengerConfig messengerConfig) {
        this.messengerConfig = messengerConfig;
    }


    public void sendMessage(String message) {
        URL domain;
        try {
            domain = new URL(this.messengerConfig.getURL_STRING());

            URL url = new URL(domain + this.messengerConfig.getAPI_TOKEN()
                    +"/sendMessage?chat_id=" + this.messengerConfig.getCHAT_ID()
                    + "&text="+ message
            );
            URLConnection conn = url.openConnection();

            StringBuilder sb = new StringBuilder();
            InputStream is = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            String response = sb.toString();
            System.out.println(response);
        } catch (IOException ex) {
            Logger.getLogger(TelegramMessanger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
