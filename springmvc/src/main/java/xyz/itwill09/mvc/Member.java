package xyz.itwill09.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

//??? λ³΄λ?? ???₯?κΈ? ?? ?΄??€ - DTO ?΄??€
@AllArgsConstructor
@Data
public class Member {
	private String id;
	private String name;
	private String address;
}
