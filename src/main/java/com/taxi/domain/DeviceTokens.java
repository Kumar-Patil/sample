package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author
 */
@Entity
@Table(name = "device_tokens")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DeviceTokens implements Serializable {

    private Long deviceTokenId;
    private String platform;
    private String token;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private User user;

    public DeviceTokens() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getDeviceTokenId() {
        return deviceTokenId;
    }

    public void setDeviceTokenId(Long deviceTokenId) {
        this.deviceTokenId = deviceTokenId;
    }

    @Column(name = "platform", nullable = false)
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Column(name = "token", nullable = false)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = createdAt;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.deviceTokenId);
        hash = 71 * hash + Objects.hashCode(this.platform);
        hash = 71 * hash + Objects.hashCode(this.token);
        hash = 71 * hash + Objects.hashCode(this.createdAt);
        hash = 71 * hash + Objects.hashCode(this.updatedAt);
        hash = 71 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeviceTokens other = (DeviceTokens) obj;
        return true;
    }

    @Override
    public String toString() {
        return "DeviceTokens{" + "deviceTokenId=" + deviceTokenId + ", platform=" + platform + ", token=" + token + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", user=" + user + '}';
    }
    
}
