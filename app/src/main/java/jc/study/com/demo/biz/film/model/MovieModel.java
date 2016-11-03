package jc.study.com.demo.biz.film.model;

import android.util.Log;

import java.util.List;

import jc.study.com.demo.base.BaseApiListener;
import jc.study.com.demo.biz.film.bean.MovieBean;
import jc.study.com.demo.common.util.http.HttpMethods;
import rx.Subscriber;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/28
 */
public class MovieModel implements IMovieModel {

    private static final String TAG = "MovieModel";

    private Subscriber<List<MovieBean>> mSubscriber;

    @Override
    public void getTopMovie(int start, int count, final BaseApiListener<List<MovieBean>> listener) {

        mSubscriber = new Subscriber<List<MovieBean>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                listener.onFailure(e.getMessage());
            }

            @Override
            public void onNext(List<MovieBean> movieBeanList) {
                listener.onResponse(movieBeanList);
            }
        };
        HttpMethods.getInstance().getTopMovie(mSubscriber, start, count);
    }

}
