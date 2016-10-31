package jc.study.com.demo.biz.user.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类的描述
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/27
 */
public class UserBean implements Parcelable {

    private String userId;
    private String userName;
    private int age;
    private String nickName;

    public UserBean(String userId, String userName, int age, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.nickName = nickName;
    }

    public UserBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.userName);
        dest.writeInt(this.age);
        dest.writeString(this.nickName);
    }

    protected UserBean(Parcel in) {
        this.userId = in.readString();
        this.userName = in.readString();
        this.age = in.readInt();
        this.nickName = in.readString();
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
