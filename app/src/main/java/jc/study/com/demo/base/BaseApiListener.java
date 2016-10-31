package jc.study.com.demo.base;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/29
 */
public interface BaseApiListener<T> {

    void onResponse(T t);

    void onFailure(String message);
}
