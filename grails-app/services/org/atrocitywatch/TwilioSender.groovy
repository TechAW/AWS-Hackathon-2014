package org.atrocitywatch

import com.twilio.sdk.TwilioRestClient
import com.twilio.sdk.TwilioRestException
import com.twilio.sdk.resource.factory.MessageFactory
import com.twilio.sdk.resource.instance.Message
import org.apache.http.NameValuePair
import org.apache.http.message.BasicNameValuePair

/**
 * @author jdahlbom
 * @since 11/11/14 10:21
 */
class TwilioSender {
    private String ACCOUNT_SID = "";
    private String AUTH_TOKEN = "";
    private String SENDER_NUMBER = "";

    public TwilioSender() {
        Map<String, String> env = System.getenv();
        ACCOUNT_SID = env.get("TWILIO_ACCOUNT_SID");
        AUTH_TOKEN = env.get("TWILIO_AUTH_TOKEN");
        SENDER_NUMBER = env.get("TWILIO_SENDER_NUMBER");
    }

    public void sendSMS(String receivingNumber, String message) {
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
            // Build a filter for the MessageList
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Body", message));
            params.add(new BasicNameValuePair("To", receivingNumber));
            params.add(new BasicNameValuePair("From", SENDER_NUMBER));

            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message smsMessage = messageFactory.create(params);
        }
        catch (TwilioRestException e) {
            if (e.getErrorCode() == 400) {
                // Normal error from wrong number, unable to deliver.
            } else {
                // Internal server error, actual error.
            }
        }
    }
}
