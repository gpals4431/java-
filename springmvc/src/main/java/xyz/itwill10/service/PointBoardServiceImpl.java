package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.PointBoardDAO;
import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;

@Service //dao ��ü ������ �޾Ƽ� ������ ó������
@RequiredArgsConstructor//������ ������ ����ϸ� @autowired�� �ʵ帶�� �������� �ʿ���� �ѹ��� �ۼ����൵��
public class PointBoardServiceImpl implements PointBoardService {
	private final PointUserDAO pointUserDAO;
	private final PointBoardDAO pointBoardDAO;
	
	//�Ű������� �Խñ��� ���޹޾� pointboard ���̺� �Խñ۷� �����ϰ� �ۼ��ڿ� ���� ȸ��������
	//pointuser ���̺��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	//=> pointuser ���̺��� �Խñ� �ۼ����� ȸ�������� ����Ʈ�� �����ǵ��� ���� ó��
	@Transactional(rollbackFor=Exception.class)
	@Override
	public PointUser addPointBoard(PointBoard board) throws Exception {
		pointBoardDAO.insertPointBoard(board);//�Խñ� ����
		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���� ��� ������ ���� �߻�
		// => ���ܰ� �߻��� ��� �ϴܿ� �ۼ��� ����� ������� �ʰ� �޼ҵ� ���� ����
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new Exception("�Խñ� �ۼ��ڰ� �������� �ʽ��ϴ�.");
		}
		
		pointUserDAO.updatePlusPointUser(board.getWriter());//ȸ�������� ����Ʈ ����
		
		return pointUserDAO.selectPointUser(board.getWriter());//ȸ�������� �˻��Ͽ� ��ȯ
	}
	@Transactional
	@Override
	public PointUser removePointBoard(int idx) throws Exception {
		PointBoard board=pointBoardDAO.selectPointBoard(idx);//�Խñ� �˻�
		//�۹�ȣ�� ���� �Խñ��� �˻����� ���� ��� ������ ���� �߻� 
		if(board == null) {
			throw new Exception("�Խñ��� �������� �ʽ��ϴ�.");
		}
		
		pointBoardDAO.deletePointBoard(idx);//�Խñ� ����
		
		//�Խñ� �ۼ��ڿ� ���� ȸ�������� ���� ��� ������ ���� �߻�
		if(pointUserDAO.selectPointUser(board.getWriter()) == null) {
			throw new Exception("�Խñ� �ۼ��ڰ� �������� �ʽ��ϴ�.");
		}
		
		pointUserDAO.updateMinusPointUser(board.getWriter());//ȸ�������� ����Ʈ ����
		
		return pointUserDAO.selectPointUser(board.getWriter());//ȸ�������� �˻��Ͽ� ��ȯ
	}


	//POINTBOARD ���̺� ����� ��� �Խñ��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
		@Override
		public List<PointBoard> getPointBoardList() {
			return pointBoardDAO.selectPointBoardList();
		}

	}