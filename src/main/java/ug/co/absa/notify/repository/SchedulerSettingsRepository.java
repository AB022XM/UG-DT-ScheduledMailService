package ug.co.absa.notify.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import ug.co.absa.notify.domain.SchedulerSettings;

/**
 * Spring Data JPA repository for the SchedulerSettings entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SchedulerSettingsRepository extends JpaRepository<SchedulerSettings, Long> {}
