package se.gildur.android.randomassignments;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView namesListView = (ListView)findViewById(R.id.listView1);
        ListView assignedListView = (ListView)findViewById(R.id.listView2);
        
        final EditText inputName = (EditText)findViewById(R.id.editText1);
        
        final ArrayList<String> names1 = new ArrayList<String>();
        final ArrayList<String> names2 = new ArrayList<String>();
        
        final ArrayAdapter<String> aa1;
        final ArrayAdapter<String> aa2;
        
        aa1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names1);
        aa2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names2);
        
        namesListView.setAdapter(aa1);
        assignedListView.setAdapter(aa2);
        
        Button btnAddNameToList = (Button) findViewById(R.id.btnAdd);
        
        btnAddNameToList.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				boolean duplicateFound = false;
				for (String s : names1) {
				    if (s.equals(inputName.getText().toString())) 
				    {
				        duplicateFound = true;
				        break;
				    }
				}
				if(duplicateFound) 
				{
					//TODO: show toast "no duplicate names, please"
				}
				else if(inputName.getText().toString().isEmpty()) 
				{
					//TODO: show toast "Cannot be empty"
				}
				else
				{
					names1.add(0, inputName.getText().toString());
					aa1.notifyDataSetChanged();
					inputName.setText("");
				}
			}
		});
        
        Button btnAssignPresents = (Button) findViewById(R.id.btnAssign);
        
        btnAssignPresents.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				if(names1.size() > 1) {
					ListRandomizer assigner = new ListRandomizerImpl(names1);
					names2.clear();
					names2.addAll(assigner.getRandomizedList());
					aa2.notifyDataSetChanged();
				}
				else {
					//TODO: Show toast "Need at least 2 name sin list"
				}
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
