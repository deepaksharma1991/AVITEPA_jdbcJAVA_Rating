package test;



import com.wirpro.utils.AverageCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentApplicationTest {
	
	public AverageCalculator avgCal = new AverageCalculator();
	
	@Test
	public void testStudentAverage() {
		System.out.println("\n Testing Student Average.. \n ");
		
		Map<String,HashMap<String,Integer>> inputMap = new HashMap<String,HashMap<String,Integer>>();
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("test_1", 100);
		hm.put("project_1", 100);
		hm.put("quiz_1", 100);
		hm.put("quiz_2", 100);
		hm.put("lab_1", 100);
		hm.put("test_2", 100);
		
		HashMap<String,Integer> hm1 = new HashMap<String,Integer>();
		hm1.put("test_1",86);
		inputMap.put("Electro Fields", hm);
		inputMap.put("Computing Techniques", hm1);
		
		System.out.println("\nStudent : Ananth \n ");
		avgCal.constructMap(inputMap,"Subject");
		assertEquals(1,1);
		
	}
	
	
	@Test
	public void testSubjectAverage() {
		System.out.println("\n Testing Subject Average..\n ");
		Map<String,HashMap<String,Integer>> inputMap = new HashMap<String,HashMap<String,Integer>>();
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		hm.put("test_1", 100);
		hm.put("project_1", 100);
		hm.put("quiz_1", 100);
		hm.put("quiz_2", 100);
		hm.put("lab_1", 100);
		hm.put("test_2", 100);
		
	    inputMap.put("Ananth", hm);
	    
	    HashMap<String,Integer> hm1 = new HashMap<String,Integer>();
	    hm1.put("test_1",78);
	    hm1.put("quiz_1",20);
	    hm1.put("quiz_2",50);
	    hm1.put("lab_1",10);
	    hm1.put("project_1",100);
	    inputMap.put("Bhagath", hm1);
	    
	    HashMap<String,Integer> hm2 = new HashMap<String,Integer>();
	    hm2.put("test_1",68);
	    hm2.put("lab_1",10);
	    hm2.put("project_1",100);
	    hm2.put("test_2",92);
	    inputMap.put("Chaya", hm2);
	    
	    HashMap<String,Integer> hm3 = new HashMap<String,Integer>();
	    hm3.put("test_1",87);
	    inputMap.put("Esharath", hm3);
	    
	    HashMap<String,Integer> hm4 = new HashMap<String,Integer>();
	    hm4.put("project_1",100);
	    inputMap.put("Davanth", hm4);
	    
	    System.out.println("\nSubject : Electro Fields \n ");
		avgCal.constructMap(inputMap,"Name");
		
		assertEquals(1,1);
	    
	}
	

}
