package ng.com.getdough.registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import ng.com.getdough.R;
import ng.com.getdough.forgotpassword.ForgotPassword;

public class Registration extends AppCompatActivity {
    ImageView topIcon, back;
    TextView txtCreateAccount, txtLogin;
    View viewCreateAccount, viewLogin;
    LinearLayout layoutCreateAccount, layoutLogin;

    EditText edt_fullname, edt_email1, edt_password1, edt_phone, edt_address;
    Button btn_continue;
    RelativeLayout btn_signin_google;
    Boolean reg_name = false, reg_email = false, reg_pass = false, reg_phone = false, reg_address = false;
    Boolean login_email = false, login_pass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        topIcon = findViewById(R.id.top_icon);
        txtCreateAccount = findViewById(R.id.txt_create_account);
        txtLogin = findViewById(R.id.txt_login);
        viewCreateAccount = findViewById(R.id.view_create_account);
        viewLogin = findViewById(R.id.view_login);
        layoutCreateAccount = findViewById(R.id.layout_create_account);
        layoutLogin = findViewById(R.id.layout_login);

        edt_fullname = findViewById(R.id.edt_fullname);
        edt_email1 = findViewById(R.id.edt_email1);
        edt_password1 = findViewById(R.id.edt_password1);
        edt_phone = findViewById(R.id.edt_phone);
        edt_address = findViewById(R.id.edt_address);
        btn_continue = findViewById(R.id.btn_continue);
        btn_signin_google = findViewById(R.id.signin_google);

        edt_fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_fullname.getText().toString().length()>=4){
                    reg_name = true;
                }else{
                    reg_name = false;
                    edt_fullname.setError("Input must be more than 3 characters");
                }
                check();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_email1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (Patterns.EMAIL_ADDRESS.matcher(edt_email1.getText().toString().trim()).matches()){
                    reg_email = true;
                }else{
                    reg_email = false;
                    edt_email1.setError("Invalid email type");
                }
                check();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_password1.getText().toString().length()>5){
                    reg_pass = true;
                }else{
                    reg_pass = false;
                    edt_password1.setError("Password must be more than 6 characters");
                }
                check();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_phone.getText().toString().length()>10){
                    reg_phone = true;
                }else{
                    edt_phone.setError("Wrong phone number");
                    reg_phone = false;
                }
                check();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_address.getText().toString().length()>=8){
                    reg_address = true;
                }else{
                    reg_address = false;
                    edt_address.setError("Address length must be more than 7 characters");
                }
                check();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        txtCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

    }

    private void check() {
        if (reg_name && reg_email && reg_pass && reg_phone && reg_address){
            btn_continue.setBackground(ContextCompat.getDrawable(Registration.this, R.drawable.button_blue));
            btn_continue.setTextColor(ContextCompat.getColor(this, R.color.white));
            btn_continue.setClickable(true);
            btn_continue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Registration.this, VerifyEmail.class).putExtra("email", edt_email1.getText().toString().trim()));
                }
            });

        }else{
            btn_continue.setBackground(ContextCompat.getDrawable(Registration.this, R.drawable.button_grey));
            btn_continue.setClickable(false);
        }
    }
    private void check2(Button login, RelativeLayout login_google) {
        if (login_email && login_pass){
            login.setBackground(ContextCompat.getDrawable(Registration.this, R.drawable.button_blue));
            login.setTextColor(ContextCompat.getColor(this, R.color.white));
            login.setClickable(true);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //show dialog for login
                }
            });

        }else{
            login.setBackground(ContextCompat.getDrawable(Registration.this, R.drawable.button_grey));
            login.setClickable(false);
        }
    }


    @SuppressLint("ResourceAsColor")
    private void CreateAccount() {
        topIcon.setImageResource(R.drawable.burger);
        viewCreateAccount.setVisibility(View.VISIBLE);
        viewLogin.setVisibility(View.INVISIBLE);
        txtCreateAccount.setTextColor(ContextCompat.getColor(this, R.color.blue));
        txtLogin.setTextColor(ContextCompat.getColor(this, R.color.grey));
        layoutCreateAccount.setVisibility(View.VISIBLE);
        layoutLogin.setVisibility(View.GONE);
    }

    @SuppressLint("ResourceAsColor")
    private void Login() {
        topIcon.setImageResource(R.drawable.ico);
        viewCreateAccount.setVisibility(View.INVISIBLE);
        viewLogin.setVisibility(View.VISIBLE);
        txtCreateAccount.setTextColor(ContextCompat.getColor(this, R.color.grey));
        txtLogin.setTextColor(ContextCompat.getColor(this, R.color.blue));
        layoutCreateAccount.setVisibility(View.GONE);
        layoutLogin.setVisibility(View.VISIBLE);


        EditText edt_email2 = findViewById(R.id.login_email);
        EditText edt_password2 = findViewById(R.id.login_password);
        TextView txt_forgot = findViewById(R.id.forgot_password);
        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, ForgotPassword.class));
            }
        });
        Button btn_login = findViewById(R.id.btn_login);
        RelativeLayout btn_login_google = findViewById(R.id.btn_login_google);

        edt_email2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (Patterns.EMAIL_ADDRESS.matcher(edt_email2.getText().toString().trim()).matches()){
                    login_email = true;
                }else{
                    login_email = false;
                    edt_email2.setError("Invalid email type");
                }
                check2(btn_login, btn_login_google);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_password2.getText().toString().length()>5){
                    login_pass = true;
                }else{
                    login_pass = false;
                    edt_password2.setError("Password must be more than 6 characters");
                }
                check2(btn_login, btn_login_google);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }
}