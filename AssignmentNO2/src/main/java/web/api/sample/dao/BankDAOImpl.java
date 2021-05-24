package web.api.sample.dao;


import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.api.sample.controller.MessageAlert;
import web.api.sample.entity.Bank;
import web.api.sample.exception.CustomException;
import web.api.sample.repo.BankRepo;

@Repository
@Transactional
/**
 * 
 * @author Stephanie San Pedro and Michael Alexander Mendoza
 * DAO provides some specific data operations without exposing details of the database.
 *(https://www.google.com/search?q=what+is+DAOImpl+used+for%3F&sxsrf=ALeKk00AkwddlvXlTz8zTeeVk-Q4YcCCyg%3A1619167956291&ei=1IqCYLCUEaj2hwOn_7jwCw&oq=what+is+DAOImpl+used+for%3F&gs_lcp=Cgdnd3Mtd2l6EAM6BwgjELACECc6CAgAEAcQChAeOggIABANEAoQHjoGCAAQDRAeOggIABANEAUQHjoECAAQDToGCAAQFhAeOgcIIRAKEKABOgoIIRAWEAoQHRAeUNNCWI6OAWDjjwFoAXAAeACAAbABiAHeD5IBBDE4LjOYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=gws-wiz&ved=0ahUKEwiwzvbW_pPwAhUo-2EKHac_Dr4Q4dUDCA4&uact=5)
 */
public class BankDAOImpl {

	//Perform SQL operation under this class
	
	@Autowired   //widely used for Dependency Injection
	BankRepo bankRepo;
	
	//Read
	public Bank getBankInfo(int id) throws Exception {
		Optional<Bank> bank = bankRepo.findById(id);
		
		if(bank.isEmpty()) {
			throw new NoSuchElementException("No record");
		}
		
		return bank.get();
	}
	
	//Create
		public Bank saveBankInfo(Bank bank)throws Exception {
		Optional<Bank> bankOPT = bankRepo.findById(bank.getId());
		if(bankOPT.isPresent()) {
			throw new CustomException(MessageAlert.RECORD_EXIST.getCode());
		}
		//persist means insert record into the table			
		return bankRepo.save(bank);
		
	}

	
	//Update
	public Bank updateBankInfo(Bank bank) {
		return bankRepo.saveAndFlush(bank);
	}
	
	//Delete
	public String deleteBankInfo(int id) {
		Bank bank = null;
		String message = "";
		
		try {
			bank = getBankInfo(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		if(bank != null) {
			bankRepo.delete(bank);
			message = "Deleted successfully.";
		}else {
			message = "Unsuccessful deletion.";
		}
		return message;
	}
}