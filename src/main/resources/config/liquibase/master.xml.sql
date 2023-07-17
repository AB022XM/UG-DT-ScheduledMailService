-- liquibase formatted sql

-- changeset AB022XM:1689557630123-26
CREATE TABLE alerts_history_tb (id BIGINT AUTO_INCREMENT NOT NULL, history_alert_id VARCHAR(255) NULL, history_alert_tem_id VARCHAR(255) NULL, history_alert_type VARCHAR(255) NULL, history_alert_status VARCHAR(255) NULL, history_alert_message VARCHAR(255) NULL, history_alert_date datetime NULL, history_alert_retries INT NULL, history_alert_timestamp datetime NULL, history_alert_posted_by VARCHAR(255) NULL, history_alert_posted_date VARCHAR(255) NULL, history_alert_internal_errorcode VARCHAR(255) NULL, history_alert_raw_request LONGTEXT NULL, history_alert_raw_response LONGTEXT NULL, history_alert_free_field_1 LONGTEXT NULL, history_alert_free_field_2 LONGTEXT NULL, history_alert_free_field_3 VARCHAR(255) NULL, history_alert_free_field_4 VARCHAR(255) NULL, history_alert_free_field_5 VARCHAR(255) NULL, history_alert_free_field_6 VARCHAR(255) NULL, history_alert_free_field_7 VARCHAR(255) NULL, history_alert_free_field_8 VARCHAR(255) NULL, created_at datetime NULL, updated_at datetime NULL, history_status VARCHAR(255) NULL, CONSTRAINT pk_alerts_history_tb PRIMARY KEY (id));

-- changeset AB022XM:1689557630123-27
CREATE TABLE alerts_tb (id char(36) NOT NULL, alert_id VARCHAR(50) NULL, alert_tem_id VARCHAR(255) NULL, alert_type VARCHAR(255) NULL, alert_status VARCHAR(255) NULL, alert_message VARCHAR(255) NULL, alert_date datetime NULL, alert_retries INT NULL, alert_timestamp datetime NULL, alert_posted_by VARCHAR(255) NULL, alert_posted_date VARCHAR(255) NULL, alert_internal_errorcode VARCHAR(255) NULL, raw_request LONGTEXT NULL, raw_response LONGTEXT NULL, alert_free_field_1 LONGTEXT NULL, alert_free_field_2 LONGTEXT NULL, alert_free_field_3 VARCHAR(255) NULL, alert_free_field_4 VARCHAR(255) NULL, alert_free_field_5 VARCHAR(255) NULL, alert_free_field_6 VARCHAR(255) NULL, alert_free_field_7 VARCHAR(255) NULL, alert_free_field_8 VARCHAR(255) NULL, created_at datetime NULL, updated_at datetime NULL, status VARCHAR(255) NULL, alerts_template_tb_id char(36) NULL, CONSTRAINT pk_alerts_tb PRIMARY KEY (id));

-- changeset AB022XM:1689557630123-28
CREATE TABLE alerts_template_tb (id char(36) NOT NULL, alert_template_id VARCHAR(255) NULL, alertroduct_id VARCHAR(255) NULL, alert_templatename VARCHAR(255) NULL, alert_template_details LONGTEXT NULL, alert_template_status VARCHAR(255) NULL, alert_templateretries INT NULL, alert_template_timestamp datetime NULL, alert_templatepostedby VARCHAR(255) NULL, alert_templateposted_date VARCHAR(255) NULL, alert_tmp_free_field_1 LONGTEXT NULL, alert_tmp_free_field_2 BLOB NULL, alert_tmp_free_field_2_content_type VARCHAR(255) NULL, alert_tmp_free_field_3 VARCHAR(255) NULL, alert_tmp_free_field_4 VARCHAR(255) NULL, alert_tmp_free_field_5 VARCHAR(255) NULL, alert_tmp_free_field_6 VARCHAR(255) NULL, alert_tmp_free_field_7 VARCHAR(255) NULL, alert_tmp_free_field_8 VARCHAR(255) NULL, timestamp datetime NULL, is_active BIT(1) NULL, CONSTRAINT pk_alerts_template_tb PRIMARY KEY (id));

-- changeset AB022XM:1689557630123-29
CREATE TABLE alerts_template_tb_alerts_tbs (alerts_template_tb_id char(36) NOT NULL, alerts_tbs_id char(36) NOT NULL, CONSTRAINT pk_alerts_template_tb_alertstbs PRIMARY KEY (alerts_template_tb_id, alerts_tbs_id));

-- changeset AB022XM:1689557630123-30
ALTER TABLE channel_txns ADD record_id VARCHAR(255) NULL, ADD transaction_id VARCHAR(255) NULL, ADD txn_status VARCHAR(255) NULL;

-- changeset AB022XM:1689557630123-33
ALTER TABLE alerts_tb ADD CONSTRAINT uc_alerts_tb_alert UNIQUE (alert_id);

-- changeset AB022XM:1689557630123-34
ALTER TABLE alerts_template_tb_alerts_tbs ADD CONSTRAINT uc_alerts_template_tb_alerts_tbs_alertstbs UNIQUE (alerts_tbs_id);

-- changeset AB022XM:1689557630123-35
ALTER TABLE alerts_tb ADD CONSTRAINT FK_ALERTS_TB_ON_ALERTSTEMPLATETB FOREIGN KEY (alerts_template_tb_id) REFERENCES alerts_template_tb (id);

-- changeset AB022XM:1689557630123-36
ALTER TABLE alerts_template_tb_alerts_tbs ADD CONSTRAINT fk_aletemtbaletbs_on_alerts_tb FOREIGN KEY (alerts_tbs_id) REFERENCES alerts_tb (id);

-- changeset AB022XM:1689557630123-37
ALTER TABLE alerts_template_tb_alerts_tbs ADD CONSTRAINT fk_aletemtbaletbs_on_alerts_template_tb FOREIGN KEY (alerts_template_tb_id) REFERENCES alerts_template_tb (id);

-- changeset AB022XM:1689557630123-47
DROP TABLE account_master;

-- changeset AB022XM:1689557630123-48
DROP TABLE air;

-- changeset AB022XM:1689557630123-49
DROP TABLE birthday;

-- changeset AB022XM:1689557630123-50
DROP TABLE branches;

-- changeset AB022XM:1689557630123-51
DROP TABLE cards;

-- changeset AB022XM:1689557630123-52
DROP TABLE channelcredentials;

-- changeset AB022XM:1689557630123-53
DROP TABLE channels;

-- changeset AB022XM:1689557630123-54
DROP TABLE complaints;

-- changeset AB022XM:1689557630123-55
DROP TABLE customer_master;

-- changeset AB022XM:1689557630123-56
DROP TABLE ext_funds_transfer;

-- changeset AB022XM:1689557630123-57
DROP TABLE feedback_qrcode;

-- changeset AB022XM:1689557630123-58
DROP TABLE invalid_number;

-- changeset AB022XM:1689557630123-59
DROP TABLE notification_contacts;

-- changeset AB022XM:1689557630123-60
DROP TABLE percentages;

-- changeset AB022XM:1689557630123-61
DROP TABLE productcodes;

-- changeset AB022XM:1689557630123-62
DROP TABLE rm_codes;

-- changeset AB022XM:1689557630123-63
DROP TABLE shm;

-- changeset AB022XM:1689557630123-64
DROP TABLE thirdparty_users;

-- changeset AB022XM:1689557630123-65
ALTER TABLE channel_txns DROP COLUMN RecordId;
ALTER TABLE channel_txns DROP COLUMN TransactionID;
ALTER TABLE channel_txns DROP COLUMN txn_status_mno;
ALTER TABLE channel_txns DROP COLUMN date_inserted;
ALTER TABLE channel_txns DROP COLUMN id;
ALTER TABLE channel_txns DROP COLUMN paymentcompleteddate;
ALTER TABLE channel_txns DROP COLUMN settlement_date;
ALTER TABLE channel_txns DROP COLUMN txn_date;

-- changeset AB022XM:1689557630123-1
ALTER TABLE channel_txns MODIFY account_no VARCHAR(255);

-- changeset AB022XM:1689557630123-2
ALTER TABLE channel_txns MODIFY amount VARCHAR(255);

-- changeset AB022XM:1689557630123-4
ALTER TABLE channel_txns ADD date_inserted VARCHAR(255) NULL;

-- changeset AB022XM:1689557630123-5
ALTER TABLE jhi_user MODIFY email VARCHAR(254);

-- changeset AB022XM:1689557630123-6
ALTER TABLE channel_txns MODIFY final_status VARCHAR(255);

-- changeset AB022XM:1689557630123-8
ALTER TABLE channel_txns ADD id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY;

-- changeset AB022XM:1689557630123-9
ALTER TABLE channel_txns MODIFY message VARCHAR(255);

-- changeset AB022XM:1689557630123-10
ALTER TABLE channel_txns MODIFY mno VARCHAR(255);

-- changeset AB022XM:1689557630123-11
ALTER TABLE channel_txns MODIFY mno_txn_id VARCHAR(255);

-- changeset AB022XM:1689557630123-12
ALTER TABLE channel_txns MODIFY narrative VARCHAR(255);

-- changeset AB022XM:1689557630123-13
ALTER TABLE channel_txns MODIFY notified_status VARCHAR(255);

-- changeset AB022XM:1689557630123-15
ALTER TABLE channel_txns ADD paymentcompleteddate VARCHAR(255) NULL;

-- changeset AB022XM:1689557630123-16
ALTER TABLE channel_txns MODIFY requestxml VARCHAR(255);

-- changeset AB022XM:1689557630123-17
ALTER TABLE channel_txns MODIFY responsexml VARCHAR(255);

-- changeset AB022XM:1689557630123-19
ALTER TABLE channel_txns ADD settlement_date VARCHAR(255) NULL;

-- changeset AB022XM:1689557630123-20
ALTER TABLE channel_txns MODIFY source_account VARCHAR(255);

-- changeset AB022XM:1689557630123-22
ALTER TABLE channel_txns ADD txn_date VARCHAR(255) NULL;

-- changeset AB022XM:1689557630123-23
ALTER TABLE channel_txns MODIFY txn_type VARCHAR(255);

-- changeset AB022XM:1689557630123-24
ALTER TABLE channel_txns MODIFY txnid VARCHAR(255);

-- changeset AB022XM:1689557630123-25
ALTER TABLE channel_txns MODIFY utilityref VARCHAR(255);

