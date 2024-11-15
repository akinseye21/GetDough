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
    private String[] name = {"Supreme Pizza", "Peperoni Pizza", "Supreme Pizza", "Peperoni Pizza"};
    private int[] price = {16, 18, 16, 5};
    private int[] images = {
            R.drawable.supreme,
            R.drawable.peperonni,
            R.drawable.supreme,
            R.drawable.peperonni
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

        return v;
    }
}