package ng.com.getdough.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import ng.com.getdough.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    private int[] slides_images = {
            R.drawable.splash1,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4
    };

    private String[] slide_text1 = {
            "Welcome to Get Dough.\nWhere cravings meet convenience!",
            "",
            "",
            ""
    };

    private String[] slide_text2 = {
            "",
            "Food variety",
            "Quick Delivery",
            "Secure payment options"
    };

    private String[] slide_text3 = {
            "Dive in and discover your next favorite treat,\ndelivered fast and fresh!",
            "Explore a world of flavors with our diverse\nmenu, from classic favorites to exciting new\ntreats.",
            "Get your cravings satisfied in no time with\nour fast and reliable delivery – fresh and\ndelicious, right to your door!",
            "Shop with confidence! Our secure payment\noptions ensure a smooth, safe, and worry-\nfree checkout every time."
    };

    @Override
    public int getCount() {
        return slides_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView image = view.findViewById(R.id.image);
        TextView text1 = view.findViewById(R.id.text1);
        TextView text2 = view.findViewById(R.id.text2);
        TextView text3 = view.findViewById(R.id.text3);


        image.setImageResource(slides_images[position]);
        text1.setText(slide_text1[position]);
        text2.setText(slide_text2[position]);
        text3.setText(slide_text3[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);

    }
}
