package com.example.kwanggy.whatsup;

//import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ListView;
//import android.widget.Toast;

//import java.util.ResourceBundle;


public class ListActivity extends ActionBarActivity implements View.OnClickListener {

    private Button buttonAdd,buttonEdit,buttonDelete;
    final Context context = this;
    ListView list;
    ListAdapter myAdapter;
    String name,url;
    Dialog dialog;
    /*
    private final int ACTIVITY_ADD = 0;
    private final int ACTIVITY_EDIT = 1;
    private final int ACTIVITY_DELETE = 2;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list  = (ListView)findViewById(R.id.mylist);
        myAdapter= new ListAdapter(context);





        buttonAdd = (Button)findViewById(R.id.addlist);
        buttonAdd.setOnClickListener(this);
        System.out.println("before listsetonItem");
        list.setAdapter(myAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Market m = (Market)list.getItemAtPosition(position);
                String title = m.getName();
                String url = m.getUrl();
                Intent in = new Intent(context,com.example.kwanggy.whatsup.InsideListActivity.class);
                in.putExtra("Name",title);
                in.putExtra("URL",url);
                startActivity(in);
            }
        });

        System.out.println("end of oncreate");
    }

    @Override
    protected void onResume() {

        //myAdapter.notifyDataSetChanged();
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == buttonAdd.getId()) {

            dialog = new Dialog(context);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.setTitle("Add");
            Button submitButton = (Button) dialog.findViewById(R.id.submit);
            Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
            dialog.setTitle("Add Item");
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    name = ((EditText)dialog.findViewById(R.id.nameInput)).getText().toString();
                    url = ((EditText)dialog.findViewById(R.id.urlInput)).getText().toString();
                    Resources res = getResources();
                    myAdapter.addItem(new Market(res.getDrawable(R.drawable.ic_launcher), name, url));


                    dialog.dismiss();
                }
            });
            cancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
            //Resources res = getResources();
            //myAdapter.addItem(new Market(res.getDrawable(R.drawable.ic_launcher), name, url));

        }

        list.setAdapter(myAdapter);
        myAdapter.notifyDataSetInvalidated();
        //myAdapter.notifyDataSetChanged();
        System.out.println("after add");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
