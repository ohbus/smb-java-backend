package xyz.subho.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@FilterDef(
        name = "deletedUserFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedUserFilter", condition = "deleted = :isDeleted")
@Table(
        name = "users",
        indexes = {
                @Index(name = "mobileIdx", columnList = "mobile", unique = true),
                @Index(name ="emailIdx", columnList = "email", unique = true)})
public class Users extends BaseEntity implements Serializable {

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String mobile;

    @Column(length = 20)
    private String alternateNo;

}
