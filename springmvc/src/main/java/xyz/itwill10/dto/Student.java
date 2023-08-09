package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

//DTO 클래스 : DAO 클래스의 메소드에서 사용하기 위한 값을 표현하기 위한 클래스
// => 테이블을 Java 클래스로 표현하여 객체로 생성하여 사용하기 위해 작성

/*빌더 어노테이션 사용하면 이안에 builder클래스가 생성됨 
Student 클래스의 Studentbilder 클래스로 Student 객체를 생성하여 반환받아 생성하는 것을 권장함
studentbiilder() 메소드를 호출해 빌더 객체를 제공받아 필드 관련 메소드로 필드값을 변경하여 
build() 메소드로 student 객체를 반환받아 사용*/
@Data
@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}