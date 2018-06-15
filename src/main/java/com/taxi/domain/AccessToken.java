package com.taxi.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author
 */
@Entity
@Table(name = "oauth_access_tokens")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccessToken implements Serializable {

    private static final long serialVersionUID = 1L;
    private int accessTokenId;
    private String accessToken;
    private String refreshToken;
    private Timestamp expiryAt;
    private long userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "access_id", unique = true, nullable = false)
    public int getAccessTokenId() {
        return accessTokenId;
    }

    public void setAccessTokenId(int accessTokenId) {
        this.accessTokenId = accessTokenId;
    }

    @Column(name = "access_token", nullable = false, length = 255)
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Column(name = "refresh_token", nullable = false, length = 255)
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Column(name = "exipary_at")
    public Timestamp getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(Timestamp expiryAt) {
        this.expiryAt = expiryAt;
    }

    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.accessTokenId;
        hash = 31 * hash + Objects.hashCode(this.accessToken);
        hash = 31 * hash + Objects.hashCode(this.refreshToken);
        hash = 31 * hash + Objects.hashCode(this.expiryAt);
        hash = 31 * hash + (int) (this.userId ^ (this.userId >>> 32));
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
        final AccessToken other = (AccessToken) obj;
        return true;
    }

    @Override
    public String toString() {
        return "AccessToken{" + "accessTokenId=" + accessTokenId + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + ", expiryAt=" + expiryAt + ", userId=" + userId + '}';
    }

}
