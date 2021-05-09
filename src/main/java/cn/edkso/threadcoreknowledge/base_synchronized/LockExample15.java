package cn.edkso.threadcoreknowledge.base_synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample15 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();

        lock.unlock();

        lock.tryLock();

//        lock.tryLock(1000, TimeUnit.SECONDS);
        

    }
}
