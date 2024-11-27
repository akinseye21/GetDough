package ng.com.getdough.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ng.com.getdough.R;
import ng.com.getdough.adapter.GridAdapter;

public class HomeFragment extends Fragment {
    RelativeLayout seeall;
    LinearLayout filter;

    GridView gridView;
    private String[] name = {"Supreme Pizza", "Peperoni Pizza", "Peperoni Pizza", "Supreme Pizza", "Chicken Pizza"};
    private int[] price = {16, 18, 16, 5, 20};
    private int[] images = {
            R.drawable.supreme,
            R.drawable.peperonni,
            R.drawable.peperonni,
            R.drawable.supreme,
            R.drawable.supreme
    };


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        seeall = v.findViewById(R.id.seeall);
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the dialog
                Dialog dialog = new Dialog(getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.modal_categories);

//                ListView listView = dialog.findViewById(R.id.listView);
//                StateAdapter stateAdapter = new StateAdapter(Registration.this, arrayState, "patient", dialog);
//                listView.setAdapter(stateAdapter);

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                });
            }
        });
        filter = v.findViewById(R.id.filter);
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filter_method();
            }
        });
        gridView = v.findViewById(R.id.gridview);
        GridAdapter adapter = new GridAdapter(getContext(), images, name, price);
        gridView.setAdapter(adapter);
        setGridViewHeightBasedOnChildren(gridView, 2);

        return v;
    }

    public static void setGridViewHeightBasedOnChildren(GridView gridView, int numColumns) {
        GridAdapter adapter = (GridAdapter) gridView.getAdapter();
        if (adapter == null) {
            return;
        }

        int totalHeight = 0;
        int items = adapter.getCount();
        int rows = (int) Math.ceil((double) items / numColumns);

        for (int i = 0; i < rows; i++) {
            View listItem = adapter.getView(i, null, gridView);
            listItem.measure(0,0);
            totalHeight += listItem.getMeasuredHeight();
        }

        totalHeight += (gridView.getVerticalSpacing() * (rows - 1));

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);
        gridView.requestLayout();
    }

    private void filter_method(){
        //show the dialog
        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.modal_filter);

        HorizontalScrollView categoryView = dialog.findViewById(R.id.categoryView);
        LinearLayout sortbyView = dialog.findViewById(R.id.sortbyView);
        LinearLayout priceView = dialog.findViewById(R.id.priceView);
        LinearLayout category = dialog.findViewById(R.id.category);
        LinearLayout sortby = dialog.findViewById(R.id.sortby);
        LinearLayout price = dialog.findViewById(R.id.price);
        TextView txtcategory = dialog.findViewById(R.id.textcategory);
        TextView txtsortby = dialog.findViewById(R.id.textsortby);
        TextView txtprice = dialog.findViewById(R.id.textprice);
        View viewcategory = dialog.findViewById(R.id.viewcategory);
        View viewsortby = dialog.findViewById(R.id.viewsortby);
        View viewprice = dialog.findViewById(R.id.viewprice);

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtcategory.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
                viewcategory.setVisibility(View.VISIBLE);
                categoryView.setVisibility(View.VISIBLE);

                txtsortby.setTextColor(Color.parseColor("#172B4D"));
                viewsortby.setVisibility(View.INVISIBLE);
                sortbyView.setVisibility(View.GONE);

                txtprice.setTextColor(Color.parseColor("#172B4D"));
                viewprice.setVisibility(View.INVISIBLE);
                priceView.setVisibility(View.GONE);


            }
        });
        sortby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtsortby.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
                viewsortby.setVisibility(View.VISIBLE);
                sortbyView.setVisibility(View.VISIBLE);

                txtcategory.setTextColor(Color.parseColor("#172B4D"));
                viewcategory.setVisibility(View.INVISIBLE);
                categoryView.setVisibility(View.GONE);

                txtprice.setTextColor(Color.parseColor("#172B4D"));
                viewprice.setVisibility(View.INVISIBLE);
                priceView.setVisibility(View.GONE);


            }
        });
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtprice.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
                viewprice.setVisibility(View.VISIBLE);
                priceView.setVisibility(View.VISIBLE);

                txtcategory.setTextColor(Color.parseColor("#172B4D"));
                viewcategory.setVisibility(View.INVISIBLE);
                categoryView.setVisibility(View.GONE);

                txtsortby.setTextColor(Color.parseColor("#172B4D"));
                viewsortby.setVisibility(View.INVISIBLE);
                sortbyView.setVisibility(View.GONE);


            }
        });


        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.TOP);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        dialog.show();

    }
}