package cn.edkso.syn;


import cn.edkso.base.tools.SleepTools;

/**
 * @author 十下
 * 类说明：演示实例锁和类锁是不同的，两者可以并行
 */
public class InstanceAndClass {
	
    private static class SynClass extends Thread{
        @Override
        public void run() {
            System.out.println("测试类 正在运行...");
            synClass();
        }
    }

    private static class InstanceSyn implements Runnable{
        private InstanceAndClass SynClassAndInstance;

        public InstanceSyn(InstanceAndClass SynClassAndInstance) {
            this.SynClassAndInstance = SynClassAndInstance;
        }

        @Override
        public void run() {
            System.out.println("测试实例 正在运行..."+SynClassAndInstance);
            SynClassAndInstance.instance();
        }
    }

    private synchronized void instance(){
        SleepTools.second(1);
        System.out.println("同步方法instance 开始..."+this.toString());
        SleepTools.second(1);
        System.out.println("同步方法instance 结束 "+this.toString());
    }

    private static synchronized void synClass(){
        SleepTools.second(1);
        System.out.println("同步方法synClass 开始...");
        SleepTools.second(1);
        System.out.println("同步方法synClass 结束");
    }

    public static void main(String[] args) {
        InstanceAndClass synClassAndInstance = new InstanceAndClass();
        Thread t1 = new SynClass();
        Thread t2 = new Thread(new InstanceSyn(synClassAndInstance));
        t2.start();
        SleepTools.second(1);
        t1.start();
    }
}
