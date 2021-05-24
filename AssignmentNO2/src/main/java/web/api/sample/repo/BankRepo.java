package web.api.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.api.sample.entity.Bank;

/**
 * indicates that a decorated class (bank) is a repository; encapsulate storage, retrieval and search behavior emulating collection of object.
 * (https://zetcode.com/springboot/repository/)
 * @author Stephanie San Pedro and Michael Alexander Mendoza
 *
 */
public interface BankRepo extends JpaRepository<Bank, Integer>{


}
