package vn.fpt.edu.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.fpt.edu.cinema.entity.Account;

import java.util.Optional;

/**
 * vn.fpt.edu.cinema.repository
 *
 * @author : Portgas.D.Ace
 * @created : 21/05/2023
 * @contact : 0339850697- congdung2510@gmail.com
 **/
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findAccountByAccountId(String accountId);

    Optional<Account> findAccountByUsername(String username);

    @Query("select ac from Account ac where ac.username like ?1  or ac.email like ?1 ")
    Optional<Account> findAccountByEmailOrUsername(String emailOrUsername);

    Optional<Account> findAccountByEmail(String email);
}
