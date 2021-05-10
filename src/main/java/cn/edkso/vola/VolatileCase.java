package cn.edkso.vola;

import cn.edkso.base.tools.SleepTools;

/**
 * @author 十下（dingmengdi）[1498047434]
 * 类说明：演示Volatile的提供的可见性
 */
public class VolatileCase {
    private static boolean ready;
//    private volatile static boolean ready;
    private static int number;


    private static class PrintThread extends Thread{
        @Override
        public void run() {
            System.out.println("打印线程继续工作中.......");
            while(!ready);//无限循环
            System.out.println("number = "+number);
        }
    }

    public static void main(String[] args) {
        new PrintThread().start();
        SleepTools.second(1);
        number = 51;
        ready = true;
        SleepTools.second(5);
        System.out.println("主线程结束!");
    }
}
