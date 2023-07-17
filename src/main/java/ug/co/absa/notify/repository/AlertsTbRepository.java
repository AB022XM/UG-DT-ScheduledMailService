package ug.co.absa.notify.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ug.co.absa.notify.domain.AlertsTb;

/**
 * Spring Data JPA repository for the AlertsTb entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AlertsTbRepository extends JpaRepository<AlertsTb, UUID> {

    @Transactional
    @Modifying
    @Query("update AlertsTb a set a.alertStatus = ?1, a.alertStatus = ?2  where a.alertId = ?3")
    int updateAlertStatusByAlertId(String alertStatus,String alertFreeField5, String alertId);
    @Transactional
    @Modifying
    @Query("update AlertsTb a set a.alertFreeField1 = ?1 where a.alertId = ?2")
    int updateAlertFreeField1ByAlertId(String alertFreeField1, String alertId);

    @Transactional
    @Modifying
    @Query("update AlertsTb a set a.alertFreeField5 = ?1 where a.alertId = ?2")
    int updateAlertFreeField5ByAlertId(String customerName, String alertId);


    @Nullable
    @Query("select a from AlertsTb a where upper(a.status) = upper(?1) order by a.alertTimestamp DESC, a.alertRetries")
    List<AlertsTb> findAllPendingAlertsTb(String status);
    AlertsTb findOneById(String alertId);


}
