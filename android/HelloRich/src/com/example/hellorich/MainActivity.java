
package com.example.hellorich;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;

public class MainActivity extends Activity  {

    private PopupWindow mPopupWindow;
    private Context mContext;
    private VideoView  videoView;
    
    PopupWindow popUp;
    LinearLayout layout;
    TextView tv;
    LayoutParams params;
    LinearLayout mainLayout;
    Button but;
    boolean click = true;
  
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //setContentView(R.layout.activity_main);
        setupvideo();
 
    }      
    
    
    public void setupPopup()
    {
       mContext = this.getApplicationContext();
        
        final RelativeLayout layout = new RelativeLayout(MainActivity.this);
        
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        layout.setLayoutParams(rlp);

        TextView textview = new TextView(MainActivity.this);
        
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
       
        textview.setLayoutParams(layoutParams);
        textview.setText("Hello World!");

        ((ViewGroup) layout).addView(textview);
        
       setContentView(layout);
        
      
        
       // RelativeLayout linearLayout = (RelativeLayout) findViewById(R.id.activitylayout);
       // TextView textView = new TextView(mContext);
      //  textView.setText("Timer: 30");
      //  ((ViewGroup) linearLayout).addView(textView);
        
        /*
        <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:tools="http://schemas.android.com/tools"
                android:id="@+id/activitylayout"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:paddingBottom="@dimen/activity_vertical_margin"
                android:paddingLeft="@dimen/activity_horizontal_margin"
                android:paddingRight="@dimen/activity_horizontal_margin"
                android:paddingTop="@dimen/activity_vertical_margin"
                tools:context=".MainActivity" >

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_centerInParent="true"
                    android:text="@string/hello_world" />
             

            </RelativeLayout>
          */
       
        /*
        
        RelativeLayout linearLayout = (RelativeLayout) findViewById(R.id.activitylayout);
        TextView textView = new TextView(mContext);
        textView.setText("Timer: 30");
        ((ViewGroup) linearLayout).addView(textView);
        */
       
       TextView textView = new TextView(mContext);
       textView.setText("Timer: 30");
       ((ViewGroup) layout).addView(textView);
    }
    
    
    public void setupvideo()
    {
        setContentView(R.layout.activity_main);  
        
        videoView =(VideoView)findViewById(R.id.videoView1);  
          
                //Creating MediaController  
        MediaController mediaController= new MediaController(this);  
            mediaController.setAnchorView(videoView);          
         
              //specify the location of media file  ol
           Uri uri=Uri.parse("http://flurry.cachefly.net/video/20130502/5c5a892f-bef3-4b1c-a875-9b8c4f90832d.mp4");          
                
              //Setting MediaController and URI, then starting the videoView  
           videoView.setMediaController(mediaController);  
           videoView.setVideoURI(uri);          
           videoView.requestFocus();  
           
           try {
        	   
        	   Thread.sleep(2000);
           }
           catch(Exception ex)
           {
        	   
           }
          
           
           videoView.start();  
    }
    
    @Override
    protected void onResume()
    {
        super.onResume();
        //initFloatingWindow2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void initFloatingWindow2()
    {

            popUp = new PopupWindow(this);
            layout = new LinearLayout(this);
            mainLayout = new LinearLayout(this);
            tv = new TextView(this);
             params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            layout.setOrientation(LinearLayout.VERTICAL);
            tv.setText("Hi this is a sample text for popup window");
            layout.addView(tv, params);
            popUp.setContentView(layout);
            setContentView(mainLayout);
            
            
            ImageButton pauseButton = new ImageButton(this);
            pauseButton.setImageDrawable(getResources().getDrawable(R.drawable.play_button));
            
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, -1);
           
            ((ViewGroup) layout).addView(pauseButton);
            
            
 
            new Handler().postDelayed(new Runnable() {
                

                public void run() {
                    
                    popUp.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);
                    popUp.update(0, 0, 350, 480);
                    
                }
            }, 100L);
        
    }
    
    
    
    public void initFloatingWindow() {
     
     
        try 
        {
            
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
        

        
        mediacontrollerLayout.setFocusableInTouchMode(true);
        
        mediacontrollerLayout.setOnKeyListener(new View.OnKeyListener() {
            
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                
                if (keyCode == KeyEvent.KEYCODE_BACK)
                {
                    if (mPopupWindow != null && mPopupWindow.isShowing()) {
                        //mPopupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        
        mPopupWindow = new PopupWindow(mediacontrollerLayout, 350, 480, true);
        mPopupWindow.setWidth(350);
        mPopupWindow.setHeight(480);
        
        //mPopupWindow.setTouchInterceptor(mTouchListener);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setContentView(mediacontrollerLayout);

        new Handler().postDelayed(new Runnable() {
            

            public void run() {
                
                mPopupWindow.showAtLocation(mediacontrollerLayout, Gravity.CENTER, 0, 0);
                mPopupWindow.update(0, 0, 350, 480);
                
            }
        }, 100L);
        
    } catch (Exception e) {

        e.printStackTrace();
    }

    
        
   
        
      /*  
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.media_controller,
                    (ViewGroup) findViewById(R.id.mediacontrollerLayout));
            layout.setFocusableInTouchMode(true);
            
            layout.setOnKeyListener(new View.OnKeyListener() {
                
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    
                    if (keyCode == KeyEvent.KEYCODE_BACK)
                    {
                        if (mPopupWindow != null && mPopupWindow.isShowing()) {
                            mPopupWindow.dismiss();
                        }
                    }
                    return true;
                }
            });
            
            mPopupWindow = new PopupWindow(layout, 350, 480, true);
            //mPopupWindow.setTouchInterceptor(mTouchListener);
            mPopupWindow.setOutsideTouchable(true);

            new Handler().postDelayed(new Runnable() {
                
   
                public void run() {
                    
                    mPopupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
                    
                }
            }, 100L);
            
        } catch (Exception e) {

            e.printStackTrace();
        }
        */
    

    }
    
 
    public void dismissPopup() {

        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
    }


}
