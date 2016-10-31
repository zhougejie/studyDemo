package jc.study.com.demo.biz.film.view;

import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jc.study.com.demo.R;
import jc.study.com.demo.base.BaseActivity;
import jc.study.com.demo.biz.film.presenter.MoviePresenter;
import jc.study.com.demo.util.NetworkUtil;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/28
 */
public class MovieActivity extends BaseActivity implements IMovieView {

    private static final String TAG = "MovieActivity";

    private MoviePresenter mPresenter;

    @BindView(R.id.click_me_btn)
    Button mClickMeBtn;

    @BindView(R.id.result_tv)
    TextView mResultTv;


    @Override
    public int initLayoutId() {
        return R.layout.activity_film;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new MoviePresenter(this);
    }

    @OnClick(R.id.click_me_btn)
    public void onClickMe() {
        if (NetworkUtil.isNetConnected(this)) {
            mPresenter.getTopMovie();
        } else {
            mPresenter.getTopMovie();
        }

    }

    @Override
    public void updateResultTv(String result) {
        mResultTv.setText(result);
    }
}
