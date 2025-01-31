package ua.home.telegrameservice.messanger;

import ua.home.telegrameservice.messagesender.telegram.TelegramMessanger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelegramMessangerTest
{

    @Autowired
    TelegramMessanger telegramMessanger;

    @Test
    public void sendTestMessage() throws UnsupportedEncodingException
    {
        telegramMessanger.sendMessage("hello");
    }
}
