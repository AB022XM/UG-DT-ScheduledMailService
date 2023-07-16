package ug.co.absa.notify.utility;


import ug.co.absa.notify.domain.AlertsTb;
import ug.co.absa.notify.domain.ChannelTxn;
import ug.co.absa.notify.domain.models.EmailContent;

public class Helpers {
    public static String createEmailBody(ChannelTxn channelTxn) {
        return"This is the email Body";
    }

    public static String createEmailSubject(ChannelTxn channelTxn) {
        return"This is a PROD Test";


    }

    public static String createEmailBody(ChannelTxn channelTxn, String message) {


        return"This is the email Body";
    }



    public static EmailContent generateEmailContent(AlertsTb alertsTb) {
        return   new  EmailContent(alertsTb.getAlertFreeField2(),"noreply@absa.za",
            alertsTb.getAlertMessage(), false);
    }

}
