package ug.co.absa.notify.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ug.co.absa.notify.domain.ChannelTxn;

import java.util.List;

/**
 * Spring Data JPA repository for the ChannelTxn entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ChannelTxnRepository extends JpaRepository<ChannelTxn, Long>
{
    @Procedure
    void UPDATE_CHANNEL_TXN_STATUS(String finalStatus,String txnId);

    @Procedure
    List<ChannelTxn> GET_ALL_CHANNELS_TRANS_IN_THE_PAST_2_MINUTES_UMEME();

}
