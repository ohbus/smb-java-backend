package xyz.subho.inventory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class ErrorResponseModel implements Serializable {

    private static final long serialVersionUID = 771838073493840450L;

    private String message;
    private long timestamp;

    public ErrorResponseModel(final String message) {
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }
}
