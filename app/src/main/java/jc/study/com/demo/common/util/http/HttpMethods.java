package jc.study.com.demo.common.util.http;

import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;
import jc.study.com.demo.biz.film.bean.MovieBean;
import jc.study.com.demo.biz.film.service.MovieService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 内部类形式的单例类
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/31
 */
public class HttpMethods {

    private static final String TAG = "HttpMethods";
    
    // API的域名地址
    private static final String BASE_URL = "https://api.douban.com/";

    // API请求的默认超时时间
    private static final int DEFAULT_TIMEOUT = 10;

    private Retrofit mRetrofit;

    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 私有化构造方法
    private HttpMethods() {
        // 手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    /**
     * 返回的Json数据的预处理
     */
    private class HttpResultInit<T> implements Func1<TopMovieHttpResult<T>, T>{

        @Override
        public T call(TopMovieHttpResult<T> httpResult) {
            if (httpResult.getCount() == 0) {
                Log.e(TAG, "call: invalid count: " + httpResult.getCount());
            }
            return httpResult.getSubjects();
        }


    }

    public void getTopMovie(Subscriber<List<MovieBean>> subscriber, int start, int count) {
        mRetrofit.create(MovieService.class)
                .getTopMovie(start, count)
                .map(new HttpResultInit<List<MovieBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
