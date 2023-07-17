package ug.co.absa.notify.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;
import ug.co.absa.notify.domain.ChannelTxn;
import ug.co.absa.notify.repository.ChannelTxnRepository;
import ug.co.absa.notify.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link ug.co.absa.notify.domain.ChannelTxn}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ChannelTxnResource {

    private final Logger log = LoggerFactory.getLogger(ChannelTxnResource.class);

    private static final String ENTITY_NAME = "channelTxn";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ChannelTxnRepository channelTxnRepository;

    public ChannelTxnResource(ChannelTxnRepository channelTxnRepository) {
        this.channelTxnRepository = channelTxnRepository;
    }

    /**
     * {@code POST  /channel-txns} : Create a new channelTxn.
     *
     * @param channelTxn the channelTxn to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new channelTxn, or with status {@code 400 (Bad Request)} if the channelTxn has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/channel-txns")
    public ResponseEntity<ChannelTxn> createChannelTxn(@Valid @RequestBody ChannelTxn channelTxn) throws URISyntaxException {
        log.debug("REST request to save ChannelTxn : {}", channelTxn);
        if (channelTxn.getId() != null) {
            throw new BadRequestAlertException("A new channelTxn cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ChannelTxn result = channelTxnRepository.save(channelTxn);
        return ResponseEntity
            .created(new URI("/api/channel-txns/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /channel-txns/:id} : Updates an existing channelTxn.
     *
     * @param id the id of the channelTxn to save.
     * @param channelTxn the channelTxn to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated channelTxn,
     * or with status {@code 400 (Bad Request)} if the channelTxn is not valid,
     * or with status {@code 500 (Internal Server Error)} if the channelTxn couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/channel-txns/{id}")
    public ResponseEntity<ChannelTxn> updateChannelTxn(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ChannelTxn channelTxn
    ) throws URISyntaxException {
        log.debug("REST request to update ChannelTxn : {}, {}", id, channelTxn);
        if (channelTxn.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, channelTxn.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!channelTxnRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ChannelTxn result = channelTxnRepository.save(channelTxn);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, channelTxn.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /channel-txns/:id} : Partial updates given fields of an existing channelTxn, field will ignore if it is null
     *
     * @param id the id of the channelTxn to save.
     * @param channelTxn the channelTxn to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated channelTxn,
     * or with status {@code 400 (Bad Request)} if the channelTxn is not valid,
     * or with status {@code 404 (Not Found)} if the channelTxn is not found,
     * or with status {@code 500 (Internal Server Error)} if the channelTxn couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */


    /**
     * {@code GET  /channel-txns} : get all the channelTxns.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of channelTxns in body.
     */
    @GetMapping("/channel-txns")
    public List<ChannelTxn> getAllChannelTxns() {
        log.debug("REST request to get all ChannelTxns");
        return channelTxnRepository.findAll();
    }

    /**
     * {@code GET  /channel-txns/:id} : get the "id" channelTxn.
     *
     * @param id the id of the channelTxn to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the channelTxn, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/channel-txns/{id}")
    public ResponseEntity<ChannelTxn> getChannelTxn(@PathVariable Long id) {
        log.debug("REST request to get ChannelTxn : {}", id);
        Optional<ChannelTxn> channelTxn = channelTxnRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(channelTxn);
    }

    /**
     * {@code DELETE  /channel-txns/:id} : delete the "id" channelTxn.
     *
     * @param id the id of the channelTxn to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/channel-txns/{id}")
    public ResponseEntity<Void> deleteChannelTxn(@PathVariable Long id) {
        log.debug("REST request to delete ChannelTxn : {}", id);
        channelTxnRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
