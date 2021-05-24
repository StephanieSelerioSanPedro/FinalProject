package web.api.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.api.sample.dao.PersonDAOImpl;
import web.api.sample.entity.Person;

@Service
public class PersonRecord {
	@Autowired
	PersonDAOImpl personDAOImpl;

	public Person getPersonInfo(int id) throws Exception {		
		return personDAOImpl.getPersonInfo(id);
	}

	// Create
	/**
	 * These lines of codes are for creating (person) record in the table.
	 * @param personDAOImpl
	 * @return
	 * @throws Exception
	 */
		public Person savePersonInfo(Person person) throws Exception {
			// persist means insert record into the table		
			return personDAOImpl.savePersonInfo(person);
	
		}
	// Update
		/**
		 * These lines of codes are for updating existing (person) record in the table.
		 * @param personDAOImpl
		 * @return
		 * @throws Exception
		 */
	public Person updatePersonInfo(Person person) throws Exception {
		return personDAOImpl.updatePersonInfo(person);
	}

	// Delete
	/**
	 * These lines of codes are for deleting existing (person) record in the table.
	 * @param personDAOImpl
	 * @return
	 * @throws Exception
	 */
	public String deletePersonInfo(int id) {
		return personDAOImpl.deletePersonInfo(id);
	}

	public Person getpersonInfo(int id) throws Exception {
		// TODO Auto-generated method stub
		return personDAOImpl.getPersonInfo(id);
	}

}
