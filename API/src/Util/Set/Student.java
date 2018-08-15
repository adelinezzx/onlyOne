package Util.Set;

public class Student {
    
     private String name  ;
     private String gender ;
     private int age ;
     private String sno ;
     
     
	
	public Student(String name, String gender, int age, String sno) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.sno = sno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", gender=" + gender + ", age=" + age
				+ ", sno=" + sno + "]";
	}
	

	
	
     
}
