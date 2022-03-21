package custombank.project.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name=User.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public static final String TABLE_NAME= "USERS";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailId;
    private Long ssnNumber;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dob;
}
