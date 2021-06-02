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
import dev.techasyluminfo.old_languanges.FamilyMemberActivity;
import dev.techasyluminfo.old_languanges.R;
import dev.techasyluminfo.old_languanges.Words;


public class FamilyFragment extends Fragment {

    private static final String TAG = "NumberActivity";
    private ArrayList<Words> words = new ArrayList<>();
    private MediaPlayer mediaPlayer;

    private  View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.words_list, container, false);
        //code here
        addElementToList();

        return rootView;
    }
    private void addElementToList() {
        words.add(new Words("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Words("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Words("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Words("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Words("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Words("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Words("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Words("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Words("grandmother ", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Words("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        Log.v(TAG, "onCreate:ArrayList generated");


        CutomAdapter arrayAdapter = new CutomAdapter(getActivity(), words,R.color.category_family);
        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();

                mediaPlayer= MediaPlayer.create(getActivity(),words.get(i).getmAudioResource());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();

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