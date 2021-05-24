package web.api.sample.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.api.sample.controller.MessageAlert;
import web.api.sample.entity.Bank;
import web.api.sample.entity.Person;
import web.api.sample.exception.CustomException;
import web.api.sample.repo.BankRepo;
import web.api.sample.repo.PersonRepo;

@Repository
@Transactional

/**
 * 
 * @author Stephanie San Pedro and Michael Alexander Mendoza
 * DAO provides some specific data operations without exposing details of the database.
 *(https://www.google.com/search?q=what+is+DAOImpl+used+for%3F&sxsrf=ALeKk00AkwddlvXlTz8zTeeVk-Q4YcCCyg%3A1619167956291&ei=1IqCYLCUEaj2hwOn_7jwCw&oq=what+is+DAOImpl+used+for%3F&gs_lcp=Cgdnd3Mtd2l6EAM6BwgjELACECc6CAgAEAcQChAeOggIABANEAoQHjoGCAAQDRAeOggIABANEAUQHjoECAAQDToGCAAQFhAeOgcIIRAKEKABOgoIIRAWEAoQHRAeUNNCWI6OAWDjjwFoAXAAeACAAbABiAHeD5IBBDE4LjOYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=gws-wiz&ved=0ahUKEwiwzvbW_pPwAhUo-2EKHac_Dr4Q4dUDCA4&uact=5)
 */

public class PersonDAOImpl {

	//Perform SQL operation under this class
	
	@Autowired   //widely used for Dependency Injection
	PersonRepo personRepo;
	
	@Autowired
	BankRepo bankRepo;
	
	//Read
	public Person getPersonInfo(int id) throws Exception {
Optional<Person> person = personRepo.findById(id);
	
		if(person.isEmpty()) {
			throw new CustomException(MessageAlert.RECORD_NOT_FOUND.getCode());
		}
		
		return person.get();
				
	
	}
	
	

//Create
	public Person savePersonInfo(Person person)throws Exception {
	Optional<Person> personOPT = personRepo.findById(person.getId());
	if(personOPT.isPresent()) {
		throw new CustomException(MessageAlert.RECORD_EXIST.getCode());
	}
	//persist means insert record into the table
	return personRepo.save(person);
	
}

//Update
	public Person updatePersonInfo(Person person) throws Exception {
		Optional<Person> personOPT = personRepo.findById(person.getId());
		if(personOPT.isEmpty()) {
			throw new CustomException(MessageAlert.UPDATE_ONLY.getCode());
		}
		
		return personRepo.saveAndFlush(person);
	  
	}
	//Delete
	public String deletePersonInfo(int id) {
		Person person = null;
		String message = "";
		
		try {
			person = getPersonInfo(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		if(person != null) {
			personRepo.delete(person);
			//flag bank record is INACTIVE
			Set<Bank> banks = person.getBank();
			
			if(!banks.isEmpty()) {
				for(Bank bank : banks) {
					bank.setStatus("INACTIVE");
				}
				bankRepo.saveAll(banks);
			}
			message = "Deleted successfully.";
		}else {
			message = "Unsuccessful deletion.";
		}
		return message;
	}	
}