package vn.edu.hust.lazadaapp.view.dangnhap.dangky;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.customview.ClearEditText;
import vn.edu.hust.lazadaapp.model.entity.NhanVien;
import vn.edu.hust.lazadaapp.presenter.dangki.DangKyPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DangKyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DangKyFragment extends Fragment implements DangKyView, View.OnClickListener, SwitchCompat.OnCheckedChangeListener {

    private View view;
    private DangKyPresenter presenter;

    private ClearEditText nameEditText;
    private ClearEditText emailEditText;
    private EditText passEditText;
    private EditText repeatEditText;

    private TextInputLayout nameLayout;
    private TextInputLayout emailLayout;
    private TextInputLayout passLayout;
    private TextInputLayout repeatLayout;

    private SwitchCompat mSwitch;
    private Button registerButton;
    private NhanVien nhanVien;
    private String emailDocQuyen = "false";
//    private Boolean kiemtrathongtin=false;


    public DangKyFragment() {
        // Required empty public constructor
    }

    public static DangKyFragment newInstance() {
        DangKyFragment fragment = new DangKyFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new DangKyPresenter(this);
        view = inflater.inflate(R.layout.fragment_register, container, false);
        initView();
        return view;
    }

    private void initView() {
        nameEditText = view.findViewById(R.id.nameEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        passEditText = view.findViewById(R.id.passEditText);
        repeatEditText = view.findViewById(R.id.repeatEditText);
        mSwitch = view.findViewById(R.id.mSwitch);
        registerButton = view.findViewById(R.id.registerButton);
        nameLayout = view.findViewById(R.id.nameLayout);
        emailLayout = view.findViewById(R.id.emailLayout);
        passLayout = view.findViewById(R.id.passLayout);
        repeatLayout = view.findViewById(R.id.repeatLayout);

        nameEditText.addTextChangedListener(new CustomTextWatcher(nameEditText));
        emailEditText.addTextChangedListener(new CustomTextWatcher(emailEditText));
        passEditText.addTextChangedListener(new CustomTextWatcher(passEditText));
        repeatEditText.addTextChangedListener(new CustomTextWatcher(repeatEditText));
        mSwitch.setOnCheckedChangeListener(this);
        registerButton.setOnClickListener(this);

    }

    @Override
    public void dangKyThanhCong() {
        Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dangKyThatBai() {
        Toast.makeText(getActivity(), "fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerButton:
                dangKy();
                break;
        }
    }

    private void dangKy() {
        String ten = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passEditText.getText().toString();
        String repeate = repeatEditText.getText().toString();
        if (ten.trim().equals("")) {
            nameLayout.setErrorEnabled(true);
            nameLayout.setError("Mục này còn thiếu");
        } else if (email.trim().equals("")) {
            emailLayout.setErrorEnabled(true);
            emailLayout.setError("Mục này còn thiếu");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLayout.setErrorEnabled(true);
            emailLayout.setError("Email không hợp lệ");
        } else if (password.trim().equals("")) {
            passLayout.setErrorEnabled(true);
            passLayout.setError("Mục này còn thiếu");
        } else if (!repeate.trim().equals(password)) {
            repeatLayout.setErrorEnabled(true);
            repeatLayout.setError("Mật khẩu không trùng khớp");
        } else {
            nhanVien = new NhanVien(ten, email, password, 2, emailDocQuyen);
            presenter.dangKyThanhVien(nhanVien);
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.mSwitch:
                emailDocQuyen = String.valueOf(isChecked);
                break;
        }
    }

    private class CustomTextWatcher implements TextWatcher {
        private EditText mEditText;

        public CustomTextWatcher(EditText e) {
            mEditText = e;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            String name = mEditText.getText().toString();

            if (nameEditText.getText().hashCode() == s.hashCode()) {
                if (name.trim().equals("")) {
                    nameLayout.setErrorEnabled(true);
                    nameLayout.setError("Mục này còn thiếu");
                    LogManager.e(this, "1");
                } else {
                    nameLayout.setErrorEnabled(false);
                    LogManager.e(this, "2");
                }
            } else if (emailEditText.getText().hashCode() == s.hashCode()) {
                if (name.trim().equals("")) {
                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("Mục này còn thiếu");
                } else {
                    emailLayout.setErrorEnabled(false);
                }
            } else if (passEditText.getText().hashCode() == s.hashCode()) {
                if (name.trim().equals("")) {
                    passLayout.setErrorEnabled(true);
                    passLayout.setError("Mục này còn thiếu");
                } else {
                    passLayout.setErrorEnabled(false);
                }
            } else if (repeatEditText.getText().hashCode() == s.hashCode()) {
                if (name.trim().equals("")) {
                    repeatLayout.setErrorEnabled(true);
                    repeatLayout.setError("Mục này còn thiếu");
                } else {
                    repeatLayout.setErrorEnabled(false);
                }
            }
        }
    }


}
