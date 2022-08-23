package xyz.subho.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import xyz.subho.inventory.utilities.Utility;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -264634372901881203L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @LastModifiedDate
    private Long updatedAt;

    @Basic
    @Column(length = 30)
    @LastModifiedBy
    private String updatedBy;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Long createdAt;

    @Basic
    @Column(length = 30)
    @CreatedBy
    private String createdBy;

    @Basic
    @Column(nullable = false)
    private Boolean deleted = Boolean.FALSE;

    @Basic
    @Column(nullable = false)
    private Integer version;

    @PreUpdate
    private void onUpdate() {
        this.version++;
    }

    @PrePersist
    private void onCreate() {
        this.deleted = false;
        this.version = 1;
    }

    public LocalDateTime getUpdatedAtEpoch() {
        return Utility.epochToLocalDateTime(updatedAt);
    }

    public void setUpdatedAtEpoch(LocalDateTime updatedAt) {
        this.updatedAt = Utility.localDateTimeToEpoch(updatedAt);
    }

    public LocalDateTime getCreatedAtEpoch() {
        return Utility.epochToLocalDateTime(createdAt);
    }

    public void setCreatedAtEpoch(LocalDateTime createdAt) {
        this.createdAt = Utility.localDateTimeToEpoch(createdAt);
    }
}
