package ug.co.absa.notify.utility;


import ug.co.absa.notify.domain.AlertsTb;
import ug.co.absa.notify.domain.ChannelTxn;
import ug.co.absa.notify.domain.models.EmailContent;


public class Helpers {

    public static String createEmailBody(ChannelTxn channelTxn,String customerName) {

        if(customerName!=null) customerName ="Customer";


        return (
            "<p>Dear "+customerName+",</p>\n" +
            "\n" +
            "<p>Your Umeme prepaid bill payment has been successfully processed with the details below.</p>\n" +
            "\n" +
            "<p>Absa Transaction ID: " +channelTxn.getTxnID() +"From Account: "+Helpers.maskNumber(channelTxn.getAccountNo(),"xxxxxxx###")+"UGX "+channelTxn.getAmount()+"\nBiller Details: "+channelTxn.getMNTxnID()+" Amount: UGX: "+channelTxn.getAmount()+" Yaka Token: "+ channelTxn.getMessage()+" Date/Time Paid:"+channelTxn.getTxnDate()+"</p>\n" +
            "\n" +
            "<p>You can call us on 0800 222 333 / +256 312 218 348 or WhatsApp +256 707 433 433 in case you require more details.</p>\n" +
            "\n" +
            "<p>Thank you for choosing Absa Bank.</p>\n" +
            "\n" +
            "<p>Your sincerely, Absa Bank Digital</p>"

           + "<p>Absa Bank Uganda</p>"
        );

    }

    public static String maskNumber(String number, String mask) {

        int index = 0;
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                masked.append(number.charAt(index));
                index++;
            } else if (c == 'x') {
                masked.append(c);
                index++;
            } else {
                masked.append(c);
            }
        }
        return masked.toString();
    }




    public static EmailContent generateEmailContent(AlertsTb alertsTb) {

        return   new  EmailContent("ABSA  UMEME PREPAID TOKEN (YAKA)",
            "noreply@absa.za",
            alertsTb.getAlertMessage(), false);
    }





}
