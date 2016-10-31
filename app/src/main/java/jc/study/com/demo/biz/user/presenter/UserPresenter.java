package jc.study.com.demo.biz.user.presenter;

import android.os.Handler;
import android.util.Log;
import java.util.UUID;
import jc.study.com.demo.biz.user.bean.UserBean;

import jc.study.com.demo.biz.user.listener.OnAddUserListener;
import jc.study.com.demo.biz.user.model.IUserModel;
import jc.study.com.demo.biz.user.model.impl.UserModel;
import jc.study.com.demo.biz.user.view.IUserView;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/27
 */
public class UserPresenter implements OnAddUserListener {

    private static final String TAG = "UserPresenter";

    private IUserModel mUserModel;
    private IUserView mUserView;

    private Handler mUserHandler = new Handler();

    public UserPresenter(IUserView userView) {
        mUserView = userView;
        mUserModel = new UserModel();
    }

    @Override
    public void addUserSuccess() {
        Log.d(TAG, "addUserSuccess: " + Thread.currentThread().getName());
        mUserHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "mUserHandler run: " + Thread.currentThread().getName());
                mUserView.showToast("add user success");
            }
        });
    }

    @Override
    public void addUserFailed() {
        Log.d(TAG, "addUserFailed: " + Thread.currentThread().getName());
        mUserHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "mUserHandler run: " + Thread.currentThread().getName());
                mUserView.showToast("add user failed");
            }
        });
    }


    public void addUser(String userName, int age, String nickName) {
        UserBean userBean = new UserBean(UUID.randomUUID().toString(),
                userName, age, nickName);
        mUserModel.addUser(userBean, this);
    }

    public void showUserInfo(String userId) {
        UserBean userBean = mUserModel.getUser(userId);
        mUserView.updateUserNameTv(userBean.getUserName());
        mUserView.updateAgeTv(userBean.getAge());
        mUserView.updateNickNameTv(userBean.getNickName());
    }

}
