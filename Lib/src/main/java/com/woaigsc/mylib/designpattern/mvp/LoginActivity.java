package com.woaigsc.mylib.designpattern.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.designpattern.mvp.presenter.ILoginPresenter;
import com.woaigsc.mylib.designpattern.mvp.presenter.LoginPresenterImpl;
import com.woaigsc.mylib.designpattern.mvp.view.ILoginView;

/**
 * Created by chuiyuan on 16-5-19.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView{

    private EditText mEtUser ;
    private EditText mEtPasswd;
    private Button mBtnLogin ;
    private Button mBtnClear;
    private ILoginPresenter mLoginPresenter;
    private ProgressBar mProgressBar ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylib_login);

        mEtUser = (EditText)findViewById(R.id.et_login_username);
        mEtPasswd = (EditText)findViewById(R.id.et_login_password);
        mBtnLogin = (Button)findViewById(R.id.btn_login_login);
        mBtnClear = (Button)findViewById(R.id.btn_login_clear);
        mProgressBar = (ProgressBar)findViewById(R.id.progress_login);

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.clear();
            }
        });
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.setProgressBarVisible(View.VISIBLE);
                mBtnLogin.setEnabled(false);
                mBtnLogin.setEnabled(false);
                mLoginPresenter.doLogin(
                        mEtUser.getText().toString(),
                        mEtPasswd.getText().toString());
            }
        });

        mLoginPresenter = new LoginPresenterImpl(this);
        mLoginPresenter.setProgressBarVisible(View.INVISIBLE);
    }

    @Override
    public void onClearText() {
        mEtPasswd.setText("");
        mEtUser.setText("");
    }

    @Override
    public void onLoginResult(boolean result) {
        mLoginPresenter.setProgressBarVisible(View.INVISIBLE);
        mBtnLogin.setEnabled(true);
        mBtnLogin.setEnabled(true);
        if(result){
            Toast.makeText(this,"Login ok", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressBarVisible(int visible) {
        mProgressBar.setVisibility(visible);
    }
}
