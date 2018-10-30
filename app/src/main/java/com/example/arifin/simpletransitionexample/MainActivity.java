package com.example.arifin.simpletransitionexample;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.contrain_layout);
        textView=findViewById(R.id.textView);
        relativeLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                transion();
                return true;
            }
        });
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detransion();
                return true;
            }
        });

    }

    public void transion(){
        TransitionManager.beginDelayedTransition(relativeLayout);

            //change the position of the app
            View view=findViewById(R.id.textView);
            RelativeLayout.LayoutParams positionRules= new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
            positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
            view.setLayoutParams(positionRules);

            //change the size of the app
            ViewGroup.LayoutParams sizeRules= view.getLayoutParams();
            sizeRules.height=450;
            sizeRules.width=450;
            view.setLayoutParams(sizeRules);

            //changing the text size
            textView.setTextSize(40);
            textView.setText("Click Me");

    }
    public void detransion(){
        TransitionManager.beginDelayedTransition(relativeLayout);

        //change the position of the app
        View view=findViewById(R.id.textView);
        RelativeLayout.LayoutParams positionRules= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT,RelativeLayout.TRUE);
        view.setLayoutParams(positionRules);

        //change the size of the app
        ViewGroup.LayoutParams sizeRules= view.getLayoutParams();
        sizeRules.height=450;
        sizeRules.width=450;
        view.setLayoutParams(sizeRules);

        //changing the text size
        textView.setTextSize(15);
        textView.setText("Hello World!");
        

    }


}
