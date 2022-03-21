package custombank.project.accountsservice.repository;

import custombank.project.accountsservice.entity.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypesRepository extends JpaRepository<AccountTypes, Integer> {
    boolean findByAccountType(Integer accountType);
}
