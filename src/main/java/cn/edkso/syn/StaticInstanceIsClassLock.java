package cn.edkso.syn;


import cn.edkso.base.tools.SleepTools;

/**
 * @author 十下
 * 类说明：①证明static 修饰的实例作为锁的对象 ==> 是类锁
 *       ②证明Object.class ==> 是类锁
 */
public class StaticInstanceIsClassLock {
    private static class InstanceSyn implements Runnable{
        private StaticInstanceIsClassLock siic;

        public InstanceSyn(StaticInstanceIsClassLock siic) {
            this.siic = siic;
        }
        @Override
        public void run() {
            System.out.println("测试实例 正在运行..."+ Thread.currentThread().getName());
            siic.instance();
        }
    }

    private static Object obj = new Object();
//    private  Object obj = new Object();
    private void instance(){
        synchronized (Object.class){
//        synchronized (obj){
            SleepTools.second(1);
            System.out.println("同步方法instance 开始..."+Thread.currentThread().getName());
            SleepTools.second(1);
            System.out.println("同步方法instance 结束 "+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        StaticInstanceIsClassLock siic1 = new StaticInstanceIsClassLock();
        StaticInstanceIsClassLock siic2 = new StaticInstanceIsClassLock();

        Thread t1 = new Thread(new InstanceSyn(siic1));
        Thread t2 = new Thread(new InstanceSyn(siic2));

        t1.start();
        t2.start();
    }
}
