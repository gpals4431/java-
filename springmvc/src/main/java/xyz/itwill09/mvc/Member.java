package xyz.itwill09.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

//?��?��?��보�?? ???��?���? ?��?�� ?��?��?�� - DTO ?��?��?��
@AllArgsConstructor
@Data
public class Member {
	private String id;
	private String name;
	private String address;
}