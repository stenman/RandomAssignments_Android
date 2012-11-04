package se.gildur.android.randomassignments;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
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
        
        final EditText inputName = (EditText)findViewById(R.id.editText1);
        
        final ArrayList<String> names1 = new ArrayList<String>();
        
        final ArrayAdapter<String> aa;
        
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names1);
        
        namesListView.setAdapter(aa);
        
        Button btnAddNameToList = (Button) findViewById(R.id.button1);
        
        btnAddNameToList.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				names1.add(0, inputName.getText().toString());
				aa.notifyDataSetChanged();
				inputName.setText("");
			}
		});
        
        Button btnAssignPresents = (Button) findViewById(R.id.button2);
        
        btnAssignPresents.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
				//TODO: lägg in logik för assignment...
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
