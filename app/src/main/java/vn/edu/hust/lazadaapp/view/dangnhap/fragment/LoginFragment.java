package vn.edu.hust.lazadaapp.view.dangnhap.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.customview.ClearEditText;
import vn.edu.hust.lazadaapp.model.dangnhap.DangNhapModel;
import vn.edu.hust.lazadaapp.view.trangchu.MainActivity;

import static com.facebook.FacebookSdk.getApplicationContext;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button fbButton;
    private CallbackManager callbackManager;
    private ClearEditText emailEditText;
    private EditText passEditText;
    private Button loginButton;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        findView();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                LogManager.e(this, loginResult.toString());
            }

            @Override
            public void onCancel() {
                LogManager.e(this, "onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                LogManager.e(this, "onError");
            }
        });
        return view;
    }

    private void findView() {
        fbButton = view.findViewById(R.id.fbButton);
        fbButton.setOnClickListener(this);
        emailEditText = view.findViewById(R.id.emailEditText);
        passEditText = view.findViewById(R.id.passEditText);
        loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fbButton:
                LoginManager.getInstance().logInWithReadPermissions(LoginFragment.this, Arrays.asList("public_profile"));
                break;
            case R.id.loginButton:
                String name = emailEditText.getText().toString();
                String pass = passEditText.getText().toString();
                DangNhapModel dangNhapModel = DangNhapModel.getInstance();
                if (dangNhapModel.kiemTraDangNhap(getActivity(), name, pass)) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
