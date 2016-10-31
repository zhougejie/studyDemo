package jc.study.com.demo.biz.film.presenter;

import android.util.Log;

import jc.study.com.demo.base.BaseApiListener;
import jc.study.com.demo.biz.film.bean.MovieBean;
import jc.study.com.demo.biz.film.model.IMovieModel;
import jc.study.com.demo.biz.film.model.MovieModel;
import jc.study.com.demo.biz.film.view.IMovieView;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/29
 */
public class MoviePresenter implements BaseApiListener<MovieBean> {

    private static final String TAG = "MoviePresenter";

    private IMovieView mMovieView;
    private IMovieModel mMovieModel;

    public MoviePresenter(IMovieView movieView) {
        mMovieView = movieView;
        mMovieModel = new MovieModel();
    }

    public void getTopMovie() {
        mMovieModel.getTopMovie(0, 10, this);
    }

    @Override
    public void onResponse(MovieBean movieBean) {
        Log.d(TAG, "onResponse: " + movieBean.toString());
        mMovieView.updateResultTv(movieBean.toString());
    }

    @Override
    public void onFailure(String message) {
        Log.d(TAG, "onFailure: " + message);
        mMovieView.updateResultTv(message);
    }
}
