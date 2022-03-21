package custombank.project.accountsservice.ValueObjects;

import custombank.project.accountsservice.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccounts {
    List<Account> listOfAccounts;
}
