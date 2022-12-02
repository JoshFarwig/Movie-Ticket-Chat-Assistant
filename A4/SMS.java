import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMS {
    public static final String ACCOUNT_SID = "AC7279ab828c97ab80bd482e8359b18652"; 
    public static final String AUTH_TOKEN = "0c9d15d6f0b0f7886296dbdb898fa307";  

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
    

