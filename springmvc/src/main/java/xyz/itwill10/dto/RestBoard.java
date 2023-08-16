package xyz.itwill10.dto;

import lombok.Data;

@Data
public class RestBoard {
	private int idx;
	private String writer;
	private String content;
	private String regDate;
}
