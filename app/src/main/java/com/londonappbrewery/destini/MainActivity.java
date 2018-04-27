package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton,mBottomButton;

    StoryAnswers[] mStoryAnswers=new StoryAnswers[]{
            new StoryAnswers(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2),
            new StoryAnswers(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2),
            new StoryAnswers(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2),
    };

    int mIndex=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            mIndex=savedInstanceState.getInt("StoryIndex");
        }else{
            mIndex=0;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
         mStoryTextView=findViewById(R.id.storyTextView);
         mTopButton=findViewById(R.id.buttonTop);
         mBottomButton=findViewById(R.id.buttonBottom);

        mStoryTextView.setText(mStoryAnswers[mIndex].getStory());
        mTopButton.setText(mStoryAnswers[mIndex].getAnswer1());
        mBottomButton.setText(mStoryAnswers[mIndex].getAnswer2());

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory("Top");
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory("Bottom");
            }
        });

    }

    private void updateStory(String button ){
        if(button=="Top"){
            if(mIndex==2){
                mStoryTextView.setText(R.string.T6_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                return;
            }

            mIndex=2;
            mStoryTextView.setText(mStoryAnswers[mIndex].getStory());
            mTopButton.setText(mStoryAnswers[mIndex].getAnswer1());
            mBottomButton.setText(mStoryAnswers[mIndex].getAnswer2());

        }else{
            if(mIndex==1){
                mStoryTextView.setText(R.string.T4_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                return;
            }else if(mIndex==2){
                mStoryTextView.setText(R.string.T5_End);
                mTopButton.setVisibility(View.INVISIBLE);
                mBottomButton.setVisibility(View.INVISIBLE);
                return;
            }

            mIndex=1;
            mStoryTextView.setText(mStoryAnswers[mIndex].getStory());
            mTopButton.setText(mStoryAnswers[mIndex].getAnswer1());
            mBottomButton.setText(mStoryAnswers[mIndex].getAnswer2());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex",mIndex);
    }
}
