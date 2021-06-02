package dev.techasyluminfo.old_languanges;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class CutomAdapter extends ArrayAdapter<Words>  {

    private int mColorResourceId;
    private  Context mComtext;
    public CutomAdapter(@NonNull Context context, @NonNull ArrayList<Words> wordsArrayList) {


        super(context, 0, wordsArrayList);


    }
    public CutomAdapter(@NonNull Context context, @NonNull ArrayList<Words> wordsArrayList,int colorResourceId) {


        super(context, 0, wordsArrayList);
        this.mComtext=context;
        this.mColorResourceId=colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Words currentWordsItem=getItem(position);

        View listItemView=convertView;

        if (listItemView==null){
            listItemView=LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);

        }
        LinearLayout linearLayout=listItemView.findViewById(R.id.linear_layout_item);
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        linearLayout.setBackgroundColor(color);
        TextView englishTextView=listItemView.findViewById(R.id.english_textView);

        englishTextView.setText(currentWordsItem.getmEnglish());
        TextView miwokTextView=listItemView.findViewById(R.id.miwok_textView);
        miwokTextView.setText(currentWordsItem.getmMiwok());

        ImageView iconImageView=listItemView.findViewById(R.id.icon_imageView);
        if(currentWordsItem.hasImage()){
            iconImageView.setVisibility(View.GONE);
        }
        else {
            iconImageView.setImageResource(currentWordsItem.getmImageResource());
            iconImageView.setVisibility(View.VISIBLE);
        }



        return listItemView;
    }
}
