package com.example.wan_android.ui.activity;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.LoginInfo;
import com.example.wan_android.net.ApiServer;
import com.example.wan_android.presenter.LoginPresenter;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_name_wrapper)
    TextInputLayout mEtNameWrapper;
    @BindView(R.id.et_psw)
    EditText mEtPsw;
    @BindView(R.id.et_psw_wrapper)
    TextInputLayout mEtPswWrapper;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_go_reg)
    TextView mTvGoReg;
    @BindView(R.id.login_group)
    LinearLayout mLoginGroup;
    @BindView(R.id.reg_name)
    EditText mRegName;
    @BindView(R.id.reg_name_wrapper)
    TextInputLayout mRegNameWrapper;
    @BindView(R.id.reg_psw)
    EditText mRegPsw;
    @BindView(R.id.reg_psw_wrapper)
    TextInputLayout mRegPswWrapper;
    @BindView(R.id.reg_repsw)
    EditText mRegRepsw;
    @BindView(R.id.reg_repsw_wrapper)
    TextInputLayout mRegRepswWrapper;
    @BindView(R.id.btn_reg)
    Button mBtnReg;
    @BindView(R.id.tv_go_login)
    TextView mTvGoLogin;
    @BindView(R.id.reg_group)
    LinearLayout mRegGroup;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(LoginInfo bean) {
        hideLoading();
        //保存用户信息，并将登录状态标记为已登录
        SpUtil.setParam(Constants.USERNAME, bean.getData().getUsername());
        SpUtil.setParam(Constants.TOKEN, bean.getData().getId());
        SpUtil.setParam(Constants.LOGIN, true);
        setResult(ApiServer.SUCCESS_CODE);
        finish();
    }

    @Override
    public void onFail(String msg) {

    }

    @OnClick({R.id.btn_login, R.id.tv_go_reg, R.id.btn_reg, R.id.tv_go_login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                String name = mEtName.getText().toString().trim();
                String psw = mEtPsw.getText().toString().trim();
               
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(psw)) {
                    mPresenter.login(name, psw);

                    showLoading();
               
                } else {
                    ToastUtil.showShort("用户名或密码不能为空");
                }
                break;
            case R.id.tv_go_reg:
                mLoginGroup.setVisibility(View.GONE);
                mRegGroup.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_reg:
                String regName = mRegName.getText().toString().trim();
                String regPsw = mRegPsw.getText().toString().trim();
                String regRepsw = mRegRepsw.getText().toString().trim();

                if (!TextUtils.isEmpty(regName) && !TextUtils.isEmpty(regPsw)) {
                    if (regPsw.equals(regRepsw)) {
                        mPresenter.register(regName, regPsw, regRepsw);
                        showLoading();
                   
                    } else {
                        ToastUtil.showShort("两次密码输入不一致，请重新输入");
                    }
               
                } else {
                    ToastUtil.showShort("用户名或密码不能为空");
                }
                break;
            case R.id.tv_go_login:
                mLoginGroup.setVisibility(View.VISIBLE);
                mRegGroup.setVisibility(View.GONE);
                break;
        }
    }
}
