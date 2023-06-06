package newjava.simple;

import java.util.List;


public interface simpleDAO {
    //계좌 정보를 전달받아 accountbook 테이블에 삽입하고 삽입행의 갯수를 반환하는 매소드
   public int insertAccountBook(simpleDTO account);
   
    //사용날짜와 이름을 전달받아 AccountBook테이블에 저장된 정보를 변경하고 변경행의 갯수를 반환하는 메소드
   public int updateAccountBook(simpleDTO account);

    //이름과 사용날짜 정보를 전달받아 AccountBook 테이블에 저장된 정보를 삭제하고 삭제행의 개수를 반환하는 메소드
    public int deleteAccountBook(simpleDTO account);
   
    //검색창에 이름을 전달받아 PROTECTED_ANIMALS 테이블에 저장된 해당 동물의 동물정보를 검색하여 반환하는 메소드
    public List<simpleDTO> selectAnameList(String aname);
 
    //account_book 테이블에 저장된 계좌정보를 검색하여 반환하는 메소드
    public List<simpleDTO> selectAllaccountList();


}