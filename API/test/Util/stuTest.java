package Util;

public class stuTest {
       private String name ;
       private int age ;
       private String gender ;
       private String stuNo;
       
	public stuTest(String name, int age, String gender, String stuNo) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.stuNo = stuNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", gender=" + gender
				+ ", stuNo=" + stuNo + "]";
	}
       
       
}
