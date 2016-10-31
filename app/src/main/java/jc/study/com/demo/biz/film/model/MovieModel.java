package jc.study.com.demo.biz.film.model;

import java.util.List;

import jc.study.com.demo.base.BaseApiListener;
import jc.study.com.demo.biz.film.bean.MovieBean;
import jc.study.com.demo.biz.film.service.MovieService;
import jc.study.com.demo.util.NetworkUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/28
 */
public class MovieModel implements IMovieModel {


    @Override
    public void getTopMovie(int start, int count, final BaseApiListener<MovieBean> listener) {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieService service = retrofit.create(MovieService.class);
        Call<MovieBean> call = service.getTopMovie(0, 10);
        call.enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }

}
