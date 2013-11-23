
package com.example.richlibrarytest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainLibraryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Context mContext = this.getApplicationContext();
        int id = getResourceIdByName(mContext.getPackageName(), "layout", "activity_main_library");
        setContentView(id);
        
       /* 
       final RelativeLayout mediacontrollerLayout = new RelativeLayout(this);
        
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        mediacontrollerLayout.setLayoutParams(rlp);

        ImageButton pauseButton = new ImageButton(this);
        pauseButton.setImageDrawable(getResources().getDrawable(R.drawable.play_button));
        
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
       
        ((ViewGroup) mediacontrollerLayout).addView(pauseButton);
        */
        
        
       final RelativeLayout layout = new RelativeLayout(MainLibraryActivity.this.getApplicationContext());
        
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        layout.setLayoutParams(rlp);

        TextView textview = new TextView(MainLibraryActivity.this.getApplicationContext());
        
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
       
        textview.setLayoutParams(layoutParams);
        textview.setText("This is from Library!");

        ((ViewGroup) layout).addView(textview);
        
       setContentView(layout);
        
        TextView textView = new TextView(mContext);
        textView.setText("Timer: 30");
        ((ViewGroup) layout).addView(textView);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_library, menu);
        return true;
    }
    
    
    
    public static int getResourceIdByName(String packageName, String className, String name) {
        Class r = null;
        int id = 0;
        try {
            r = Class.forName(packageName + ".R");

            Class[] classes = r.getClasses();
            Class desireClass = null;

            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getName().split("\\$")[1].equals(className)) {
                    desireClass = classes[i];

                    break;
                }
            }

            if (desireClass != null) {
                id = desireClass.getField(name).getInt(desireClass);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return id;
    }

}
