package jc.study.com.demo.biz.film.model;

import android.util.Log;

import java.util.List;

import jc.study.com.demo.base.BaseApiListener;
import jc.study.com.demo.biz.film.bean.MovieBean;
import jc.study.com.demo.biz.film.service.MovieService;
import jc.study.com.demo.util.NetworkUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MovieService service = retrofit.create(MovieService.class);
        service.getTopMovie(0, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ttt", "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        listener.onResponse(movieBean);
                    }
                });
    }

}
