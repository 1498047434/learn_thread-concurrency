package cn.edkso.base.end_method.safe_end;

/**
 * @author 十下
 * 类说明：如何安全中断线程,并且验证isInterrupted() 和 interrupted()区别
 * 测试结果：
 * 	① static interrupted() 判断中断标志位，并设置为false
 * 	② isInterrupted（）判断中断标志位，不修改
 */
public class EndThreadAndCheckIsInterruptedWithInterrupted {
	
	private static class UseThread extends Thread{

		public UseThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+" 中断标志位是 ="+isInterrupted());
//			while(!isInterrupted()){
			while(!Thread.interrupted()){
				//while(true){
				System.out.println(threadName+" 正在运行");
				System.out.println(threadName+" Thread.interrupted()为判断的循环体内 中断标志位是 ="
						+isInterrupted());
			}
			System.out.println(threadName+" 中断标志位是 ="+isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("endThread");
		endThread.start();
		Thread.sleep(20);
		endThread.interrupt();//中断线程，其实设置线程的标识位true
	}

}
