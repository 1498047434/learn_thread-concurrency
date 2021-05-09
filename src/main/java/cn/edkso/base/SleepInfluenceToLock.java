package cn.edkso.base;

/**
 * @author 十下
 * 类说明：测试Sleep对锁的影响
 * 结果：sleep()不会释放锁
 */
public class SleepInfluenceToLock {
    private Object lock = new Object();

    public static void main(String[] args) {
        SleepInfluenceToLock sleepTest = new SleepInfluenceToLock();

        Thread threadA = sleepTest.new ThreadSleep();
        threadA.setName("ThreadSleep");

        Thread threadB = sleepTest.new ThreadNotSleep();
        threadB.setName("ThreadNotSleep");

        threadA.start();
        try {
            Thread.sleep(1000);
            System.out.println("主线程睡眠完成---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }

    private class ThreadSleep extends Thread{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+" 将要获得锁");
            try {
                synchronized(lock) {
                    System.out.println(threadName+" 拿到锁");
                    Thread.sleep(5000);
                    System.out.println("完成任务: "+threadName);
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    private class ThreadNotSleep extends Thread{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+" 将要获得锁 time="+System.currentTimeMillis());
            synchronized(lock) {
                System.out.println(threadName+" 拿到锁 time="+System.currentTimeMillis());
                System.out.println("完成任务: "+threadName);
            }
        }
    }
}
