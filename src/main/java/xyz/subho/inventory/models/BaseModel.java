package xyz.subho.inventory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import xyz.subho.inventory.utilities.Utility;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class BaseModel implements Serializable {

    @Max(value = Long.MAX_VALUE, message = "Maximum allowed size is " + Long.MAX_VALUE)
    private Long id;

    @Max(value = Long.MAX_VALUE, message = "Maximum allowed size is " + Long.MAX_VALUE)
    private Long updatedAt;

    @Size(max = 30, message = "Maximum allowed characters is 30")
    private String updatedBy;

    @Max(value = Long.MAX_VALUE, message = "Maximum allowed size is " + Long.MAX_VALUE)
    private Long createdAt;

    @Size(max = 30, message = "Maximum allowed characters is 30")
    private String createdBy;

    @Min(value = 1, message = "Minimum allowed version is 1")
    @Max(value = Integer.MAX_VALUE, message = "Maximum allowed version is " + Integer.MAX_VALUE)
    private Integer version;

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
