package Oracle;

import java.io.InputStream;
import java.util.Date;

/*
 * 数据库中标和类名对应
*/
public class Person {
	private Integer pid ; //字段和属性对应
	private String pname ;
	private String sex;
	private Double tall;
	private Date birthday;
	private InputStream image ;
	
	public Person(Integer pid, String pname, String sex, Double tall,
			Date birthday, InputStream image) {
		this.pid = pid;
		this.pname = pname;
		this.sex = sex;
		this.tall = tall;
		this.birthday = birthday;
		this.image = image;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Double getTall() {
		return tall;
	}
	public void setTall(Double tall) {
		this.tall = tall;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", sex=" + sex
				+ ", tall=" + tall + ", birthday=" + birthday + ", image="
				+ image + "]";
	}

	
}
