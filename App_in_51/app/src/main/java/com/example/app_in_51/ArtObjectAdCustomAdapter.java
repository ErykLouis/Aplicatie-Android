package com.example.app_in_51;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ArtObjectAdCustomAdapter extends ArrayAdapter<ArtObjectAd> {

    private Context context;
    private int resourceId;
    private ArtObjectAd[] artObjectAds;
    private final String ART_OBJECT_KEY;

    public ArtObjectAdCustomAdapter(@NonNull Context context, int resource, @NonNull ArtObjectAd[] objects) {
        super(context, resource, objects);
        this.context=context;
        this.resourceId=resource;
        this.artObjectAds=objects;
        this.ART_OBJECT_KEY=context.getResources().getString(R.string.art_object_ad_key);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem=convertView;
        if(convertView==null)
        {
            listItem= LayoutInflater.from(context).inflate(R.layout.art_object_list_item,parent,false);
        }

        final ArtObjectAd artObjectAd=artObjectAds[position];
        TextView titleView=listItem.findViewById(R.id.list_item_title);
        TextView descriptionView=listItem.findViewById(R.id.list_item_description);
        ImageView imageView=listItem.findViewById(R.id.list_item_image);
        titleView.setText(artObjectAd.getTitle());
        descriptionView.setText(artObjectAd.getDescription());
        int imageId=this.context.getResources().getIdentifier(artObjectAd.getImageName(),"drawable",context.getPackageName());
        imageView.setImageResource(imageId);

        Button seeMoreButton=(Button)listItem.findViewById(R.id.see_more_button);
        seeMoreButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ArtObjectDetailActivity.class);
                intent.putExtra(ART_OBJECT_KEY,artObjectAd);
                context.startActivity(intent);
            }
        });
        return listItem;
    }
}
