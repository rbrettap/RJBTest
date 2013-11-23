package com.example.richlibrarymain;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import com.example.richlibrarymain.R;
import com.example.richlibrarytest.MainLibraryActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
        Button clickbutton = (Button)findViewById(R.id.clickbutton);
        
        clickbutton.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent= new Intent(MainActivity.this,MainLibraryActivity.class);
                startActivity(intent);
                
            }
        });
    
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
