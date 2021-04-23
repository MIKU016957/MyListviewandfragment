package com.example.mylistview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.mylistview.Anima;

public class AnimaAdapter extends ArrayAdapter<Anima> {
    private int resourceId;

    public AnimaAdapter(Context context, int textViewResourceId, List<Anima> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Anima fruit = getItem(position); //获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.anima_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.ainmaname);
            view.setTag(viewHolder);    //将ViewHolder储存在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();     //重新获得viewHolder
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }

    //内部类
    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
