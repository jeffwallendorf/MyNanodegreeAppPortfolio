package com.udacity.jeff.myappportfolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends Activity {

    String [] appNames={"Spotify Streamer", "Scores App","Library App","Build it bigger","XYZ Reader","Capstone: my own App"};
    int[] buttonIds={R.id.button1,R.id.button2,R.id.button3, R.id.button4,R.id.button5, R.id.button6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        //set button IDs & OnClickListener:
                for(int i=0;i<6;i++){
                    button= (Button)findViewById(buttonIds[i]);
                button.setText(appNames[i]);
                    button.setOnClickListener(new View.OnClickListener(){
                                                 public void onClick(View v){
                                                     sendToast(v);
                                                 }
                                              }
                    );
                }

    }

    public void sendToast(View view) {
        int buttonId=view.getId();
        String [] text4Toast={"Spotify Streamer","Scores", "library","Build it bigger","XYZ Reader","Capstone"};
        boolean lookForId=true;
        int buttonIndex=-1;
        // Find buttonIds[x]:
        while(lookForId){
            buttonIndex++;
            if (buttonIds[buttonIndex]==buttonId){
                lookForId=false;
            }
        }
        CharSequence text= "This button will launch my "+text4Toast[buttonIndex]+" app";
        Toast toast = Toast.makeText(this,text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100);
        toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
