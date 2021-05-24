package web.api.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import web.api.sample.entity.Person;
import web.api.sample.service.PersonRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/record")
@Api(value = "Person Rest Controller")
public class PersonRestAPI {
	@Autowired	
	PersonRecord service;
	

	///http://localhost:8080/record/person/id
	/**
	 * @GetMapping, handle HTTP Get request matched with given URI
	 * Get or return the requested record.
	 */
	@GetMapping("/person/{id}")
	@ApiOperation(value = "Get Person Information", response = Person.class, notes = "Returns a single record of Person table.")
	public ResponseEntity<Person> getPersonInfo(@ApiParam(value = "This is the primary id of the record.") @PathVariable("id") int id) throws Exception {
		Person person = service.getpersonInfo(id);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(person);
	}
	
		
	    // insert record into the table
		/**
		 * These lines of codes are for adding new (person) data into the table.
		 *@param person
		 *@return
		 *@throws Exception                                                              
		 */

		@PostMapping("/person")	
		@ApiOperation(value = "Insert Person Information", response = Person.class, notes = "Insert a single record of Person table.")
		public Person savePersonInfo(@RequestBody Person person) throws Exception {
			return service.savePersonInfo(person);
				
		} 
		
		//http://localhost:8080/record/person/
		/**
		 * These lines of codes are for updating an existing (person) record in the table.
		 * @param person
		 * @return
		 * @throws Exception
		 */
	@PutMapping("/person")	
	@ApiOperation(value = "Update Person Information", response = Person.class, notes = "Update a single record of Person table.")
	public Person updatePersonInfo(@RequestBody Person person) throws Exception {
		return service.updatePersonInfo(person);
	} 
	
	//http://localhost:8080/record/person?id={person.id}
	 
	@DeleteMapping("/person")	
	@ApiOperation(value = "Delete Person Information", response = Person.class, notes = "Delete a single record of Person table.")
	public String deletePersonInfo(@RequestParam int id){
		return service.deletePersonInfo(id);
	} 
	
}

