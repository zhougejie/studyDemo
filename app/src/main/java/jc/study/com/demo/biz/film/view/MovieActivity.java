package jc.study.com.demo.biz.film.view;

import android.app.ProgressDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jc.study.com.demo.R;
import jc.study.com.demo.base.BaseActivity;
import jc.study.com.demo.biz.film.presenter.MoviePresenter;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/28
 */
public class MovieActivity extends BaseActivity implements IMovieView {

    private static final String TAG = "MovieActivity";

    private MoviePresenter mPresenter;

    private ProgressDialog mProgressDialog;

    private MovieAdapter mAdapter;

    @BindView(R.id.click_me_btn)
    Button mClickMeBtn;

    @BindView(R.id.result_tv)
    TextView mResultTv;

    @BindView(R.id.result_list_rv)
    RecyclerView mRecyclerView;


    @Override
    public int initLayoutId() {
        return R.layout.activity_film;
    }

    @Override
    public void initView() {
        String[] data = new String[20];
        for (int i=0; i<20; i++) {
            data[i] = "item" + (i+1);
        }
        mAdapter = new MovieAdapter(this, data);

        // listview式的单列纵向布局
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 2列的纵向布局
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

        // 4行的横向布局
//      mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false));

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initPresenter() {
        mPresenter = new MoviePresenter(this);
    }

    @OnClick(R.id.click_me_btn)
    public void onClickMe() {
        mPresenter.getTopMovie();

        // 局部刷新数据
//        mAdapter.mData[0] = "1111";
//        mAdapter.mData[3] = "9999";
//        mAdapter.notifyItemChanged(0);
//        mAdapter.notifyItemChanged(3);

    }

    @Override
    public void updateResultTv(String result) {
        mResultTv.setText(result);
    }

    @Override
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("加载中");
        }
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if(mProgressDialog != null) {
            mProgressDialog.hide();
        }
    }
}
