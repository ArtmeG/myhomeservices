package ua.home.telegrameservice.config.consts.messanger;

        import lombok.AllArgsConstructor;
        import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessengerConfig
{
    private String URL_STRING;// = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
    private String API_TOKEN;// = "648719423:AAEVkvOzQB44AA70toxFmetLPKGPgyY7W14";
    private String CHAT_ID;// = "@testofbotchannel";
}