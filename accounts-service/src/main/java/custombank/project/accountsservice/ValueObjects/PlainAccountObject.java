package custombank.project.accountsservice.ValueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlainAccountObject {
    private Integer accountType;
    private Long userId;
    private BigDecimal balance;
    private boolean frozen;
}
