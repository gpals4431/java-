/*0424 \9*/
package xyz.itwill.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileCopyCharApp {
	public static void main(String[] args) throws IOException {

		BufferedReader in=null;
		BufferedWriter out=null;

		try {
			in=new BufferedReader(new FileReader("c:/data/bandizip.exe"));
			out=new BufferedWriter(new FileWriter("c:/data/bandizip_char.exe"));
			
			int readByte;
			while(true) {
				readByte=in.read();//인코딩처리된 문자 파일을 받음 가공된 데이터로 저장됨 > 다른파일이 됨, text파일은 가능 reder,writer 단순한입출력은 inputouput
				if(readByte==-1) break;
				out.write(readByte);
			}
			
			System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일을 찾을 수 없습니다.");
		} finally {
			in.close();
			out.close();
		}
	}
}
