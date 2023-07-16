package ug.co.absa.notify.repository

/**
 * A Projection for the {@link ug.co.absa.notify.domain.ChannelTxn} entity
 */
interface ChannelTxnInfo {
    val accountNo: String?
    val txnDate: String?
    val narrative: String?
    val amount: String?
    val txnID: String?
    val utilityRef: String?
    val message: String?
    val notifiedStatus: String?
    val settlementDate: String?
    val responseXml: String?


}
