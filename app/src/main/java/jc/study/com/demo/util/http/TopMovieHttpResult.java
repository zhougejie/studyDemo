package jc.study.com.demo.util.http;

import java.util.List;

/**
 * 这应该是json返回的data数据集，根据接口定义来
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/31
 */
public class TopMovieHttpResult<T> {

    private int count;
    private int start;
    private int total;

    private String title;

    private T subjects;

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
