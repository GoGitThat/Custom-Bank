package custombank.project.accountsservice.ValueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccounts {
    List<HashMap<String, PlainAccountObject>> listOfAccounts;
}
