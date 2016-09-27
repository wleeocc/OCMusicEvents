package edu.orangecoastcollege.cs273.wlee.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView; // step 1

    // In order to use AssetManager, need to know Context // Step 5-1
    private Context context = (Context) this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details); // Step 3

        // Get the data from Intent // Step 4
        Intent detailsIntent = getIntent();
        String title = detailsIntent.getStringExtra("Title");
        String details = detailsIntent.getStringExtra("Details");
        String imageFileName = title.replace(" ", "") + ".jpeg";

        eventImageView = (ImageView) findViewById(R.id.eventImageView);

        // Load the image from the Assets folder using the AssetManager Class // Step 5
        AssetManager am = context.getAssets();

        // Try to load the image file // Step 6
        try{
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        }
        catch (IOException ex)
        {
            Log.e("OC Music Events", "Cannot Load image: " + imageFileName + ex);
        }

        eventImageView = (ImageView) findViewById(R.id.eventImageView); // step 2
    }



}
