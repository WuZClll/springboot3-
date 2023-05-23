package com.bjpowernode.pk1;

import java.util.Optional;

/**
 * @Author Wu
 * @Date 2023/5/5 19:18
 * @Description
 */
public record Student(Integer id, String name, String email, Integer age) {
    //实例方法 ，concat连接字符串
    public String concat(){
        return String.format("姓名是%s,年龄是%d", this.name,this.age);
    }
    //静态方法，把email转为大写
    public static String emailToUpperCase(String email){
        //ofNullable创建一个对象(可以为空)
        // orElse("no email")如果这个对象不包含值则返回"no email"
        return Optional.ofNullable(email).orElse("no email").toUpperCase();
    }

    //紧凑
    public Student {
        System.out.println("id="+id);
        if( id < 1 ) {
            throw new RuntimeException("id < 1");
        }
    }

    //定制构造方法
    public Student(Integer id,String name){
        this(id,name,null,null);
    }
}
