package xyz.subho.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime updatedAt;

    @Basic
    @Column(length = 30)
    private String updatedBy;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Basic
    @Column(length = 30)
    private String createdBy;

    @Basic
    @Column(nullable = false)
    private Boolean deleted;

    @Basic
    @Column(nullable = false)
    private Integer version;

    @PreUpdate
    private void onUpdate() {
        this.updatedAt = LocalDateTime.now();
//        this.updatedBy = this.getCurrentUser();
        this.version++;
    }

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
//        this.createdBy = this.getCurrentUser();
        this.deleted = false;
        this.version = 1;
    }

//    private String getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return (!(authentication instanceof AnonymousAuthenticationToken))
//                ? authentication.getName()
//                : null;
//    }


    public Long getUpdatedAtEpoch() {
        return Utility.localDateTimeToEpoch(updatedAt);
    }

    public void setUpdatedAtEpoch(Long updatedAt) {
        this.updatedAt = Utility.epochToLocalDateTime(updatedAt);
    }

    public Long getCreatedAtEpoch() {
        return Utility.localDateTimeToEpoch(createdAt);
    }

    public void setCreatedAtEpoch(Long createdAt) {
        this.createdAt = Utility.epochToLocalDateTime(createdAt);
    }
}
