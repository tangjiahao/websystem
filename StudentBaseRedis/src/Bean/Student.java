package Bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable,Comparable<Student> {
	private String Id;
	private String name;
	private String birthday;
	private String description;
	private int avgscore;
	
	public Student(String id, String name, String birthday, String description, int avgscore) {
		
		Id = id;
		this.name = name;
		this.birthday = birthday;
		this.description = description;
		this.avgscore = avgscore;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(int avgscore) {
		this.avgscore = avgscore;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", birthday=" + birthday + ", description=" + description
				+ ", avgscore=" + avgscore + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.getAvgscore()-this.getAvgscore();
	}
	

}
