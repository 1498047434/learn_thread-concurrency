package cn.edkso.threadcoreknowledge.createthreads;

/**
 * 描述：   用Thread方式实现线程
 */
public class ThreadStyle extends Thread{

    public static void main(String[] args) {
        new ThreadStyle().run();
    }
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }
}
