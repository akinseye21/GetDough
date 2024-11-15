package ng.com.getdough.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ng.com.getdough.R;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private int[] images;
    private String[] name;
    private int[] price;

    public GridAdapter(Context context, int[] images, String[] name, int[] price) {
        this.context = context;
        this.name = name;
        this.images = images;
        this.price = price;
    }


    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.foodImage = convertView.findViewById(R.id.image);
            viewHolder.foodName = convertView.findViewById(R.id.name);
            viewHolder.foodPrice = convertView.findViewById(R.id.price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.foodImage.setImageResource(images[position]);
        viewHolder.foodName.setText(name[position]);
        viewHolder.foodPrice.setText(String.valueOf(price[position]));

        return convertView;
    }

    static class ViewHolder {
        ImageView foodImage;
        TextView foodName;
        TextView foodPrice;
    }
}
