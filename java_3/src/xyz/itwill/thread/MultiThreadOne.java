/* 0417 4-1*/package xyz.itwill.thread;

public class MultiThreadOne extends Thread{
	@Override 
	public void run() {//예외 전달 못함 >> 예외전달하면 오버라이드가아님
		for(char i='a'; i <'z'; i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
	}
}
