package com.mytmmin.etravel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.mytmmin.etravel.Activity.MyTravelMainActivity;

import java.util.concurrent.TimeUnit;

import static android.view.View.GONE;

//this class is for testing the otp purposes only, not part of the mytravel feature.

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //this class is for firebase otp testing purposes only.

    Button btnGenerateOTP, btnSignIn;
    EditText etPhoneNumber, etOTP;
    String phoneNumber, otp;
    FirebaseAuth auth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    private String verificationCode;
    private PhoneAuthProvider.ForceResendingToken mToken;

    private TextInputLayout layout_fl_username, layout_fl_password, layout_mn_mobileNum, layout_otp_1, layout_otp_2, layout_otp_3, layout_otp_4, layout_otp_5, layout_otp_6;
    private TextInputEditText et_fl_username, et_fl_password, et_mn_mobileNum, et_otp_1, et_otp_2, et_otp_3, et_otp_4, et_otp_5, et_otp_6;
    private Button btnLogin, btnMobileNum, btnOtp;
    TextView tvResendOtp;

    View layout1,layout2, layout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(FirebaseAuth.getInstance().getCurrentUser() != null) FirebaseAuth.getInstance().signOut();
        findViews();
        StartFirebaseLogin();

    }

    private void signIn(){
        String otpe = et_otp_1.getText().toString()+et_otp_2.getText().toString()+et_otp_3.getText().toString()+et_otp_4.getText().toString()+et_otp_5.getText().toString()+et_otp_6.getText().toString();
//        otp=etOTP.getText().toString();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otpe);
        SigninWithPhone(credential);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.sign_in_button:
                if(et_mn_mobileNum.getText().toString().length()<1){
                    et_mn_mobileNum.setError("Phone number can't be empty!");
                    return;
                }
                else if (et_fl_username.getText().toString().length()<1){
                    et_fl_username.setError("username can't be empty!");
                    return;
                }
                else if (et_fl_password.getText().toString().length()<8){
                    et_fl_password.setError("password at least 8 characters!");
                    return;
                }
                else {
                    et_mn_mobileNum.setError(null);
                    et_fl_password.setError(null);
                    et_fl_username.setError(null);
                    layout3.animate()
                            .alpha(1.0f)
                            .setDuration(1000)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    layout2.setVisibility(View.GONE);
                                    layout1.setVisibility(View.GONE);
                                    layout3.setVisibility(View.VISIBLE);
                                }
                            });
                    reqMobileNum();
                }
                break;
            case R.id.phone_button:
                if(et_mn_mobileNum.getText().toString().length()<1){
                    layout_mn_mobileNum.setError("Phone number can't be empty!");
                    return;
                }
                else{
                    layout_mn_mobileNum.setError(null);
                    layout3.animate()
                            .alpha(1.0f)
                            .setDuration(1000)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    layout2.setVisibility(View.GONE);
                                    layout1.setVisibility(View.GONE);
                                    layout3.setVisibility(View.VISIBLE);
                                }
                            });
                    reqMobileNum();
                }
                break;
            case R.id.otp_button:
                if(et_otp_1.getText().toString().length()<1){
                    et_otp_1.setError("!");
                    return;
                }
                else if(et_otp_2.getText().toString().length()<1){
                    et_otp_2.setError("!");
                }
                else if(et_otp_3.getText().toString().length()<1){
                    et_otp_3.setError("!");
                }
                else if(et_otp_4.getText().toString().length()<1){
                    et_otp_4.setError("!");
                }
                else if(et_otp_5.getText().toString().length()<1){
                    et_otp_5.setError("!");
                }
                else if(et_otp_6.getText().toString().length()<1){
                    et_otp_6.setError("!");
                }
                else{
                    et_otp_1.setError(null);
                    et_otp_2.setError(null);
                    et_otp_3.setError(null);
                    et_otp_4.setError(null);
                    et_otp_5.setError(null);
                    et_otp_6.setError(null);
                    signIn();
                }
                break;
            case R.id.otp_resend:
                resendVerificationCode(phoneNumber, mToken);
                break;
            default:
                break;
        }
    }

    private void reqMobileNum(){
        phoneNumber = et_mn_mobileNum.getText().toString();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,                     // Phone number to verify
                60,                           // Timeout duration
                TimeUnit.SECONDS,                // Unit of timeout
                MainActivity.this,        // Activity (for callback binding)
                mCallback);

//        PhoneAuthProvider.

    }

    private void resendVerificationCode(String phoneNumber,
                                        PhoneAuthProvider.ForceResendingToken token) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallback,         // OnVerificationStateChangedCallbacks
                token);             // ForceResendingToken from callbacks
    }

    private void SigninWithPhone(final PhoneAuthCredential credential) {
        if (credential!=null){
            auth.signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent requestDetails = new Intent(MainActivity.this, MyTravelMainActivity.class);
                                if (et_fl_username.getText().toString().toUpperCase().contains("AZZAM")){
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_EMPLOYEE_NAME, "Azzam");
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_PHOTO_URL, "drawable/azzam");
                                }
                                else if (et_fl_username.getText().toString().toUpperCase().contains("KSATRIYA")){
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_EMPLOYEE_NAME, "Ksatriya");
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_PHOTO_URL, "drawable/ksatriya");
                                }
                                else if (et_fl_username.getText().toString().toUpperCase().contains("YOGA")){
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_EMPLOYEE_NAME, "Yoga");
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_PHOTO_URL, "drawable/yoga");
                                }
                                else{
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_EMPLOYEE_NAME, "Guest");
                                    requestDetails.putExtra(GlobalVariable.SERIALIZED_NAME_PHOTO_URL, "drawable/ic_person_white_24dp");
                                }

                                startActivityForResult(requestDetails, 0000);
                            } else {
                                Toast.makeText(MainActivity.this,"Incorrect OTP",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else{
        }

    }

    private void findViews() {
//        btnGenerateOTP=findViewById(R.id.btn_generate_otp);
//        btnSignIn=findViewById(R.id.btn_sign_in);
//        etPhoneNumber=findViewById(R.id.et_phone_number);
//        etOTP=findViewById(R.id.et_otp);

        layout_fl_password = findViewById(R.id.password_input_layout);
        layout_fl_username = findViewById(R.id.username_input_layout);
        et_fl_password = findViewById(R.id.password_input_edit_text);
        et_fl_username = findViewById(R.id.username_input_edit_text);
        layout_mn_mobileNum = findViewById(R.id.phone_input_layout);
        et_mn_mobileNum = findViewById(R.id.phone_input_edit_text);
        layout_otp_1 = findViewById(R.id.otp_1_layout);
        et_otp_1 = findViewById(R.id.otp_1_et);
        layout_otp_2 = findViewById(R.id.otp_2_layout);
        et_otp_2 = findViewById(R.id.otp_2_et);
        layout_otp_3 = findViewById(R.id.otp_3_layout);
        et_otp_3 = findViewById(R.id.otp_3_et);
        layout_otp_4 = findViewById(R.id.otp_4_layout);
        et_otp_4 = findViewById(R.id.otp_4_et);
        layout_otp_5 = findViewById(R.id.otp_5_layout);
        et_otp_5 = findViewById(R.id.otp_5_et);
        layout_otp_6 = findViewById(R.id.otp_6_layout);
        et_otp_6 = findViewById(R.id.otp_6_et);

        layout1 = findViewById(R.id.layout_1);
        layout2 = findViewById(R.id.layout_2);
        layout3 = findViewById(R.id.layout_3);

        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);

        btnLogin = findViewById(R.id.sign_in_button);
        btnMobileNum = findViewById(R.id.phone_button);
        btnOtp = findViewById(R.id.otp_button);

        tvResendOtp = findViewById(R.id.otp_resend);

        btnLogin.setOnClickListener(this);
        btnOtp.setOnClickListener(this);
        btnMobileNum.setOnClickListener(this);
        tvResendOtp.setOnClickListener(this);

        et_otp_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0){
                    et_otp_2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_otp_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0){
                    et_otp_3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_otp_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0){
                    et_otp_4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_otp_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0){
                    et_otp_5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_otp_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>0){
                    et_otp_6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void StartFirebaseLogin() {
        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                Toast.makeText(MainActivity.this,"verification completed",Toast.LENGTH_SHORT).show();
                String otp = phoneAuthCredential.getSmsCode();
                if(phoneAuthCredential.getSmsCode() != null){
                    if(!phoneAuthCredential.getSmsCode().isEmpty()){
                        et_otp_1.setText(otp.substring(0,1));
                        et_otp_2.setText(otp.substring(1,2));
                        et_otp_3.setText(otp.substring(2,3));
                        et_otp_4.setText(otp.substring(3,4));
                        et_otp_5.setText(otp.substring(4,5));
                        et_otp_6.setText(otp.substring(5,6));
                        et_otp_6.clearFocus();
                    }
                    else{
                        et_otp_1.setText("X");
                        et_otp_2.setText("X");
                        et_otp_3.setText("X");
                        et_otp_4.setText("X");
                        et_otp_5.setText("X");
                        et_otp_6.setText("X");
                        et_otp_6.clearFocus();
                    }

                }
                else{
                    et_otp_1.setText("X");
                    et_otp_2.setText("X");
                    et_otp_3.setText("X");
                    et_otp_4.setText("X");
                    et_otp_5.setText("X");
                    et_otp_6.setText("X");
                    et_otp_6.clearFocus();
                }

                btnOtp.setClickable(false);

//                new CountDownTimer(2000, 1000) {
//
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//                }.start();

                SigninWithPhone(phoneAuthCredential);

            }
            @Override
            public void onVerificationFailed(FirebaseException e) {
//                Toast.makeText(MainActivity.this,"verification fialed",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                super.onCodeSent(verificationId, token);
                mToken = token;
                verificationCode = verificationId;

//                Toast.makeText(MainActivity.this,"Code sent - "+verificationId,Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0000 && resultCode == RESULT_OK){
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(GONE);
            layout3.setVisibility(GONE);

            et_fl_password.setText(null);
            et_fl_username.setText(null);
            et_mn_mobileNum.setText(null);
            et_otp_1.setText(null);
            et_otp_2.setText(null);
            et_otp_3.setText(null);
            et_otp_4.setText(null);
            et_otp_5.setText(null);
            et_otp_6.setText(null);
        }
    }
}