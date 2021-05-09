package cn.edkso.threadcoreknowledge.createthreads;

/**
 * 描述： 用Runnable方式创建线程
 *
 * 更好：
 *  1. 解耦
 *  2. 资源的节约上
 *  3. 可以继承其他类，可扩展性好
 */
public class RunableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable方式实现线程");
    }
}
