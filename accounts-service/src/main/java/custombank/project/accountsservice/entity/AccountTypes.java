package custombank.project.accountsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = AccountTypes.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTypes {
    public static final String TABLE_NAME= "ACCOUNT_TYPES";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_TYPE")
    private Integer accountType;
    @Column(name = "ACCOUNT_DESCRIPTION")
    private String accountDescription;
    @Column(name = "ACCOUNT_COST")
    private BigDecimal accountCost;
    @Column(name = "ACCOUNT_MIN_BALANCE")
    private BigDecimal accountMinBalance;
}
