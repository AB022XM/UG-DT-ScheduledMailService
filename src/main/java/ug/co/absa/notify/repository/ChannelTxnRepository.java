package ug.co.absa.notify.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import ug.co.absa.notify.domain.ChannelTxn;

import java.util.List;

/**
 * Spring Data JPA repository for the ChannelTxn entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ChannelTxnRepository extends JpaRepository<ChannelTxn, Long>
{
    @Procedure(procedureName = "update_channel_txn_status")
    void UPDATE_CHANNEL_TXN_STATUS(String finalStatus,String txnId);

    @Procedure(procedureName = "get_all_umeme_trans_for_token_alert_generation")
    List<ChannelTxn> GET_ALL_CHANNELS_TRANS_IN_THE_PAST_2_MINUTES_UMEME();



}
