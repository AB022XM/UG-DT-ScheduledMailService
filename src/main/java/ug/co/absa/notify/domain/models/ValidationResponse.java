package ug.co.absa.notify.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.annotation.Generated;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiPassword",
    "apiUsername",
    "createdBy",
    "errorCode",
    "errorDescription",
    "accountBal",
      "accountName",
    "accountNumber",
    "accountType",
    "address",
    "availableBal",
    "bouncedChqs",
    "currency",
    "customerId",
    "debtList",
    "emailAddress",
    "openingDate",
    "passportPhoto",
    "phoneNumber",
    "product",
    "signature",
    "status",
    "tranList"
})
@Generated("jsonschema2pojo")
public class ValidationResponse {

    @SerializedName("ApiPassword")
    @Expose
    public Object apiPassword;
    @SerializedName("ApiUsername")
    @Expose
    public Object apiUsername;
    @SerializedName("CreatedBy")
    @Expose
    public Object createdBy;
    @SerializedName("ErrorCode")
    @Expose
    public Object errorCode;
    @SerializedName("ErrorDescription")
    @Expose
    public Object errorDescription;
    @SerializedName("AccountBal")
    @Expose
    public String accountBal;
    @SerializedName("AccountName")
    @Expose
    public String accountName;
    @SerializedName("AccountNumber")
    @Expose
    public String accountNumber;
    @SerializedName("AccountType")
    @Expose
    public Object accountType;
    @SerializedName("Address")
    @Expose
    public Object address;
    @SerializedName("AvailableBal")
    @Expose
    public String availableBal;
    @SerializedName("BouncedChqs")
    @Expose
    public Object bouncedChqs;
    @SerializedName("Currency")
    @Expose
    public String currency;
    @SerializedName("CustomerId")
    @Expose
    public String customerId;
    @SerializedName("DebtList")
    @Expose
    public Object debtList;
    @SerializedName("EmailAddress")
    @Expose
    public String emailAddress;
    @SerializedName("OpeningDate")
    @Expose
    public Object openingDate;
    @SerializedName("PassportPhoto")
    @Expose
    public Object passportPhoto;
    @SerializedName("PhoneNumber")
    @Expose
    public String phoneNumber;
    @SerializedName("Product")
    @Expose
    public Object product;
    @SerializedName("Signature")
    @Expose
    public Object signature;
    @SerializedName("Status")
    @Expose
    public String status;
    @SerializedName("TranList")
    @Expose
    public Object tranList;




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ValidationResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("apiPassword");
        sb.append('=');
        sb.append(((this.apiPassword == null)?"<null>":this.apiPassword));
        sb.append(',');
        sb.append("apiUsername");
        sb.append('=');
        sb.append(((this.apiUsername == null)?"<null>":this.apiUsername));
        sb.append(',');
        sb.append("createdBy");
        sb.append('=');
        sb.append(((this.createdBy == null)?"<null>":this.createdBy));
        sb.append(',');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("errorDescription");
        sb.append('=');
        sb.append(((this.errorDescription == null)?"<null>":this.errorDescription));
        sb.append(',');
        sb.append("accountBal");
        sb.append('=');
        sb.append(((this.accountBal == null)?"<null>":this.accountBal));
        sb.append(',');
        sb.append("accountName");
        sb.append('=');
        sb.append(((this.accountName == null)?"<null>":this.accountName));
        sb.append(',');
        sb.append("accountNumber");
        sb.append('=');
        sb.append(((this.accountNumber == null)?"<null>":this.accountNumber));
        sb.append(',');
        sb.append("accountType");
        sb.append('=');
        sb.append(((this.accountType == null)?"<null>":this.accountType));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("availableBal");
        sb.append('=');
        sb.append(((this.availableBal == null)?"<null>":this.availableBal));
        sb.append(',');
        sb.append("bouncedChqs");
        sb.append('=');
        sb.append(((this.bouncedChqs == null)?"<null>":this.bouncedChqs));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("customerId");
        sb.append('=');
        sb.append(((this.customerId == null)?"<null>":this.customerId));
        sb.append(',');
        sb.append("debtList");
        sb.append('=');
        sb.append(((this.debtList == null)?"<null>":this.debtList));
        sb.append(',');
        sb.append("emailAddress");
        sb.append('=');
        sb.append(((this.emailAddress == null)?"<null>":this.emailAddress));
        sb.append(',');
        sb.append("openingDate");
        sb.append('=');
        sb.append(((this.openingDate == null)?"<null>":this.openingDate));
        sb.append(',');
        sb.append("passportPhoto");
        sb.append('=');
        sb.append(((this.passportPhoto == null)?"<null>":this.passportPhoto));
        sb.append(',');
        sb.append("phoneNumber");
        sb.append('=');
        sb.append(((this.phoneNumber == null)?"<null>":this.phoneNumber));
        sb.append(',');
        sb.append("product");
        sb.append('=');
        sb.append(((this.product == null)?"<null>":this.product));
        sb.append(',');
        sb.append("signature");
        sb.append('=');
        sb.append(((this.signature == null)?"<null>":this.signature));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("tranList");
        sb.append('=');
        sb.append(((this.tranList == null)?"<null>":this.tranList));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }


    /**
     * get field @SerializedName("ApiPassword")
     @Expose

      *
      * @return apiPassword @SerializedName("ApiPassword")
     @Expose

     */
    public Object getApiPassword() {
        return this.apiPassword;
    }

    /**
     * set field @SerializedName("ApiPassword")
     @Expose

      *
      * @param apiPassword @SerializedName("ApiPassword")
     @Expose

     */
    public void setApiPassword(Object apiPassword) {
        this.apiPassword = apiPassword;
    }

    /**
     * get field @SerializedName("ApiUsername")
     @Expose

      *
      * @return apiUsername @SerializedName("ApiUsername")
     @Expose

     */
    public Object getApiUsername() {
        return this.apiUsername;
    }

    /**
     * set field @SerializedName("ApiUsername")
     @Expose

      *
      * @param apiUsername @SerializedName("ApiUsername")
     @Expose

     */
    public void setApiUsername(Object apiUsername) {
        this.apiUsername = apiUsername;
    }

    /**
     * get field @SerializedName("CreatedBy")
     @Expose

      *
      * @return createdBy @SerializedName("CreatedBy")
     @Expose

     */
    public Object getCreatedBy() {
        return this.createdBy;
    }

    /**
     * set field @SerializedName("CreatedBy")
     @Expose

      *
      * @param createdBy @SerializedName("CreatedBy")
     @Expose

     */
    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * get field @SerializedName("ErrorCode")
     @Expose

      *
      * @return errorCode @SerializedName("ErrorCode")
     @Expose

     */
    public Object getErrorCode() {
        return this.errorCode;
    }

    /**
     * set field @SerializedName("ErrorCode")
     @Expose

      *
      * @param errorCode @SerializedName("ErrorCode")
     @Expose

     */
    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * get field @SerializedName("ErrorDescription")
     @Expose

      *
      * @return errorDescription @SerializedName("ErrorDescription")
     @Expose

     */
    public Object getErrorDescription() {
        return this.errorDescription;
    }

    /**
     * set field @SerializedName("ErrorDescription")
     @Expose

      *
      * @param errorDescription @SerializedName("ErrorDescription")
     @Expose

     */
    public void setErrorDescription(Object errorDescription) {
        this.errorDescription = errorDescription;
    }

    /**
     * get field @SerializedName("AccountBal")
     @Expose

      *
      * @return accountBal @SerializedName("AccountBal")
     @Expose

     */
    public String getAccountBal() {
        return this.accountBal;
    }

    /**
     * set field @SerializedName("AccountBal")
     @Expose

      *
      * @param accountBal @SerializedName("AccountBal")
     @Expose

     */
    public void setAccountBal(String accountBal) {
        this.accountBal = accountBal;
    }

    /**
     * get field @SerializedName("AccountName")
     @Expose

      *
      * @return accountName @SerializedName("AccountName")
     @Expose

     */
    public String getAccountName() {
        return this.accountName;
    }

    /**
     * set field @SerializedName("AccountName")
     @Expose

      *
      * @param accountName @SerializedName("AccountName")
     @Expose

     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * get field @SerializedName("AccountNumber")
     @Expose

      *
      * @return accountNumber @SerializedName("AccountNumber")
     @Expose

     */
    public String getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * set field @SerializedName("AccountNumber")
     @Expose

      *
      * @param accountNumber @SerializedName("AccountNumber")
     @Expose

     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * get field @SerializedName("AccountType")
     @Expose

      *
      * @return accountType @SerializedName("AccountType")
     @Expose

     */
    public Object getAccountType() {
        return this.accountType;
    }

    /**
     * set field @SerializedName("AccountType")
     @Expose

      *
      * @param accountType @SerializedName("AccountType")
     @Expose

     */
    public void setAccountType(Object accountType) {
        this.accountType = accountType;
    }

    /**
     * get field @SerializedName("Address")
     @Expose

      *
      * @return address @SerializedName("Address")
     @Expose

     */
    public Object getAddress() {
        return this.address;
    }

    /**
     * set field @SerializedName("Address")
     @Expose

      *
      * @param address @SerializedName("Address")
     @Expose

     */
    public void setAddress(Object address) {
        this.address = address;
    }

    /**
     * get field @SerializedName("AvailableBal")
     @Expose

      *
      * @return availableBal @SerializedName("AvailableBal")
     @Expose

     */
    public String getAvailableBal() {
        return this.availableBal;
    }

    /**
     * set field @SerializedName("AvailableBal")
     @Expose

      *
      * @param availableBal @SerializedName("AvailableBal")
     @Expose

     */
    public void setAvailableBal(String availableBal) {
        this.availableBal = availableBal;
    }

    /**
     * get field @SerializedName("BouncedChqs")
     @Expose

      *
      * @return bouncedChqs @SerializedName("BouncedChqs")
     @Expose

     */
    public Object getBouncedChqs() {
        return this.bouncedChqs;
    }

    /**
     * set field @SerializedName("BouncedChqs")
     @Expose

      *
      * @param bouncedChqs @SerializedName("BouncedChqs")
     @Expose

     */
    public void setBouncedChqs(Object bouncedChqs) {
        this.bouncedChqs = bouncedChqs;
    }

    /**
     * get field @SerializedName("Currency")
     @Expose

      *
      * @return currency @SerializedName("Currency")
     @Expose

     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * set field @SerializedName("Currency")
     @Expose

      *
      * @param currency @SerializedName("Currency")
     @Expose

     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * get field @SerializedName("CustomerId")
     @Expose

      *
      * @return customerId @SerializedName("CustomerId")
     @Expose

     */
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * set field @SerializedName("CustomerId")
     @Expose

      *
      * @param customerId @SerializedName("CustomerId")
     @Expose

     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get field @SerializedName("DebtList")
     @Expose

      *
      * @return debtList @SerializedName("DebtList")
     @Expose

     */
    public Object getDebtList() {
        return this.debtList;
    }

    /**
     * set field @SerializedName("DebtList")
     @Expose

      *
      * @param debtList @SerializedName("DebtList")
     @Expose

     */
    public void setDebtList(Object debtList) {
        this.debtList = debtList;
    }

    /**
     * get field @SerializedName("EmailAddress")
     @Expose

      *
      * @return emailAddress @SerializedName("EmailAddress")
     @Expose

     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * set field @SerializedName("EmailAddress")
     @Expose

      *
      * @param emailAddress @SerializedName("EmailAddress")
     @Expose

     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * get field @SerializedName("OpeningDate")
     @Expose

      *
      * @return openingDate @SerializedName("OpeningDate")
     @Expose

     */
    public Object getOpeningDate() {
        return this.openingDate;
    }

    /**
     * set field @SerializedName("OpeningDate")
     @Expose

      *
      * @param openingDate @SerializedName("OpeningDate")
     @Expose

     */
    public void setOpeningDate(Object openingDate) {
        this.openingDate = openingDate;
    }

    /**
     * get field @SerializedName("PassportPhoto")
     @Expose

      *
      * @return passportPhoto @SerializedName("PassportPhoto")
     @Expose

     */
    public Object getPassportPhoto() {
        return this.passportPhoto;
    }

    /**
     * set field @SerializedName("PassportPhoto")
     @Expose

      *
      * @param passportPhoto @SerializedName("PassportPhoto")
     @Expose

     */
    public void setPassportPhoto(Object passportPhoto) {
        this.passportPhoto = passportPhoto;
    }

    /**
     * get field @SerializedName("PhoneNumber")
     @Expose

      *
      * @return phoneNumber @SerializedName("PhoneNumber")
     @Expose

     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * set field @SerializedName("PhoneNumber")
     @Expose

      *
      * @param phoneNumber @SerializedName("PhoneNumber")
     @Expose

     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get field @SerializedName("Product")
     @Expose

      *
      * @return product @SerializedName("Product")
     @Expose

     */
    public Object getProduct() {
        return this.product;
    }

    /**
     * set field @SerializedName("Product")
     @Expose

      *
      * @param product @SerializedName("Product")
     @Expose

     */
    public void setProduct(Object product) {
        this.product = product;
    }

    /**
     * get field @SerializedName("Signature")
     @Expose

      *
      * @return signature @SerializedName("Signature")
     @Expose

     */
    public Object getSignature() {
        return this.signature;
    }

    /**
     * set field @SerializedName("Signature")
     @Expose

      *
      * @param signature @SerializedName("Signature")
     @Expose

     */
    public void setSignature(Object signature) {
        this.signature = signature;
    }

    /**
     * get field @SerializedName("Status")
     @Expose

      *
      * @return status @SerializedName("Status")
     @Expose

     */
    public String getStatus() {
        return this.status;
    }

    /**
     * set field @SerializedName("Status")
     @Expose

      *
      * @param status @SerializedName("Status")
     @Expose

     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get field @SerializedName("TranList")
     @Expose

      *
      * @return tranList @SerializedName("TranList")
     @Expose

     */
    public Object getTranList() {
        return this.tranList;
    }

    /**
     * set field @SerializedName("TranList")
     @Expose

      *
      * @param tranList @SerializedName("TranList")
     @Expose

     */
    public void setTranList(Object tranList) {
        this.tranList = tranList;
    }
}

