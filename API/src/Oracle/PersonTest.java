package Oracle;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		Person person = new Person(1001,"Cindy","女",1.65,new Date(),null);
		System.out.println(person);
	}

}
