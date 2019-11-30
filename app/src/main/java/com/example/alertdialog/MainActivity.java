package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * @author Hadar Malul
 * @since 30.11.19
 */

public class MainActivity extends AppCompatActivity {

    /**
     * adb is an alert dialog builder
     * ll is a linear layout component
     * rnd is a Random object
     */

    AlertDialog.Builder adb;
    LinearLayout ll;
    Random rnd = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.ll);
    }

    /**
     * this function creates the menu
     */

    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * this function activates the menu
     */

    public boolean onOptionsItemSelected(MenuItem item){

        /**
         * the screen changes according to the chosen item
         */
        String st = item.getTitle().toString();
        if (st.equals("Credits")){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        if (st.equals("Buttons")){
            Intent si = new Intent(this,MainActivity.class);
            startActivity(si);
        }
        return true;
    }

    /**
     * the function starts when the button is clicked
     * setting features to the alert dialog
     */

    public void message(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setMessage("this is a simple Alert");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * the function starts when the button is clicked
     * setting features to the alert dialog
     */

    public void icon(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("Icon");
        adb.setMessage("message with an Icon");
        adb.setIcon(R.drawable.heart);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * the function starts when the button is clicked
     * setting features to the alert dialog
     */

    public void onebutton(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("one button");
        adb.setMessage("message with Icon and button");
        adb.setIcon(R.drawable.heart);
        adb.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

              dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
    /**
     * the function starts when the button is clicked
     * setting features to the alert dialog
     */

    public void twobuttons(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("change Background");
        adb.setMessage("change to a random background");

        adb.setPositiveButton("change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int color = Color.argb(255,rnd.nextInt(256),rnd.nextInt(256), rnd.nextInt(256));
                ll.setBackgroundColor(color);
            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

               dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * the function starts when the button is clicked
     * setting features to the alert dialog
     */

    public void resetandchange(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("change Background");
        adb.setMessage("change and reset backgrounds");

        adb.setPositiveButton("change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int color = Color.argb(255,rnd.nextInt(256),rnd.nextInt(256), rnd.nextInt(256));
                ll.setBackgroundColor(color);
            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });

        adb.setNeutralButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ll.setBackgroundColor(Color.WHITE);
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
}
