package jc.study.com.demo.biz.user.view;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import jc.study.com.demo.R;
import jc.study.com.demo.base.BaseActivity;
import jc.study.com.demo.biz.user.presenter.UserPresenter;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/27
 */
public class UserActivity extends BaseActivity implements IUserView{

    private static final String TAG = "UserActivity";

    private UserPresenter mUserPresenter;

    @BindView(R.id.user_name_tv)
    TextView mUserNameTv;
    @BindView(R.id.age_tv)
    TextView mAgeTv;
    @BindView(R.id.nick_name_tv)
    TextView mNickNameTv;


    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {
        mUserPresenter = new UserPresenter(this);
    }


    @OnClick(R.id.add_user_btn)
    public void onClickAddUser() {
        Log.d(TAG, "onClickAddUser: ");
        mUserPresenter.addUser("test_name_123", 20, "nick_name_456");
    }

    @OnClick(R.id.show_user_btn)
    public void onClickShowUser() {
        mUserPresenter.showUserInfo("test_user_id");
    }


    @Override
    public void updateUserNameTv(String userName) {
        mUserNameTv.setText(userName);
    }

    @Override
    public void updateAgeTv(int age) {
        mAgeTv.setText(String.valueOf(age));
    }

    @Override
    public void updateNickNameTv(String nickName) {
        mNickNameTv.setText(nickName);
    }

    @Override
    public void showToast(String prompt) {
        Toast.makeText(this, prompt, Toast.LENGTH_LONG).show();
    }

}
