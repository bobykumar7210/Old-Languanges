package dev.techasyluminfo.old_languanges;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dev.techasyluminfo.old_languanges.Fragment.FamilyFragment;

public class PhrasesActivity extends AppCompatActivity {

    private static final String TAG = "PhrasesActivity";
    private ArrayList<Words> words = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    // private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new FamilyFragment())
                .commit();


    }



}