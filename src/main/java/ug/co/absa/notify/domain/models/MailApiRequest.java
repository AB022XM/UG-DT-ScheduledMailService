package ug.co.absa.notify.domain.models;

import jakarta.annotation.Generated;

import java.util.List;

@Generated("jsonschema2pojo")
public class MailApiRequest {

    public String apiUsername;
    public String apiPassword;
    public List<String> accountNumbers;

    public MailApiRequest() {
        this.apiUsername = "API";
        this.apiPassword = "@cool@f1Xnes";
    }

    public MailApiRequest(List<String> accountNumbers) {
        this.apiUsername = "API";
        this.apiPassword = "@cool@f1Xnes";
        this.accountNumbers = accountNumbers;
    }

    public MailApiRequest(String apiUsername, String apiPassword, List<String> accountNumbers) {

        this.apiUsername = apiUsername;
        this.apiPassword = apiPassword;
        this.accountNumbers = accountNumbers;
    }


    public String getApiUsername() {
        return apiUsername;
    }


    public void setApiUsername(String apiUsername) {
        this.apiUsername = apiUsername;
    }



}
