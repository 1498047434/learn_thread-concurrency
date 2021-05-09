package cn.edkso.base;

import java.util.concurrent.ExecutionException;

/**
 * @author 十下
 * 类说明：守护线程的使用
 */
public class DaemonThread {
	private static class UseThread extends Thread{
		@Override
		public void run() {
			try {
				while (!isInterrupted()) {
					System.out.println(Thread.currentThread().getName() 
							+ " 我是继承自Thread.");
				}
				System.out.println(Thread.currentThread().getName() 
						+ " 中断标志位是 " + isInterrupted());
			} finally {
				//守护线程中finally不一定起作用,或者说finally中的部分代码不一定起作用
				for (int i = 0; i < 100000; i++) {
					if (i % 10000 ==0) System.out.println("---");
				}
				System.out.println(" .............finally");
			}
		}
	}
	
	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		UseThread useThread = new UseThread();
		useThread.setDaemon(true);
		useThread.start();
		Thread.sleep(5);
		useThread.interrupt();
	}
}
