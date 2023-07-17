package ug.co.absa.notify.domain.models;

import java.util.List;

public class ValidationApiRequest {

    public String apiUsername;
    public String apiPassword;
    public List<String> accountNumbers;

    public ValidationApiRequest() {
        this.apiUsername = "API";
        this.apiPassword = "@cool@f1Xnes";
    }

    public ValidationApiRequest(List<String> accountNumbers) {
        this.apiUsername = "API";
        this.apiPassword = "@cool@f1Xnes";
        this.accountNumbers = accountNumbers;
    }

    public ValidationApiRequest(String apiUsername, String apiPassword, List<String> accountNumbers) {

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
