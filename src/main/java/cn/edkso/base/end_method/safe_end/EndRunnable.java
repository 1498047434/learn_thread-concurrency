package cn.edkso.base.end_method.safe_end;

/**
 * @author 十下
 * 类说明：实现接口Runnable的线程如何中断
 */
public class EndRunnable {
	
	private static class UseRunnable implements Runnable{
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName()
						+ " 我实现了Runnable接口.");
			}
			System.out.println(Thread.currentThread().getName()
					+" 中断标志位是 "+Thread.currentThread().isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		UseRunnable useRunnable = new UseRunnable();
		Thread endThread = new Thread(useRunnable,"endThread");
		endThread.start();
		Thread.sleep(20);
		endThread.interrupt();
	}

}
