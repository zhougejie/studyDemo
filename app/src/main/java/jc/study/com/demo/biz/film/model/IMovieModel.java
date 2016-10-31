package jc.study.com.demo.biz.film.model;

import java.util.List;
import jc.study.com.demo.base.BaseApiListener;
import jc.study.com.demo.biz.film.bean.MovieBean;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/28
 */
public interface IMovieModel {

    void getTopMovie(int start, int count, final BaseApiListener<List<MovieBean>> listener);

}
