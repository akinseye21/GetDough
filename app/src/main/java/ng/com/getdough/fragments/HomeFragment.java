package ng.com.getdough.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import ng.com.getdough.R;
import ng.com.getdough.adapter.GridAdapter;

public class HomeFragment extends Fragment {

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
}