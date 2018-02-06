package com.zhangshixu.java.demo.blahblah.test;

/**
 * This is {@link AbsFather}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public abstract class AbsFather {

    public void bind() {

    }

    protected void dispatch() {
        System.out.println("tata");
    }

    abstract void test();

}
