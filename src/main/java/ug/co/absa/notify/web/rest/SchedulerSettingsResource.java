package ug.co.absa.notify.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;
import ug.co.absa.notify.domain.SchedulerSettings;
import ug.co.absa.notify.repository.SchedulerSettingsRepository;
import ug.co.absa.notify.service.SchedulerSettingsService;
import ug.co.absa.notify.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link ug.co.absa.notify.domain.SchedulerSettings}.
 */
@RestController
@RequestMapping("/api")
public class SchedulerSettingsResource {

    private final Logger log = LoggerFactory.getLogger(SchedulerSettingsResource.class);

    private static final String ENTITY_NAME = "schedulerSettings";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SchedulerSettingsService schedulerSettingsService;

    private final SchedulerSettingsRepository schedulerSettingsRepository;

    public SchedulerSettingsResource(
        SchedulerSettingsService schedulerSettingsService,
        SchedulerSettingsRepository schedulerSettingsRepository
    ) {
        this.schedulerSettingsService = schedulerSettingsService;
        this.schedulerSettingsRepository = schedulerSettingsRepository;
    }

    /**
     * {@code POST  /scheduler-settings} : Create a new schedulerSettings.
     *
     * @param schedulerSettings the schedulerSettings to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new schedulerSettings, or with status {@code 400 (Bad Request)} if the schedulerSettings has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/scheduler-settings")
    public ResponseEntity<SchedulerSettings> createSchedulerSettings(@Valid @RequestBody SchedulerSettings schedulerSettings)
        throws URISyntaxException {
        log.debug("REST request to save SchedulerSettings : {}", schedulerSettings);
        if (schedulerSettings.getId() != null) {
            throw new BadRequestAlertException("A new schedulerSettings cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SchedulerSettings result = schedulerSettingsService.save(schedulerSettings);
        return ResponseEntity
            .created(new URI("/api/scheduler-settings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /scheduler-settings/:id} : Updates an existing schedulerSettings.
     *
     * @param id the id of the schedulerSettings to save.
     * @param schedulerSettings the schedulerSettings to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated schedulerSettings,
     * or with status {@code 400 (Bad Request)} if the schedulerSettings is not valid,
     * or with status {@code 500 (Internal Server Error)} if the schedulerSettings couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/scheduler-settings/{id}")
    public ResponseEntity<SchedulerSettings> updateSchedulerSettings(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody SchedulerSettings schedulerSettings
    ) throws URISyntaxException {
        log.debug("REST request to update SchedulerSettings : {}, {}", id, schedulerSettings);
        if (schedulerSettings.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, schedulerSettings.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!schedulerSettingsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        SchedulerSettings result = schedulerSettingsService.update(schedulerSettings);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, schedulerSettings.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /scheduler-settings/:id} : Partial updates given fields of an existing schedulerSettings, field will ignore if it is null
     *
     * @param id the id of the schedulerSettings to save.
     * @param schedulerSettings the schedulerSettings to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated schedulerSettings,
     * or with status {@code 400 (Bad Request)} if the schedulerSettings is not valid,
     * or with status {@code 404 (Not Found)} if the schedulerSettings is not found,
     * or with status {@code 500 (Internal Server Error)} if the schedulerSettings couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/scheduler-settings/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<SchedulerSettings> partialUpdateSchedulerSettings(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody SchedulerSettings schedulerSettings
    ) throws URISyntaxException {
        log.debug("REST request to partial update SchedulerSettings partially : {}, {}", id, schedulerSettings);
        if (schedulerSettings.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, schedulerSettings.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!schedulerSettingsRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<SchedulerSettings> result = schedulerSettingsService.partialUpdate(schedulerSettings);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, schedulerSettings.getId().toString())
        );
    }

    /**
     * {@code GET  /scheduler-settings} : get all the schedulerSettings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of schedulerSettings in body.
     */
    @GetMapping("/scheduler-settings")
    public List<SchedulerSettings> getAllSchedulerSettings() {
        log.debug("REST request to get all SchedulerSettings");
        return schedulerSettingsService.findAll();
    }

    /**
     * {@code GET  /scheduler-settings/:id} : get the "id" schedulerSettings.
     *
     * @param id the id of the schedulerSettings to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the schedulerSettings, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/scheduler-settings/{id}")
    public ResponseEntity<SchedulerSettings> getSchedulerSettings(@PathVariable Long id) {
        log.debug("REST request to get SchedulerSettings : {}", id);
        Optional<SchedulerSettings> schedulerSettings = schedulerSettingsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(schedulerSettings);
    }

    /**
     * {@code DELETE  /scheduler-settings/:id} : delete the "id" schedulerSettings.
     *
     * @param id the id of the schedulerSettings to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/scheduler-settings/{id}")
    public ResponseEntity<Void> deleteSchedulerSettings(@PathVariable Long id) {
        log.debug("REST request to delete SchedulerSettings : {}", id);
        schedulerSettingsService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}