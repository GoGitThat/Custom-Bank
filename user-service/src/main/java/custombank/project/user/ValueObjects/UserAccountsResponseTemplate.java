package custombank.project.user.ValueObjects;

import custombank.project.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountsResponseTemplate {
    private User user;
    private UserAccounts accountList;
}
