package custombank.project.accountsservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = Account.TABLE_NAME, indexes = {@Index(name = "accountType_index",  columnList="accountType")},
        uniqueConstraints = {@UniqueConstraint(columnNames = {"accountType", "userId"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    public static final String TABLE_NAME= "USER_FIN_ACCOUNTS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountType", insertable = false, updatable = false)
    private AccountTypes accountTypes;

    @JsonDeserialize(as = Integer.class)
    private Integer accountType;

    @JsonDeserialize(as = Long.class)
    private Long userId;

    @JsonDeserialize(as = BigDecimal.class)
    private BigDecimal balance;

    @Column(columnDefinition = "boolean default false")
    private boolean frozen;
}
