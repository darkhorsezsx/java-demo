package com.zhangshixu.java.demo.blahblah.reflection;

import com.zhangshixu.java.demo.blahblah.reflection.entity.Animal;
import com.zhangshixu.java.demo.blahblah.reflection.entity.Person;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

/**
 * This is {@link TestFields}.
 *
 * @author Zhang Shixu
 * @since 0.0.1
 */
public class TestFields {

    public static void main(String[] args) {
        Animal animal = new Animal("dog", 12, "zsx");
        Animal animal2 = new Animal("cat", 12, "sss");
        Person person = new Person("Jack", animal);
        Person person2 = new Person("Jack", animal);
//        System.out.println(contrastObj(animal, animal2));
        System.out.println(compareFieldsV3(person, person2, new String[]{}));
    }

    /**
     * demo1
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean contrastObj(Object obj1, Object obj2) {
        boolean isEquals = true;
        if (obj1 instanceof Animal && obj2 instanceof Animal ) {
            Animal pojo1 = (Animal) obj1;
            Animal pojo2 = (Animal) obj2;
            List textList = new ArrayList<String>();
            try {
                Class clazz = pojo1.getClass();
                Field[] fields = pojo1.getClass().getDeclaredFields();
                for (Field field : fields) {
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                    Method getMethod = pd.getReadMethod();
                    Object o1 = getMethod.invoke(pojo1);
                    Object o2 = getMethod.invoke(pojo2);
                    if (!o1.toString().equals(o2.toString())) {
                        isEquals = false;
                        textList.add(getMethod.getName() + ":" + "false");
                    } else {
                        textList.add(getMethod.getName() + ":" + "true");
                    }
                }
            } catch (Exception e) {

            }
            for (Object object : textList) {
                System.out.println(object);
            }
        }
        return isEquals;
    }

    /**
     * demo2
     * @param obj1
     * @param obj2
     * @param ignoreArr
     * @return
     */
    public static Map<String, List<Object>> compareFields(Object obj1, Object obj2, String[] ignoreArr) {
        try{
            Map<String, List<Object>> map = new HashMap<String, List<Object>>();
            List<String> ignoreList = null;
            if(ignoreArr != null && ignoreArr.length > 0){
                ignoreList = Arrays.asList(ignoreArr);
            }
            if (obj1.getClass() == obj2.getClass()) {// 只有两个对象都是同一类型的才有可比性
                Class clazz = obj1.getClass();
                // 获取object的属性描述
                PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {// 这里就是所有的属性了
                    String name = pd.getName();// 属性名
                    if(ignoreList != null && ignoreList.contains(name)){// 如果当前属性选择忽略比较，跳到下一次循环
                        continue;
                    }
                    Method readMethod = pd.getReadMethod();// get方法
                    // 在obj1上调用get方法等同于获得obj1的属性值
                    Object o1 = readMethod.invoke(obj1);
                    // 在obj2上调用get方法等同于获得obj2的属性值
                    Object o2 = readMethod.invoke(obj2);
                    if(o1 == null && o2 == null){
                        continue;
                    }else if(o1 == null && o2 != null){
                        List<Object> list = new ArrayList<Object>();
                        list.add(o1);
                        list.add(o2);
                        map.put(name, list);
                        continue;
                    }
                    if (!o1.equals(o2)) {// 比较这两个值是否相等,不等就可以放入map了
                        List<Object> list = new ArrayList<Object>();
                        list.add(o1);
                        list.add(o2);
                        map.put(name, list);
                    }
                }
            }
            return map;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * demo3
     * @param obj1
     * @param obj2
     * @param ignoreArr
     * @return
     */
    public static Map<String, Map<String,Object>> compareFieldsV3(Object obj1, Object obj2, String[] ignoreArr) {
        try{
            Map<String, Map<String,Object>> map = new HashMap<>();
            Map<String, Object> objMap1 = new HashMap<>();
            Map<String, Object> objMap2 = new HashMap<>();
            map.put("former", objMap1);
            map.put("latter", objMap2);

            List<String> ignoreList = null;
            if(ignoreArr != null && ignoreArr.length > 0){
                ignoreList = Arrays.asList(ignoreArr);
            }
            if (obj1.getClass() == obj2.getClass()) {// 只有两个对象都是同一类型的才有可比性
                Class clazz = obj1.getClass();
                // 获取object的属性描述
                PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {// 这里就是所有的属性了
                    String name = pd.getName();// 属性名
                    if(ignoreList != null && ignoreList.contains(name)){// 如果当前属性选择忽略比较，跳到下一次循环
                        continue;
                    }
                    Method readMethod = pd.getReadMethod();// get方法
                    // 在obj1上调用get方法等同于获得obj1的属性值
                    Object o1 = readMethod.invoke(obj1);
                    // 在obj2上调用get方法等同于获得obj2的属性值
                    Object o2 = readMethod.invoke(obj2);
                    if(o1 == null && o2 == null){
                        continue;
                    }else if(o1 == null && o2 != null){
                        objMap1.put(name, o1);
                        objMap2.put(name, o2);
                        continue;
                    }
                    if (!o1.equals(o2)) {// 比较这两个值是否相等,不等就可以放入map了
                        objMap1.put(name, o1);
                        objMap2.put(name, o2);
                    }
                }
            }
            return map;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
