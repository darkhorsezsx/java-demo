package com.zhangshixu.java.demo.blahblah.test;

/**
 * This is {@link Son}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Son extends AbsFather {

    @Override
    void test() {

    }

    public static void main(String[] args) {
        Son son = new Son();
        son.dispatch();
    }
}
