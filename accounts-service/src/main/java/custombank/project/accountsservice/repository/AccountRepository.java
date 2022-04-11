package custombank.project.accountsservice.repository;

import custombank.project.accountsservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByUserId(Long userId);

    boolean existsByAccountTypeAndUserId(Integer accountType, Long userId);

    boolean existsByAccountTypeAndUserIdAndBalanceGreaterThan(Integer accountType, Long userId, BigDecimal balance);

    Account findByAccountTypeAndUserId(Integer accountType, Long userId);
}
