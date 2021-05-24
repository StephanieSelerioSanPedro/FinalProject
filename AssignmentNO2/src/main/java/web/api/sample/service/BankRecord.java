package web.api.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.api.sample.dao.BankDAOImpl;
import web.api.sample.entity.Bank;

@Service
public class BankRecord {
	@Autowired
	BankDAOImpl bankDAOImpl;

	public Bank getBankInfo(int Id) throws Exception {		
		return bankDAOImpl.getBankInfo(Id);
	}

	// Create
	/**
	 * These lines of codes are for creating (bank) record in the table.
	 * @param bankDAOImpl
	 * @return
	 * @throws Exception
	 */
	public Bank saveBankInfo(Bank bank) throws Exception {
		// persist means insert record into the table
		return bankDAOImpl.saveBankInfo(bank);
	}

	// Update
	/**
	 * These lines of codes are for updating existing (bank) record in the table.
	 * @param bankDAOImpl
	 * @return
	 * @throws Exception
	 */
	public Bank updateBankInfo(Bank bank) {
		return bankDAOImpl.updateBankInfo(bank);
	}

	// Delete
	/**
	 * These lines of codes are for deleting existing (bank) record in the table.
	 * @param bankDAOImpl
	 * @return
	 * @throws Exception
	 */
	public String deleteBankInfo(int Id) {
		return bankDAOImpl.deleteBankInfo(Id);
	}

	
	


	


	}
