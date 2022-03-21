package custombank.project.user.ValueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int accountType;
    private int userId;
    private BigDecimal balance;
    private boolean frozen;
}
