package co.micol.kym.student.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {
	private String id;
	private String password;
	private String name;
	private String address;
	private String tel;
	private Date birthday;
	private int age;
	
}
