package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.wan_android.net.KnowledgeApi;
import com.example.wan_android.presenter.LoginPresenter;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    @BindView(R.id.reg_repsw)
    EditText mRegRepsw;
    @BindView(R.id.reg_repsw_wrapper)
    TextInputLayout mRegRepswWrapper;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_go_reg)
    TextView mTvGoReg;
    @BindView(R.id.login_group)
    LinearLayout mLoginGroup;
    @BindView(R.id.tv_go_login)
    TextView mTvGoLogin;
    @BindView(R.id.btn_reg)
    Button mBtnReg;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        String judge = getIntent().getStringExtra("judge");
        if (!TextUtils.isEmpty(judge)) {
            ToastUtil.showShort("请先登录");
        }
    }

    @Override
    public void onSuccess(LoginInfo bean) {
        hideLoading();
        SpUtil.setParam(Constants.USERNAME, bean.getData().getUsername());;
        SpUtil.setParam(Constants.PASSWORD, mEtPsw.getText().toString());
        SpUtil.setParam(Constants.LOGIN, true);
        Intent intent = new Intent();
        intent.putExtra("name",bean.getData().getUsername());
        setResult(ApiServer.SUCCESS_CODE,intent);
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
                mBtnLogin.setVisibility(View.VISIBLE);
                mBtnReg.setVisibility(View.GONE);
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
                mEtName.setText("");
                mEtPsw.setText("");
                mRegRepsw.setText("");
                mRegRepswWrapper.setVisibility(View.VISIBLE);
                mTvGoReg.setVisibility(View.GONE);
                mTvGoLogin.setVisibility(View.VISIBLE);
                mBtnReg.setVisibility(View.VISIBLE);
                mBtnLogin.setVisibility(View.GONE);
                break;
            case R.id.btn_reg:
                mBtnReg.setVisibility(View.VISIBLE);
                mBtnLogin.setVisibility(View.GONE);
                String regName = mEtName.getText().toString().trim();
                String regPsw = mEtPsw.getText().toString().trim();
                String regRepsw = mRegRepsw.getText().toString().trim();
                if (!TextUtils.isEmpty(regName) && !TextUtils.isEmpty(regPsw)){
                    if (regPsw.equals(regRepsw)){
                        mPresenter.register(regName,regPsw,regRepsw);
                        showLoading();
                    }else {
                        ToastUtil.showShort("两次密码输入不一致，请重新输入");
                    }
                }else {
                    ToastUtil.showShort("用户名或密码不能为空");
                }
                break;
            case R.id.tv_go_login:
                mEtName.setText("");
                mEtPsw.setText("");
                mRegRepsw.setText("");
                mRegRepswWrapper.setVisibility(View.GONE);
                mTvGoReg.setVisibility(View.VISIBLE);
                mTvGoLogin.setVisibility(View.GONE);
                mBtnReg.setVisibility(View.GONE);
                mBtnLogin.setVisibility(View.VISIBLE);
                break;
        }
    }

}
