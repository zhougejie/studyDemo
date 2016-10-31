package jc.study.com.demo.biz.film.model;

import android.util.Log;
import jc.study.com.demo.base.BaseApiListener;
import jc.study.com.demo.biz.film.bean.MovieBean;
import jc.study.com.demo.util.http.HttpMethods;
import rx.Subscriber;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/28
 */
public class MovieModel implements IMovieModel {

    private Subscriber<MovieBean> mSubscriber;

    @Override
    public void getTopMovie(int start, int count, final BaseApiListener<MovieBean> listener) {

        mSubscriber = new Subscriber<MovieBean>() {
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
        };
        HttpMethods.getInstance().getTopMovie(mSubscriber, start, count);
    }

}
