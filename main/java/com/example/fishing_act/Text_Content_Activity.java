package com.example.fishing_act;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

public class Text_Content_Activity extends AppCompatActivity {
    private TextView text_content;
    private ImageView iContent;
    private int category=0;
    private int position=0;
    private int [] array_fish={R.string.fish_1,R.string.fish_2,R.string.fish_3,R.string.fish_4,R.string.fish_5};
    private int [] i_fish={R.drawable.karp,R.drawable.som,R.drawable.shuca,R.drawable.okun,R.drawable.plotva};
    private int [] pr={R.string.pr_1,R.string.pr_2,R.string.pr_3};
    private int [] i_prfish={R.drawable.blesna,R.drawable.vobler,R.drawable.vibro};
    private int [] mesto={R.string.mesto_1,R.string.mesto_2,R.string.mesto_3};
    private int [] i_mesto={R.drawable.astr,R.drawable.kar,R.drawable.ya};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageView2);
        reciveIntent();
    }
    private void reciveIntent(){
        Intent i = getIntent();
        if(i!=null){
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position",0);
        }
        switch (category){
            case 0:
                iContent.setImageResource(i_fish[position]);
                text_content.setText(array_fish[position]);
                break;
            case 1:
                iContent.setImageResource(i_prfish[position]);
                text_content.setText(pr[position]);
                break;
            case 2:
                iContent.setImageResource(i_mesto[position]);
                text_content.setText(mesto[position]);
                break;
        }
    }
}
