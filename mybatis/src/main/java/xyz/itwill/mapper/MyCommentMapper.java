package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyComment1;
import xyz.itwill.dto.MyComment2;
<<<<<<< HEAD
import xyz.itwill.dto.MyComment3;
import xyz.itwill.dto.MyCommentUser1;
import xyz.itwill.dto.MyCommentUser2;

public interface MyCommentMapper {
	int insertComment1(MyComment1 comment);
	int insertComment2(MyComment1 comment);
	List<MyComment1> selectCommentList1();
	List<MyComment2> selectCommentList2();
	List<MyComment3> selectCommentList3();
	List<MyCommentUser1> seleCommentUserList1();
	List<MyCommentUser2> seleCommentUserList2();
=======

public interface MyCommentMapper {
	int insertComment1(MyComment1 comment);
	int insertComment2(MyComment1 comment);
	List<MyComment1> selectCommentList1();
	List<MyComment2> selectCommentList2();
>>>>>>> refs/remotes/origin/main
}
