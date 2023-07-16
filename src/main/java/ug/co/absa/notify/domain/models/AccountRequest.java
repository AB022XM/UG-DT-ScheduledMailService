package ug.co.absa.notify.domain.models;

public record AccountRequest(String accountNumber, String transactionId) {


    @Override
    public String toString() {
        return "AccountRequest [accountNumber=" + accountNumber + ", transactionId=" + transactionId + "]";
    }


}
