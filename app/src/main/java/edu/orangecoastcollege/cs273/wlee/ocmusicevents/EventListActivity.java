package edu.orangecoastcollege.cs273.wlee.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        // Set the adapter (which binds the ListView with the data in MusicEvent.java)
        // Since the data is in an array, we use an ArrayAdapter:

        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

        // setContentView(R.layout.activity_event_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        // Use position to extract title and details(MusicEvent.java)
        String title = MusicEvent.titles[pos];
        String detail = MusicEvent.details[pos];
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        startActivity(detailsIntent);
    }
/*
    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        // 1) Get the positions, get the title, get the details
        // 2) Make a new Intent
        // 3) put the strings into the intent
        // 4) start activity
    }
*/
}
