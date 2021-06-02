package dev.techasyluminfo.old_languanges;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;

import dev.techasyluminfo.old_languanges.Fragment.Number_Fragment;

public class NumbersActivity extends AppCompatActivity {


    private static final String TAG = "NumberActivity";
    private ArrayList<Words> words = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    // private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Number_Fragment())
                .commit();

    }

//    private void setElementOnView() {
//        for (String str:words) {
//            TextView textView=new TextView(NumbersActivity.this);
//            textView.setText(""+str);
//            textView.setPadding(0,0,0,16);
//            linearLayout.addView(textView);
//        }
//
//    }

//    private void addElementToList() {
//        words.add(new Words("one", "lutti",R.drawable.number_one, R.raw.number_one));
//        words.add(new Words("two", "otiiko", R.drawable.number_two, R.raw.number_two));
//        words.add(new Words("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
//        words.add(new Words("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
//        words.add(new Words("five","massokka", R.drawable.number_five, R.raw.number_five));
//        words.add(new Words("six", "temmokka", R.drawable.number_six, R.raw.number_six));
//        words.add(new Words("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
//        words.add(new Words("eight", "kawinta", R.drawable.number_eight,R.raw.number_eight));
//        words.add(new Words("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
//        words.add(new Words("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
//        Log.v(TAG, "onCreate:ArrayList generated");
//
//
//        CutomAdapter arrayAdapter = new CutomAdapter(this, words,R.color.category_numbers);
//        ListView listView = findViewById(R.id.list);
//
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //to release media player variable
//
//                Log.v(TAG,"First  Words "+words.get(i));
//                Log.v(TAG,"Current Words "+words.get(i).toString());
//               // Toast.makeText(NumbersActivity.this, "item click......." , Toast.LENGTH_SHORT).show();
//                mediaPlayer=MediaPlayer.create(NumbersActivity.this,words.get(i).getmAudioResource());
//                mediaPlayer.start();
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mediaPlayer) {
//                        releaseMediaPlayer();
//                        Toast.makeText(NumbersActivity.this, "it done ...", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                Toast.makeText(NumbersActivity.this, "waiting for event ", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//
//    //using onStop method
//
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        releaseMediaPlayer();
//    }
//
//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mediaPlayer = null;
//        }
//    }

}