package cn.edkso.threadcoreknowledge.createthreads;

/**
 * 描述：  同时使用Runnable和Thread两种方式实现的方式
 */
public class BothRunnableThread{

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        })
        {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();

    }

}
