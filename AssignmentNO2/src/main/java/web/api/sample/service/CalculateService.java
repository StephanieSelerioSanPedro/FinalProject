package web.api.sample.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {
	public Double calculate(int a, int b, int c, int d, float key) throws Exception{		
		double result = 0;
		
		try {
			if(a == 100) {
				throw new Exception("You cannot enter 100");
			}
			result = (a + b + c + d) * key;
		} catch (Exception e2) {
			throw e2;
		}
		
		return result;		
	}
}
