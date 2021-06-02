package dev.techasyluminfo.old_languanges.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dev.techasyluminfo.old_languanges.ColorActivity;
import dev.techasyluminfo.old_languanges.CutomAdapter;
import dev.techasyluminfo.old_languanges.R;
import dev.techasyluminfo.old_languanges.Words;


public class ColorFragment extends Fragment {

    private static final String TAG = "NumberActivity";
    private ArrayList<Words> words = new ArrayList<>();
    private MediaPlayer mediaPlayer;


    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.words_list, container, false);

        addElementToList();

        return  rootView;
    }
    private void addElementToList() {
        words.add(new Words("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));  // resource id is of integer type
        words.add(new Words("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Words("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Words("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Words("black","kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Words("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Words("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Words("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));




        Log.v(TAG, "onCreate:ArrayList generated");


        CutomAdapter arrayAdapter = new CutomAdapter(getActivity(), words,R.color.category_colors);
        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();

                Toast.makeText(getActivity(), "item click.......", Toast.LENGTH_SHORT).show();
                mediaPlayer=MediaPlayer.create(getActivity(),words.get(i).getmAudioResource());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                        Toast.makeText(getActivity(), "it done ...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}
