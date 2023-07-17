package ug.co.absa.notify.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A ChannelTxn.
 */
@Entity
@Table(name = "channel_txns")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ChannelTxn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "Txn_date")
    private String txnDate;

    @Column(name = "Narrative")
    private String narrative;

    @Column(name = "amount")
    private String amount;


    @Size(min = 2)
    @Column(name = "txnID")
    private String txnID;

    @Column(name = "utilityref")
    private String utilityRef;

    @Column(name = "transaction_id")
    private String transactionID;

    @Column(name = "MNO")
    private String mNO;

    @Column(name = "Txn_type")
    private String txnType;

    @Column(name = "txn_status")
    private String txnStatusMno;

    @Column(name = "MNO_txn_ID")
    private String mNTxnID;

    @Column(name = "Message")
    private String message;

    @Column(name = "Notified_status")
    private String notifiedStatus;

    @Column(name = "date_inserted")
    private String dateInserted;

    @Column(name = "RecordId")
    private String recordId;

    @Column(name = "final_status")
    private String finalStatus;

    @Column(name = "settlement_Date")
    private String settlementDate;

    @Column(name = "Source_Account")
    private String Source_Account;

    @Column(name = "paymentcompleteddate",nullable = true)
    private String paymentcompleteddate;
    @Column(name = "responsexml")
    private String responsexml;

    @Column(name = "requestxml")
    private String requestxml;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field @Column(name = "account_no")
     *
     * @return accountNo @Column(name = "account_no")

     */
    public String getAccountNo() {
        return this.accountNo;
    }

    /**
     * set field @Column(name = "account_no")
     *
     * @param  @Column(name = "account_no")

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * get field @Column(name = "Txn_date")
     *
     * @return txnDate @Column(name = "Txn_date")

     */
    public String getTxnDate() {
        return this.txnDate;
    }

    /**
     * set field @Column(name = "Txn_date")
     *
     * @param  @Column(name = "Txn_date")

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    /**
     * get field @Column(name = "Narrative")
     *
     * @return narrative @Column(name = "Narrative")

     */
    public String getNarrative() {
        return this.narrative;
    }

    /**
     * set field @Column(name = "Narrative")
     *
     * @param narrative @Column(name = "Narrative")

     */
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    /**
     * get field @Column(name = "amount")
     *
     * @return amount @Column(name = "amount")

     */
    public String getAmount() {
        return this.amount;
    }

    /**
     * set field @Column(name = "amount")
     *
     * @param amount @Column(name = "amount")

     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * get field @Size(min = 2)
     @Column(name = "txnID")

      *
      * @return txnID @Size(min = 2)
     @Column(name = "txnID")

     */
    public String getTxnID() {
        return this.txnID;
    }

    /**
     * set field @Size(min = 2)
     @Column(name = "txnID")

      *
      * @param txnID @Size(min = 2)
     @Column(name = "txnID")

     */
    public void setTxnID(String txnID) {
        this.txnID = txnID;
    }

    /**
     * get field @Column(name = "utilityref")
     *
     * @return utilityRef @Column(name = "utilityref")

     */
    public String getUtilityRef() {
        return this.utilityRef;
    }

    /**
     * set field @Column(name = "utilityref")
     *
     * @param utilityRef @Column(name = "utilityref")

     */
    public void setUtilityRef(String utilityRef) {
        this.utilityRef = utilityRef;
    }

    /**
     * get field @Column(name = "transaction_id")
     *
     * @return transactionID @Column(name = "transaction_id")

     */
    public String getTransactionID() {
        return this.transactionID;
    }

    /**
     * set field @Column(name = "transaction_id")
     *
     * @param transactionID @Column(name = "transaction_id")

     */
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    /**
     * get field @Column(name = "MNO")
     *
     * @return mNO @Column(name = "MNO")

     */
    public String getMNO() {
        return this.mNO;
    }

    /**
     * set field @Column(name = "MNO")
     *
     * @param mNO @Column(name = "MNO")

     */
    public void setMNO(String mNO) {
        this.mNO = mNO;
    }

    /**
     * get field @Column(name = "Txn_type")
     *
     * @return txnType @Column(name = "Txn_type")

     */
    public String getTxnType() {
        return this.txnType;
    }

    /**
     * set field @Column(name = "Txn_type")
     *
     * @param txnType @Column(name = "Txn_type")

     */
    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    /**
     * get field @Column(name = "txn_status")
     *
     * @return txnStatusMno @Column(name = "txn_status")

     */
    public String getTxnStatusMno() {
        return this.txnStatusMno;
    }

    /**
     * set field @Column(name = "txn_status")
     *
     * @param txnStatusMno @Column(name = "txn_status")

     */
    public void setTxnStatusMno(String txnStatusMno) {
        this.txnStatusMno = txnStatusMno;
    }

    /**
     * get field @Column(name = "MNO_txn_ID")
     *
     * @return mNTxnID @Column(name = "MNO_txn_ID")

     */
    public String getMNTxnID() {
        return this.mNTxnID;
    }

    /**
     * set field @Column(name = "MNO_txn_ID")
     *
     * @param mNTxnID @Column(name = "MNO_txn_ID")

     */
    public void setMNTxnID(String mNTxnID) {
        this.mNTxnID = mNTxnID;
    }

    /**
     * get field @Column(name = "Message")
     *
     * @return message @Column(name = "Message")

     */
    public String getMessage() {
        return this.message;
    }

    /**
     * set field @Column(name = "Message")
     *
     * @param message @Column(name = "Message")

     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * get field @Column(name = "Notified_status")
     *
     * @return notifiedStatus @Column(name = "Notified_status")

     */
    public String getNotifiedStatus() {
        return this.notifiedStatus;
    }

    /**
     * set field @Column(name = "Notified_status")
     *
     * @param notifiedStatus @Column(name = "Notified_status")

     */
    public void setNotifiedStatus(String notifiedStatus) {
        this.notifiedStatus = notifiedStatus;
    }

    /**
     * get field @Column(name = "date_inserted")
     *
     * @return dateInserted @Column(name = "date_inserted")

     */
    public String getDateInserted() {
        return this.dateInserted;
    }

    /**
     * set field @Column(name = "date_inserted")
     *
     * @param dateInserted @Column(name = "date_inserted")

     */
    public void setDateInserted(String dateInserted) {
        this.dateInserted = dateInserted;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public ChannelTxn recordId(String recordId) {
        this.setRecordId(recordId);
        return this;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    /**
     * get field @Column(name = "final_status")
     *
     * @return finalStatus @Column(name = "final_status")

     */
    public String getFinalStatus() {
        return this.finalStatus;
    }

    /**
     * set field @Column(name = "final_status")
     *
     * @param finalStatus @Column(name = "final_status")

     */
    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    /**
     * get field @Column(name = "settlement_Date")
     *
     * @return settlementDate @Column(name = "settlement_Date")

     */
    public String getSettlementDate() {
        return this.settlementDate;
    }

    /**
     * set field @Column(name = "settlement_Date")
     *
     * @param settlementDate @Column(name = "settlement_Date")

     */
    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    /**
     * get field @Column(name = "Source_Account")
     *
     * @return Source_Account @Column(name = "Source_Account")

     */
    public String getSource_Account() {
        return this.Source_Account;
    }

    /**
     * set field @Column(name = "Source_Account")
     *
     * @param Source_Account @Column(name = "Source_Account")

     */
    public void setSource_Account(String Source_Account) {
        this.Source_Account = Source_Account;
    }


    /**
     * get field @Column(name = "responsexml")
     *
     * @return responsexml @Column(name = "responsexml")

     */
    public String getResponsexml() {
        return this.responsexml;
    }

    /**
     * set field @Column(name = "responsexml")
     *
     * @param responsexml @Column(name = "responsexml")

     */
    public void setResponsexml(String responsexml) {
        this.responsexml = responsexml;
    }


    /**
     * get field @Column(name = "requestxml")
     *
     * @return requestxml @Column(name = "requestxml")

     */
    public String getRequestxml() {
        return this.requestxml;
    }

    /**
     * set field @Column(name = "requestxml")
     *
     * @param requestxml @Column(name = "requestxml")

     */
    public void setRequestxml(String requestxml) {
        this.requestxml = requestxml;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChannelTxn)) {
            return false;
        }
        return id != null && id.equals(((ChannelTxn) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ChannelTxn{" +
            "id=" + getId() +
            ", accountNo='" + getAccountNo() + "'" +
            ", txnDate='" + getTxnDate() + "'" +
            ", narrative='" + getNarrative() + "'" +
            ", amount='" + getAmount() + "'" +
            ", txnID='" + getTxnID() + "'" +
            ", utilityRef='" + getUtilityRef() + "'" +
            ", transactionID='" + getTransactionID() + "'" +
            ", mNO='" + getMNO() + "'" +
            ", txnType='" + getTxnType() + "'" +
            ", txnStatusMno='" + getTxnStatusMno() + "'" +
            ", mNTxnID='" +getMNTxnID() + "'" +
            ", message='" + getMessage() + "'" +
            ", notifiedStatus='" + getNotifiedStatus() + "'" +
            ", dateInserted='" + getDateInserted() + "'" +
            ", recordId='" + getRecordId() + "'" +
            ", finalStatus='" + getFinalStatus() + "'" +
            ", settlementDate='" + getSettlementDate() + "'" +
            ", requestXml='" +getResponsexml() + "'" +
            ", responseXml='" + getResponsexml() + "'" +
            "}";
    }

    public static  AlertsTb ToAlertsTb(ChannelTxn channelTxn) {
        AlertsTb alertsTb = new AlertsTb();
        alertsTb.setAlertId("UMEME-MAIL-"+channelTxn.getTxnID());
        alertsTb.setStatus("PENDING");
        alertsTb.alertDate(ZonedDateTime.now());
        alertsTb.setRawRequest("No request yet");
        alertsTb.setAlertType("UMEME-MAIL");
        alertsTb.createdAt(ZonedDateTime.now());

        alertsTb.alertTimestamp (ZonedDateTime.now());
        alertsTb.setAlertMessage("");
        alertsTb.setAlertFreeField1("EMAIL");
        alertsTb.setAlertFreeField2(channelTxn.getAccountNo());
        alertsTb.setAlertFreeField3(channelTxn.getRecordId());
        alertsTb.setAlertFreeField4(channelTxn.getNarrative() );



        return alertsTb;
    }

}
