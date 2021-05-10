package cn.edkso.syn;

import cn.edkso.base.tools.SleepTools;

/**
 * @author 十下
 * 类说明：类锁和锁static变量也是不同的
 */
public class StaticAndClass {
	
    private static class SynClass extends Thread{
        @Override
        public void run() {
            System.out.println(currentThread().getName()
                    +":SynClass is running...");
            synClass();
        }
    }

    private static class SynStatic extends Thread{
        @Override
        public void run() {
            System.out.println(currentThread().getName()
                    +"SynStatic is running...");
            synStatic();
        }
    }

    private static synchronized void synClass(){
        System.out.println(Thread.currentThread().getName()
                +"synClass going...");
        SleepTools.second(1);
        System.out.println(Thread.currentThread().getName()
                +"synClass end");
    }

    private static Object obj = new Object();
    private static void synStatic(){
        synchronized(Object.class) {
            System.out.println(Thread.currentThread().getName()
                    +"synStatic going...");
            SleepTools.second(1);
            System.out.println(Thread.currentThread().getName()
                    +"synStatic end");
        }
    }

    public static void main(String[] args) {
        StaticAndClass synClassAndInstance = new StaticAndClass();
        Thread t1 = new SynClass();

        Thread t2 = new SynClass();
        t1.start();
        t2.start();


        SleepTools.second(3);
        System.out.println("过渡------------------------------");

        Thread t3 = new SynStatic();
        Thread t4 = new SynStatic();
        t3.start();
        t4.start();
    }
}
