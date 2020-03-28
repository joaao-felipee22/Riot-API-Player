package com.example.riotapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.riotapi.R;

public class MainActivity extends AppCompatActivity {

    public static final String PLAYER_KEY = "PLAYER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView searchView = findViewById(R.id.search_id);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Bundle bundle = new Bundle();
                bundle.putString(PLAYER_KEY, s);
                PlayerFragment playerFragment = new PlayerFragment();
                playerFragment.setArguments(bundle);
                replaceFragment(playerFragment);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.contaiter_id, fragment).commit();
    }

}
