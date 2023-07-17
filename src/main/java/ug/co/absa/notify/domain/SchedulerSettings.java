package ug.co.absa.notify.domain;

import jakarta.persistence.*;

import java.io.Serializable;


/**
 * A SchedulerSettings.
 */
@Entity
@Table(name = "scheduler_settings")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SchedulerSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "setting_name")
    private String settingName;

    @Column(name = "settings_id", nullable = false)
    private Integer settingsId;

    @Lob
    @Column(name = "settings_details")
    private String settingsDetails;

    @Column(name = "settings_field_1")
    private String settingsField1;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public SchedulerSettings id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSettingName() {
        return this.settingName;
    }

    public SchedulerSettings settingName(String settingName) {
        this.setSettingName(settingName);
        return this;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public Integer getSettingsId() {
        return this.settingsId;
    }

    public SchedulerSettings settingsId(Integer settingsId) {
        this.setSettingsId(settingsId);
        return this;
    }

    public void setSettingsId(Integer settingsId) {
        this.settingsId = settingsId;
    }

    public String getSettingsDetails() {
        return this.settingsDetails;
    }

    public SchedulerSettings settingsDetails(String settingsDetails) {
        this.setSettingsDetails(settingsDetails);
        return this;
    }

    public void setSettingsDetails(String settingsDetails) {
        this.settingsDetails = settingsDetails;
    }

    public String getSettingsField1() {
        return this.settingsField1;
    }

    public SchedulerSettings settingsField1(String settingsField1) {
        this.setSettingsField1(settingsField1);
        return this;
    }

    public void setSettingsField1(String settingsField1) {
        this.settingsField1 = settingsField1;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SchedulerSettings)) {
            return false;
        }
        return id != null && id.equals(((SchedulerSettings) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SchedulerSettings{" +
            "id=" + getId() +
            ", settingName='" + getSettingName() + "'" +
            ", settingsId=" + getSettingsId() +
            ", settingsDetails='" + getSettingsDetails() + "'" +
            ", settingsField1='" + getSettingsField1() + "'" +
            "}";
    }
}
