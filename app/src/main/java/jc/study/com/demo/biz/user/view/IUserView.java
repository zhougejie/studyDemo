package jc.study.com.demo.biz.user.view;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/27
 */
public interface IUserView {

    void updateUserNameTv(String userName);

    void updateAgeTv(int age);

    void updateNickNameTv(String nickName);

    void showToast(String prompt);

}
