package jc.study.com.demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/28
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutId());
        mUnbinder = ButterKnife.bind(this);
        initView();
        initPresenter();
    }

    public abstract int initLayoutId();

    public abstract void initView();

    public abstract void initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解除绑定，官方文档只对fragment做了解绑。
        mUnbinder.unbind();
    }

}
