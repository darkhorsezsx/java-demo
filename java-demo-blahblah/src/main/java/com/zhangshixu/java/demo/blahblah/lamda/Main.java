package com.zhangshixu.java.demo.blahblah.lamda;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This is {@link Main}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        });
        thread.start();

        Thread thread1 = new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!"));
        thread1.start();

        List<Entity> list = new ArrayList<Entity>(){{add(new Entity("Mike", 23));add(new Entity("Jack", 23));}};
        list.forEach(entity -> {System.out.println(entity.getName() + "  " + entity.getAge()); System.out.println("tata");});

        String content = StringFormatter.format("您好:昨日夜宵券领取名单已生成，交易数：%d比, 交易额：%.02f元", 12, 12334.5544).getValue();
        System.out.println(content);

        List<String> list1 = new ArrayList<String>(){{add("123");add("456");add("789");}};


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date beginDate = calendar.getTime();

        System.out.println(beginDate);


    }

}
