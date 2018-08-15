package JunitDemo;

import org.apache.log4j.Logger;

import LOG.logDemo;

public class Calculate {
	private static Logger LOG = Logger.getLogger(logDemo.class);

	public int add(int num1 ,int num2){
		LOG.debug("num1: " + num1 + " + num2 : " + num2 + " = " + (num1+num2));
		return num1 + num2 ;
	}
	public int divid(int num1 ,int num2){
		LOG.debug("num1: " + num1 + " / num2 : " + num2 + " = " + (num1/num2));
		return num1 / num2 ;
	}
	
}
