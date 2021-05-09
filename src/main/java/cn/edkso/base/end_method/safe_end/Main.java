package cn.edkso.base.end_method.safe_end;

import java.lang.reflect.Method;

class My{
    protected void test(){

    }
    public void test1(){

    }
    private void test2(){

    }
}

public class Main extends My{

    public static void main(String[] args) {

        Class<Main> myclass = Main.class;
        Method[] declaredMethods = myclass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }
}
