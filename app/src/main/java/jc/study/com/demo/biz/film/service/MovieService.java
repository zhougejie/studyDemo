package jc.study.com.demo.biz.film.service;

import java.util.List;

import jc.study.com.demo.biz.film.bean.MovieBean;
import jc.study.com.demo.common.util.http.TopMovieHttpResult;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/29
 */
public interface MovieService {

    // https://api.douban.com/v2/movie/top250?start=0&count=10

    @GET("v2/movie/top250")
    Observable<TopMovieHttpResult<List<MovieBean>>> getTopMovie(@Query("start") int start, @Query("count") int count);

}
