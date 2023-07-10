package newjava.simple;

/*
 이름      널?       유형           
------- -------- ------------ 
ANAME   NOT NULL VARCHAR2(20) 
AMONEY  NOT NULL NUMBER(10)   
AINOUT  NOT NULL VARCHAR2(10) 
USEDATE NOT NULL DATE         
AOUT             VARCHAR2(20) 
AIN              VARCHAR2(20) 

 */
   
//ACCOUNT_BOOK 테이블에 저장된 하나의 행을 저장하여 전달하기 위한 DTO클래스
public class simpleDTO {
   private String aname;
   private int amoney;
   private String ainout;
   private String usedate;
   private String aout;
   private String ain;
   
   public simpleDTO() {
      // TODO Auto-generated constructor stub
   }

   public simpleDTO(String aname, int amoney, String ainout, String usedate, String aout, String ain) {
      super();
      this.aname = aname;
      this.amoney = amoney;
      this.ainout = ainout;
      this.usedate = usedate;
      this.aout = aout;
      this.ain = ain;
   }

   public String getAname() {
      return aname;
   }

   public void setAname(String aname) {
      this.aname = aname;
   }

   public int getAmoney() {
      return amoney;
   }

   public void setAmoney(int amoney) {
      this.amoney = amoney;
   }

   public String getAinout() {
      return ainout;
   }

   public void setAinout(String ainout) {
      this.ainout = ainout;
   }

   public String getUsedate() {
      return usedate;
   }

   public void setUsedate(String usedate) {
      this.usedate = usedate;
   }

   public String getAout() {
      return aout;
   }

   public void setAout(String aout) {
      this.aout = aout;
   }

   public String getAin() {
      return ain;
   }

   public void setAin(String ain) {
      this.ain = ain;
   }
   
   
   
}