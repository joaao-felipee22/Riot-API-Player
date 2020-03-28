package com.example.riotapi.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.riotapi.R;
import com.example.riotapi.viewmodel.PlayerViewModel;
import com.squareup.picasso.Picasso;

import static com.example.riotapi.model.ServiceRetrofit.API_KEY;
import static com.example.riotapi.model.ServiceRetrofit.BASE_URL_IMAGE;
import static com.example.riotapi.view.MainActivity.PLAYER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment {

    TextView name, level;
    ImageView imgIcon;
    ProgressBar progressBar;
    PlayerViewModel viewModel;

    public PlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_player, container, false);
            initViews(view);
            if(getArguments() != null) {
                Bundle bundle = getArguments();
                viewModel.getPlayerFull(bundle.getString(PLAYER_KEY), API_KEY);
                searchEnginePlayer();
            }
            loading();
            return view;
    }

    private void searchEnginePlayer(){
        viewModel.playerResponseLiveData.observe(this, playerResponse -> {
            name.setText(playerResponse.getName());
            level.setText(String.valueOf(playerResponse.getSummonerLevel()));
            String baseImage = BASE_URL_IMAGE + playerResponse.getProfileIconId() + ".png";
            Log.i("ICON-ID", "MESSAGE --> " + playerResponse.getProfileIconId());
            Picasso.get().load(baseImage).into(imgIcon);
        });
    }
     private void loading(){
        viewModel.booleanLiveData.observe(this, aBoolean -> {
            if(aBoolean){
                progressBar.setVisibility(View.VISIBLE);
            }else {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
    private void initViews(View view){
        name = view.findViewById(R.id.text_name);
        level = view.findViewById(R.id.player_level);
        imgIcon = view.findViewById(R.id.img_icon);
        progressBar = view.findViewById(R.id.loading_id);
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
    }
}
