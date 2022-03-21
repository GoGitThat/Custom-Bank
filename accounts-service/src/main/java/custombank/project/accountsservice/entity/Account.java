package custombank.project.accountsservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import custombank.project.accountsservice.ValueObjects.AccountIdentifier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@IdClass(AccountIdentifier.class)
@Table(name = Account.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    public static final String TABLE_NAME= "USER_FIN_ACCOUNTS";
    @Column(name = "id",  insertable = false)
    @Generated(GenerationTime.INSERT)
    public Long id;
    @Id
    @JsonDeserialize(as = Integer.class)
    private Integer accountType;
    @Id
    @JsonDeserialize(as = Long.class)
    private Long userId;
    @JsonDeserialize(as = BigDecimal.class)
    private BigDecimal balance;
    @Column(columnDefinition = "boolean default false")
    private boolean frozen;
}
