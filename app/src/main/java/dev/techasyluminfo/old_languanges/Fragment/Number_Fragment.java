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

import dev.techasyluminfo.old_languanges.CutomAdapter;
import dev.techasyluminfo.old_languanges.R;
import dev.techasyluminfo.old_languanges.Words;


public class Number_Fragment extends Fragment {
    private static final String TAG = "NumberActivity";
    private ArrayList<Words> words = new ArrayList<>();
    private MediaPlayer mediaPlayer;

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.words_list, container, false);

        addElementToList();


        return rootView;
    }

    private void addElementToList() {
        words.add(new Words("one", "lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new Words("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Words("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Words("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Words("five","massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Words("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Words("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Words("eight", "kawinta", R.drawable.number_eight,R.raw.number_eight));
        words.add(new Words("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Words("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
        Log.v(TAG, "onCreate:ArrayList generated");


        CutomAdapter arrayAdapter = new CutomAdapter(getActivity(), words,R.color.category_numbers);
        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //to release media player variable
                releaseMediaPlayer();

                Log.v(TAG,"First  Words "+words.get(i));
                Log.v(TAG,"Current Words "+words.get(i).toString());
                // Toast.makeText(NumbersActivity.this, "item click......." , Toast.LENGTH_SHORT).show();
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


    //using onStop method


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