package xyz.itwill10.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.RestBoardDAO;
import xyz.itwill10.dto.RestBoard;

@Service
@RequiredArgsConstructor
public class RestBoardServiceImpl implements RestBoardService {
	private final RestBoardDAO restBoardDAO;

	@Override
	public void addRestBoard(RestBoard restBoard) {
		
		restBoardDAO.insertRestBoard(restBoard);
	}

	@Override
	public void modifyRestBoard(RestBoard restBoard) {
		/*
		 * if(restBoardDAO.selectRestBoard(restBoard.getIdx())==null) { throw new
		 * Exception("해당 게시글 찾을 수 없음 "); }
		 */
		restBoardDAO.updateRestBoard(restBoard);
	}

	@Override
	public void removeRestBoard(int idx) {
		
	}

	@Override
	public RestBoard getRestBoard(int idx) {
		return null;
	}

	@Override
	public Map<String, Object> getRestBoardList(int pageNum) {
		return null;
	}
}
