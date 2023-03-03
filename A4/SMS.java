import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS {
    public static final String ACCOUNT_SID = ""; 
    public static final String AUTH_TOKEN = "";  

    public void sendMessage(String phoneNumber, String MSG) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+1" + phoneNumber), // number to send message to 
                new com.twilio.type.PhoneNumber("+18058550994"), // number used from twilio free API trail
                MSG)
            .create();
        System.out.println(message.getSid());
    }
} 
    

