package jc.study.com.demo.biz.user.model;

import jc.study.com.demo.biz.user.bean.UserBean;
import jc.study.com.demo.biz.user.listener.OnAddUserListener;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/27
 */
public interface IUserModel {

    void addUser(UserBean userBean, OnAddUserListener listener);

    int alterUser(UserBean userBean);

    UserBean getUser(String userId);

    int removeUser(String userId);
}
