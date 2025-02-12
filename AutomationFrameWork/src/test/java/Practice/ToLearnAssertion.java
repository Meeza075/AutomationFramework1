package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ToLearnAssertion {
	@Test
	public void sample() {
		System.out.println("step 1");
		System.out.println("step 2");
		
		//Hard assert
		   //Assert.assertEquals(false, false);
		   //Assert.assertEquals(true, false);
		//Soft assert
		    SoftAssert sa= new SoftAssert();
		     //sa.assertEquals(false, false);
		     //sa.assertEquals(true, false);
		     sa.assertEquals(true, true);
		System.out.println("step 3");
		System.out.println("step 4");
		sa.assertAll();
	}

}
