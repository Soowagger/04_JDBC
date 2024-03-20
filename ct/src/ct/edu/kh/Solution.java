package ct.edu.kh;

import java.time.LocalDate;

public class Solution {
    	
    public int solution(int num1, int num2) {
    	
        int answer = 0;
        
        if(0 < num1 && num1 <= 100 && 0 < num2 && num2 <= 100) {
            
        	//double temp = (double)num1 / num2 * 1000;
        	answer = (int)((double)num1 / num2 * 1000);
            
        }
        
        return answer;
    }
	
	

	
}
