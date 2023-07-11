/* 0417 4-1*/package xyz.itwill.thread;


public class MultiThreadOne extends Thread {
	@Override
	public void run() {
		for(char i='a';i<='z';i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}