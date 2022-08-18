package xyz.subho.inventory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class UserModel extends BaseModel implements Serializable {

    @NotBlank(message = "First Name cannot be Blank or Empty")
    @Size(max = 30, message = "Maximum allowed characters is 30")
    private String firstName;

    @NotBlank(message = "Last Name cannot be Blank or Empty")
    @Size(max = 30, message = "Maximum allowed characters is 30")
    private String lastName;

    @NotBlank(message = "Email cannot be Blank or Empty")
    @Email(
            message = "Please provide a Valid email address",
            regexp = "/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")
    @Size(max = 255, message = "Maximum allowed characters is 255")
    private String email;

    @NotBlank(message = "Mobile Number cannot be Blank or Empty")
    @Pattern(
            message = "Please Enter a Valid Mobile Number",
            regexp = "/^(\\+\\d{1,3}[- ]?)?\\d{10}$/")
    @Size(max = 30, message = "Maximum allowed characters is 20")
    private String mobile;

    @Pattern(
            message = "Please Enter a Valid Mobile Number",
            regexp = "/^(\\+\\d{1,3}[- ]?)?\\d{10}$/")
    @Size(max = 30, message = "Maximum allowed characters is 20")
    private String alternateNo;

}
