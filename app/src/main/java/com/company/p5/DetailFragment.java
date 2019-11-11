package com.company.p5;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;


public class DetailFragment extends Fragment {


    public DetailFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel mainViewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);

        final Item item = mainViewModel.itemList.get(mainViewModel.selectedItem);

        TextView textViewName = view.findViewById(R.id.name);
        TextView textViewDesc = view.findViewById(R.id.desc);
        RatingBar ratingBar = view.findViewById(R.id.rating);

        textViewName.setText(item.name);
        textViewDesc.setText(item.desc);
        ratingBar.setRating(item.rating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                item.rating = v;
            }
        });
    }
}
