package ug.co.absa.notify.domain.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EmailContent",
    "EmailAddreses",
    "CopyInEmails",
    "Attachments"
})
@Generated("jsonschema2pojo")
public class MailApiRequest {

    @JsonProperty("EmailContent")
    @Valid
    public EmailContent emailContent;


    @JsonProperty("EmailAddreses")
    @Valid
    public List<String> emailAddreses;


    @JsonProperty("CopyInEmails")
    @Valid
    public List<String> copyInEmails;


    @JsonProperty("Attachments")
    @Valid
    public List<String> attachments;

    public MailApiRequest() {
    }

    @JsonProperty("EmailContent")
    public EmailContent getEmailContent() {
        return emailContent;
    }

    public MailApiRequest(EmailContent emailContent, List<String> emailAddreses,
                          List<String> copyInEmails, List<String> attachments) {
        this.emailContent = emailContent;
        this.emailAddreses = emailAddreses;
        this.copyInEmails = copyInEmails;
        this.attachments = attachments;
    }

    @JsonProperty("EmailContent")
    public void setEmailContent(EmailContent emailContent) {
        this.emailContent = emailContent;
    }

    @JsonProperty("EmailAddreses")
    public List<String> getEmailAddreses() {
        return emailAddreses;
    }

    @JsonProperty("EmailAddreses")
    public void setEmailAddreses(List<String> emailAddreses) {
        this.emailAddreses = emailAddreses;
    }

    @JsonProperty("CopyInEmails")
    public List<String> getCopyInEmails() {
        return copyInEmails;
    }

    @JsonProperty("CopyInEmails")
    public void setCopyInEmails(List<String> copyInEmails) {
        this.copyInEmails = copyInEmails;
    }

    @JsonProperty("Attachments")
    public List<String> getAttachments() {
        return attachments;
    }

    @JsonProperty("Attachments")
    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "MailApiRequest{" + "emailContent=" + emailContent + ", emailAddreses=" + emailAddreses + ", copyInEmails=" + copyInEmails
                        + ", attachments=" + attachments + '}';
    }




}
