package ng.com.getdough;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

import ng.com.getdough.adapter.SliderAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private SliderAdapter sliderAdapter;
    Timer timer;
    int Counter = 0;
    private ImageView[] mDots;
    private LinearLayout mDotLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        sliderAdapter = new SliderAdapter(MainActivity.this);
        mSlideViewPager = findViewById(R.id.slider);
        mSlideViewPager.setAdapter(sliderAdapter);
        mDotLayout = findViewById(R.id.dotsLayout);
        //adding timer for the images
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                mSlideViewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        mSlideViewPager.setCurrentItem((mSlideViewPager.getCurrentItem()+1)%4);
                        Counter = Counter + 1;
                        if (Counter == 4){
                            Counter = 0;
                        }
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 4000, 4000);
        addDotIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotIndicator(int position){

        mDots = new ImageView[4];
        mDotLayout.removeAllViews();

        for (int i = 0; i<4; i++){
            mDots[i] = new ImageView(this);
            mDots[i].setImageResource(R.drawable.circle2);

            int desiredWidthInDp = 20;
            int desiredHeightInDp = 10;
            // Convert dp to pixels
            float scale = getResources().getDisplayMetrics().density;
            int desiredWidthInPx = (int) (desiredWidthInDp * scale + 0.5f);
            int desiredHeightInPx = (int) (desiredHeightInDp * scale + 0.5f);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(desiredWidthInPx, desiredHeightInPx);
            mDots[i].setLayoutParams(layoutParams);

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){

            mDots[position].setImageResource(R.drawable.circle1);

        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 2) { // Third slide

            } else {

            }
            addDotIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skip(View view) {
        startActivity(new Intent(MainActivity.this, LoginSignup.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}