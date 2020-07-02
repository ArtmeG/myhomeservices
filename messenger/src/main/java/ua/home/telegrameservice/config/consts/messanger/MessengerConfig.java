package ua.home.telegrameservice.config.consts.messanger;

public class MessengerConfig
{

    private String URL_STRING;// = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
    private String API_TOKEN;// = "648719423:AAEVkvOzQB44AA70toxFmetLPKGPgyY7W14";
    private String CHAT_ID;// = "@testofbotchannel";

    public MessengerConfig(String url, String apiToken, String chatId)
    {
        this.URL_STRING = url;
        this.API_TOKEN = apiToken;
        this.CHAT_ID = chatId;
    }

    public String getURL_STRING()
    {
        return URL_STRING;
    }

    public String getAPI_TOKEN()
    {
        return API_TOKEN;
    }

    public String getCHAT_ID()
    {
        return CHAT_ID;
    }

}