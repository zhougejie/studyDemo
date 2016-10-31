package jc.study.com.demo.biz.user.model.impl;

import jc.study.com.demo.biz.user.bean.UserBean;
import jc.study.com.demo.biz.user.listener.OnAddUserListener;
import jc.study.com.demo.biz.user.model.IUserModel;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/27
 */
public class UserModel implements IUserModel {



    @Override
    public void addUser(final UserBean userBean, final OnAddUserListener listener) {
        // transfer data to server.
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("123".equals(userBean.getUserId())) {
                    listener.addUserSuccess();
                } else {
                    listener.addUserFailed();
                }
            }
        }.start();

    }

    @Override
    public int alterUser(UserBean userBean) {
        return 0;
    }

    @Override
    public UserBean getUser(String userId) {
        UserBean userBean = new UserBean("test_user_id_007", "my_user_id", 19, "my_nick_name");
        return userBean;
    }

    @Override
    public int removeUser(String userId) {
        return 0;
    }
}
