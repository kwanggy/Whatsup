package com.example.kwanggy.whatsup;

//import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
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
import android.widget.ListView;
//import android.widget.Toast;

//import java.util.ResourceBundle;


public class ListActivity extends ActionBarActivity implements View.OnClickListener {

    private Button buttonAdd,buttonEdit,buttonDelete;
    final Context context = this;
    final ListView list = (ListView)findViewById(R.id.mylist);
    ListAdapter myAdapter;
    /*
    private final int ACTIVITY_ADD = 0;
    private final int ACTIVITY_EDIT = 1;
    private final int ACTIVITY_DELETE = 2;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myAdapter= new ListAdapter(context);





        buttonAdd = (Button)findViewById(R.id.addlist);
        buttonEdit = (Button)findViewById(R.id.editlist);
        buttonDelete = (Button)findViewById(R.id.deletelist);
        buttonAdd.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Market m = (Market)list.getItemAtPosition(position);
                String title = m.getName();
            }
        });
    }

    @Override
    protected void onResume() {
        list.setAdapter(myAdapter);
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == buttonAdd.getId()) {
            //when add button pressed.
            //go to add activity
            //in add activity get input from user ex) Name of website, url
             /*
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.custom_dialog, null);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(view);
            final String name = view.findViewById(R.id.nameInput).toString();
            final String url = view.findViewById(R.id.urlInput).toString();

            alertDialogBuilder.setCancelable(false).setPositiveButton("submit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.out.println(name);

                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertD = alertDialogBuilder.create();
            alertD.show();
            */
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.custom_dialog);
            dialog.setTitle("Add");
            Button submitButton = (Button) dialog.findViewById(R.id.submit);
            Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
            dialog.setTitle("Add Item");
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String name = dialog.findViewById(R.id.nameInput).toString();
                    String url = dialog.findViewById(R.id.urlInput).toString();
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

        }
        else if(id == buttonEdit.getId()) {

        }
        list.setAdapter(myAdapter);
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
