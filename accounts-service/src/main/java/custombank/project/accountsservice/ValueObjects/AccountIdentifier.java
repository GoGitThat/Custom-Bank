package custombank.project.accountsservice.ValueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountIdentifier implements Serializable {
    private Integer accountType;
    private Long userId;
}
