package web.api.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.api.sample.entity.Person;
/**
 * indicates that a decorated class (person) is a repository; encapsulate storage, retrieval and search behavior emulating collection of object.
 * (https://zetcode.com/springboot/repository/)
 * @author Stephanie San Pedro and Michael Alexander Mendoza
 *
 */
public interface PersonRepo extends JpaRepository<Person, Integer> {

}