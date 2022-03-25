package com.nesting_india_property.property.Fragments;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nesting_india_property.property.R;
import com.github.chrisbanes.photoview.PhotoView;


public class PicZoomFragment extends Fragment {

    String getimg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pic_zoom, container, false);

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("Property Image");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });




        Bundle bundle = this.getArguments();

        if(bundle != null){
            getimg = bundle.getString("img");
        }

        PhotoView photoView = (PhotoView) v.findViewById(R.id.photo_view);


//        if (getimg.length() > 80){
//            Glide.with(PicZoomFragment.this).load(getimg).into(photoView);
//        }else{
//            Glide.with(PicZoomFragment.this).load(R.drawable.nopropertyimage).into(photoView);
//        }


        Glide.with(getContext())
                .load(getimg)
                .apply(RequestOptions
                        .placeholderOf(R.drawable.nopropertyimage)
                        .dontAnimate()
                        .error(R.drawable.nopropertyimage))
                .into(photoView);




        return v;
    }

}