package cn.edkso.base.end_method.safe_end;

/**
 * @author 十下
 * 类说明：阻塞方法中抛出InterruptedException异常后，如果需要继续中断，需要手动再中断一次
 * 原因：sleep收到中断后，会抛出中断异常，并发中断标志位设置为false，以便程序继续运行，若需要中断，手动触发中断就可以了
 */
public class HasInterrputException {
	
	private static class UseThread extends Thread{
		
		public UseThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			while(!isInterrupted()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()
							+" 中断异常Catch块中，中断标志位是 "
							+isInterrupted());
					//资源释放
					interrupt();
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ " 我是继承自Thread.");
			}
			System.out.println(Thread.currentThread().getName()
					+" 中断标志位是 "+isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("HasInterrputEx");
		endThread.start();
		Thread.sleep(500);
		endThread.interrupt();
	}

}
