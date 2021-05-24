package web.api.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import web.api.sample.entity.Bank;
import web.api.sample.service.BankRecord;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bankrecord")
@Api(value = "Bank Rest Controller")
public class BankRestAPI {

	@Autowired
	BankRecord bankRecord;

	/// http://localhost:8080/bankrecord/bank/id
	/**
	 * @GetMapping, handle HTTP Get request matched with given URI
	 * Get or return the requested record.
	 */
	@GetMapping("/bank/{id}")
	@ApiOperation(value = "Get Bank Information", response = Bank.class, notes = "Returns a single record of Bank table.")
	public Bank getBankInfo(@PathVariable("id") int id) throws Exception {
		Bank bank = bankRecord.getBankInfo(id);
		return bank;
	}

	// insert record into the table
	/**
	 * These lines of codes are for adding new (bank) data into the table.
	 * @param Bank
	 * @return
	 * @throws Exception
	 */
	
	@PostMapping("/bank")
	@ApiOperation(value = "Insert Bank Information", response = Bank.class, notes = "Insert a single record of Bank table.")
	public Bank saveBankInfo(@RequestBody Bank bank) throws Exception {
		return bankRecord.saveBankInfo(bank);
	}
	
	//update record in to the table
	/**
	 * These lines of codes are for updating an existing (bank) record in the table.
	 * @param Bank
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/bank")
	@ApiOperation(value = "Update Bank Information", response = Bank.class, notes = "Update a single record of Bank table.")
	public Bank updateBankInfo(@RequestBody Bank bank) {
		return bankRecord.updateBankInfo(bank);
	}
 
	// http://localhost:8080/bankrecord/bank?id={bank.id}
	/**
	 * These lines of codes are for deleting an existing (bank) record in the table.
	 * @param Bank
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/bank")
	@ApiOperation(value = "Delete Bank Information", response = Bank.class, notes = "Delete a single record of Bank table.")
	public String deleteBankInfo(@RequestParam int id) {
		return bankRecord.deleteBankInfo(id);
	
}
}