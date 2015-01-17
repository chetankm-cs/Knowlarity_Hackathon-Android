package com.api_hackathon.app.views;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.api_hackathon.app.R;
import com.api_hackathon.app.animations.BasicAnimations;
import com.api_hackathon.app.utils.ContactList;

import java.util.List;
import java.util.Random;

/**
 * Created by USER on 6/1/15.
 */
public class PhoneBookAdapter extends ArrayAdapter<ContactList> {
    private LayoutInflater inflater;
    private Context context;
    private BasicAnimations basicAnimations;

    public PhoneBookAdapter(Context context, List<ContactList> peopleInfoList) {

        super(context, android.R.layout.simple_list_item_1, peopleInfoList);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        basicAnimations = new BasicAnimations(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        final ContactList itemCurrent = getItem(position);
        if (convertView == null) {
            holder = new Holder();
            convertView = inflater.inflate(R.layout.contact_row, null);
            holder.name = (TextView) convertView.findViewById(R.id.contact_name_check);
            holder.initial = (TextView) convertView.findViewById(R.id.initial_text_view);
            holder.phone = (TextView) convertView.findViewById(R.id.contact_number_text_view);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.name.setText(itemCurrent.getName());
        holder.phone.setText(itemCurrent.getPhone());



        holder.initial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView)v;
                textView.startAnimation(basicAnimations.zoomIn);
                itemCurrent.setSelected(!itemCurrent.isSelected());
                if(!itemCurrent.isSelected()) {
                    holder.initial.setBackgroundResource(R.drawable.circle_background);
                    LayerDrawable bgDrawable = (LayerDrawable)holder.initial.getBackground();
                    final GradientDrawable shape = (GradientDrawable)   bgDrawable.findDrawableByLayerId(R.id.shape_id);
                    shape.setColor(context.getResources().getColor(setColor()));
                    holder.initial.setText("" + itemCurrent.getName().charAt(0));
                }else{
                    holder.initial.setBackgroundResource(R.drawable.tick);
                    holder.initial.setText("");
                }
            }
        });
        if(!itemCurrent.isSelected()) {
            holder.initial.setBackgroundResource(R.drawable.circle_background);
            LayerDrawable bgDrawable = (LayerDrawable)holder.initial.getBackground();
            final GradientDrawable shape = (GradientDrawable)   bgDrawable.findDrawableByLayerId(R.id.shape_id);
            shape.setColor(context.getResources().getColor(setColor()));
            holder.initial.setText(""+itemCurrent.getName().charAt(0));
        }else{
            holder.initial.setBackgroundResource(R.drawable.tick);
            holder.initial.setText("");
        }
        return convertView;
    }

    static class Holder {
        TextView phone, initial,name;
    }

    private int setColor(){
        Random random = new Random();
        switch (random.nextInt(10)){
            case 1:{
                return R.color.red;
            }
            case 2:{
                return R.color.blue;
            }
            case 3:{
                return R.color.green;
            }
            case 4:{
                return R.color.yellow;
            }
            case 5:{
                return R.color.green_bright;
            }
            case 6:{
                return R.color.cyan;
            }
            case 7:{
                return R.color.cyan_green;
            }
            case 8:{
                return R.color.pink;
            }
            case 9:{
                return R.color.purple;
            }
            case 10:{
                return R.color.orange;
            }
        }
        return R.color.red;
    }
}