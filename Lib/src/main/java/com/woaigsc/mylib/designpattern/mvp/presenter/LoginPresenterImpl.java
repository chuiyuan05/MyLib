package com.woaigsc.mylib.designpattern.mvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.woaigsc.mylib.designpattern.mvp.model.IUser;
import com.woaigsc.mylib.designpattern.mvp.model.UserModel;
import com.woaigsc.mylib.designpattern.mvp.view.ILoginView;

/**
 * Created by chuiyuan on 16-5-19.
 */
public class LoginPresenterImpl implements ILoginPresenter {
    ILoginView iLoginView ;//View
    IUser user ;//Model
    Handler handler ;//To communicate with View(Activity)

    public LoginPresenterImpl(ILoginView iLoginView){
        this.iLoginView = iLoginView ;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        final boolean isLoginSuccess = user.checkUserValidity(name, passwd);
        //Call View in Main thread.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(isLoginSuccess);
            }
        }, 2000);
    }

    @Override
    public void setProgressBarVisible(int visible) {
        iLoginView.onSetProgressBarVisible(visible);
    }

    private void initUser(){
        user = new UserModel("mvp","mvp");
    }
}
