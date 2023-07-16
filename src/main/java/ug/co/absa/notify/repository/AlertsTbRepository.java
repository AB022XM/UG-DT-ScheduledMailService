package ug.co.absa.notify.repository;

import java.util.List;
import java.util.Optional;
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
    @Query("update AlertsTb a set a.alertFreeField1 = ?1 where a.alertFreeField8 = ?2")
    int updateAlertFreeField1(@Nullable String alertFreeField1, String alertFreeField11);
    @Nullable
    @Query("select a from AlertsTb a where upper(a.status) = upper(?1) order by a.alertTimestamp DESC, a.alertRetries")
    Optional<List<AlertsTb>> findAllPendingAlertsTb(String status);
    AlertsTb findOneById(UUID uuid);
}
