package ng.com.getdough.forgotpassword;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import ng.com.getdough.R;

public class ForgotPassword extends AppCompatActivity {

    EditText edt_email;
    ImageView check_email;
    Button btn_continue;
    Boolean fg_email = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password);

        edt_email = findViewById(R.id.email);
        check_email = findViewById(R.id.check_email);
        btn_continue = findViewById(R.id.btn_continue);

        edt_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (Patterns.EMAIL_ADDRESS.matcher(edt_email.getText().toString().trim()).matches()){
                    check_email.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(ForgotPassword.this, R.color.green)));
                    fg_email = true;
                }else{
                    check_email.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(ForgotPassword.this, R.color.grey3)));
                    fg_email = false;
                    edt_email.setError("Invalid email type");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fg_email){
                    //send a recovery email
                }
            }
        });

    }
}