package ng.com.getdough;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyEmail extends AppCompatActivity {

    ImageView back;
    String email;
    TextView txt_email;
    Button btn_check_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_verify_email);

        Intent i = getIntent();
        email = i.getStringExtra("email");
        txt_email = findViewById(R.id.txt_email);
        txt_email.setText("A mail has been sent to "+email);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_check_email = findViewById(R.id.btn_continue);
        btn_check_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VerifyEmail.this, EnterAddress.class));
            }
        });

    }
}