package cn.edkso.threadcoreknowledge.stopthreads;

/**
 * 最佳实践：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常 那么在run()就会强制try/catch
 */
public class RightWayStopThreadProd implements Runnable{


    @Override
    public void run() {
        while (true ){
            System.out.println("gogogo");
//            fuction1();
            try {
                fuction2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private void fuction1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fuction2() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
