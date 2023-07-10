package study.dto;
/*
 create table login (id varchar2(100) primary key, password varchar2(100), name varchar2(200));
 */

public class joinDTO {
	private String id;
	private String password;
	private String name;
	
	public joinDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
