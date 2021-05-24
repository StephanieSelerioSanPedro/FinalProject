package web.api.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.api.sample.service.CalculateService;

@RestController
@RequestMapping("/api")
public class CalcInputController {
	
	@Autowired
	CalculateService service;
	
	//@Value("${custom.config.key}")
	float key;

	/*
	 * //http://localhost:8080/api/greet/Aris/Miranda
	 * 
	 * @GetMapping("/calc/{name}/{lastName}") public String
	 * greetMePlease(@PathVariable("name") String name, @PathVariable("lastName")
	 * String lastName) { System.out.println("CUSTOM VALUE -> " + key); return
	 * service.viewGreeting(name + " " + lastName);
	 * 
	 * }
	 */

	
	@GetMapping("/calc")
	public String calculate(@RequestParam int a, @RequestParam int b, @RequestParam int c, @RequestParam int d) {		
		String result = "";
		try {
			result = "Your output is: " + service.calculate(a, b , c, d, key);
			
		} catch (Exception e2) {			
			
			result = "Something went wrong!!!! Check your inputs..";
			e2.printStackTrace();
		}
		
		return result;
	}
	
	
}
