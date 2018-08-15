package JunitDemo;

import org.junit.Assert;
import org.junit.Test;

public class CalculateTest {

	@Test
	public void testAdd() {
		Calculate al = new Calculate();
		int result = al.add(2, 5);
		System.out.println("运算结果为： " + result);
		Assert.assertSame(result,3);   //断言：判断结果是否与期望结果一样，result是运行结果，3是期望结果
//		Assert.assertNull(result);     用断言来判空
	}

	@Test
	public void testDivid() {
		Calculate al = new Calculate();
		int result = al.divid(8, 4);
		System.out.println("运算结果为： " + result);
	}

}
