package xyz.itwill10.service;


import java.util.Map;

import xyz.itwill10.dto.RestBoard;

public interface RestBoardService {
	void addRestBoard(RestBoard board);
	void modifyRestBoard(RestBoard board);
	void removeRestBoard(int idx);
	RestBoard getRestBoard(int idx);
	Map<String, Object> getRestBoardList(int pageNum);
}
