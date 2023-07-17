package ug.co.absa.notify.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ug.co.absa.notify.domain.SchedulerSettings;
import ug.co.absa.notify.repository.SchedulerSettingsRepository;

/**
 * Service Implementation for managing {@link SchedulerSettings}.
 */
@Service
@Transactional
public class SchedulerSettingsService {

    private final Logger log = LoggerFactory.getLogger(SchedulerSettingsService.class);

    private final SchedulerSettingsRepository schedulerSettingsRepository;

    public SchedulerSettingsService(SchedulerSettingsRepository schedulerSettingsRepository) {
        this.schedulerSettingsRepository = schedulerSettingsRepository;
    }

    /**
     * Save a schedulerSettings.
     *
     * @param schedulerSettings the entity to save.
     * @return the persisted entity.
     */
    public SchedulerSettings save(SchedulerSettings schedulerSettings) {
        log.debug("Request to save SchedulerSettings : {}", schedulerSettings);
        return schedulerSettingsRepository.save(schedulerSettings);
    }

    /**
     * Update a schedulerSettings.
     *
     * @param schedulerSettings the entity to save.
     * @return the persisted entity.
     */
    public SchedulerSettings update(SchedulerSettings schedulerSettings) {
        log.debug("Request to update SchedulerSettings : {}", schedulerSettings);
        return schedulerSettingsRepository.save(schedulerSettings);
    }

    /**
     * Partially update a schedulerSettings.
     *
     * @param schedulerSettings the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<SchedulerSettings> partialUpdate(SchedulerSettings schedulerSettings) {
        log.debug("Request to partially update SchedulerSettings : {}", schedulerSettings);

        return schedulerSettingsRepository
            .findById(schedulerSettings.getId())
            .map(existingSchedulerSettings -> {
                if (schedulerSettings.getSettingName() != null) {
                    existingSchedulerSettings.setSettingName(schedulerSettings.getSettingName());
                }
                if (schedulerSettings.getSettingsId() != null) {
                    existingSchedulerSettings.setSettingsId(schedulerSettings.getSettingsId());
                }
                if (schedulerSettings.getSettingsDetails() != null) {
                    existingSchedulerSettings.setSettingsDetails(schedulerSettings.getSettingsDetails());
                }
                if (schedulerSettings.getSettingsField1() != null) {
                    existingSchedulerSettings.setSettingsField1(schedulerSettings.getSettingsField1());
                }

                return existingSchedulerSettings;
            })
            .map(schedulerSettingsRepository::save);
    }

    /**
     * Get all the schedulerSettings.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<SchedulerSettings> findAll() {
        log.debug("Request to get all SchedulerSettings");
        return schedulerSettingsRepository.findAll();
    }

    /**
     * Get one schedulerSettings by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<SchedulerSettings> findOne(Long id) {
        log.debug("Request to get SchedulerSettings : {}", id);
        return schedulerSettingsRepository.findById(id);
    }

    /**
     * Delete the schedulerSettings by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete SchedulerSettings : {}", id);
        schedulerSettingsRepository.deleteById(id);
    }
}
