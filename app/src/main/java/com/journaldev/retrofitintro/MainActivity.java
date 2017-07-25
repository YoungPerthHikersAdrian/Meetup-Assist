package com.journaldev.retrofitintro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.retrofitintro.TaskTable.TaskContract;
import com.journaldev.retrofitintro.eventpojo.Result;
import com.journaldev.retrofitintro.pojo.Example;

import com.journaldev.retrofitintro.eventpojo.EventExample;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.journaldev.retrofitintro.TaskTable.TaskDbHelper;
public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    private final static String API_KEY = "d7559f69581f1c5121f2b28754c2e";
    private String EVENT_ID = null;
    private final static String GROUP_NAME = "Young-Perth-Hikers";
    private TaskDbHelper mHelper;
    private Toolbar mToolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_event) {
            getEvents();

           //inflate new acticity

            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mHelper = new TaskDbHelper(this);
        //responseText = (TextView) findViewById(R.id.responseText);

        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY First",
                    Toast.LENGTH_LONG).show();
        }


     }
 public List getNames( List data) {
    // int i = 0;
     final String TABLE_NAME = "AttendTable";

     //String[] data = new String[10000];
     String selectQuery = "SELECT MemeberName FROM " + TABLE_NAME;
     SQLiteDatabase db = mHelper.getReadableDatabase();
     Cursor cursor = db.rawQuery(selectQuery, null);
    // data = null;
     if (cursor != null && cursor.getCount() > 0) {
         if (cursor.moveToFirst()) {
             do {
                 data.add(cursor.getString(0));
                } while (cursor.moveToNext());
         }
     }
     db.close();
     return data;


 }
 public void deleteAll(){

     final String TABLE_NAME = "AttendTable";
     SQLiteDatabase db = mHelper.getWritableDatabase();
     db.execSQL("DELETE FROM " + TABLE_NAME); //delete all rows in a table
     db.close();
 }

public void getNames1(){
    List<String> data = new ArrayList<String>();
    //String[] data = new String[10000];

    getNames(data);
     final ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.checkbox_layout,R.id.data,data);

    final ListView listview = (ListView) findViewById(R.id.list1);
    listview.setAdapter(adapter);
    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(MainActivity.this,"id:"+id+"pos:"+position+"view"+view,Toast.LENGTH_SHORT).show();
           // Toast.makeText(MainActivity.this,"id:"+listview.isItemChecked(position),Toast.LENGTH_SHORT).show();


            CheckBox cb = (CheckBox) view.findViewById(R.id.CheckBox01);
            cb.performClick();
            listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);

            //Toast.makeText(MainActivity.this,"id:"+listview.isItemChecked(position),Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();


        }
    });






}


public void getAttend(){

    apiInterface = APIClient.getClient().create(APIInterface.class);

    Call<Example> call = apiInterface.getRSVP(API_KEY, EVENT_ID);
    call.enqueue(new Callback<Example>() {

        @Override
        public void onResponse(Call<Example> call, Response<Example> response) {

            List<com.journaldev.retrofitintro.pojo.Result> ResList= response.body().getResults();

            SQLiteDatabase db = mHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            for (com.journaldev.retrofitintro.pojo.Result Result: ResList) {

                values.put(TaskContract.TaskEntry.COLUMN1_NAME,Result.getMember().getMemberId());
                values.put(TaskContract.TaskEntry.COLUMN2_NAME,Result.getMember().getName());
                values.put(TaskContract.TaskEntry.COLUMN3_NAME,Result.getMemberPhoto().getPhotoLink());
                values.put(TaskContract.TaskEntry.COLUMN4_NAME,"N");
                db.insert(TaskContract.TaskEntry.TABLE_NAME, null, values);


            }
            db.close();
            getNames1();


        }

        @Override
        public void onFailure(Call<Example> call, Throwable t) {
            Log.e("Failed on:", t.toString());
            call.cancel();
            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_LONG).show();
        }

    });

    }

public String[] getEvents(){
    String[] Event = new String[2];


    deleteAll();
    //getNames1();

    //Get list of upcoming events

    //maybe approach this diffrently
    //Meta group storing correctly, result is null ? Naming conflict
    apiInterface = APIClient.getClient().create(APIInterface.class);

    Call<EventExample> call = apiInterface.getEVENT(API_KEY,GROUP_NAME);
    call.enqueue(new Callback<EventExample>() {

        @Override
        public void onResponse(Call<EventExample> call, Response<EventExample> response) {

                List<Result> EvList= response.body().getEventResults();
                //List<Result> IdList = response.body().getEventResults();
                final List<String> eventName = new ArrayList<String>();
                final List<String> eventID = new ArrayList<String>();


                ContentValues values = new ContentValues();
              for (Result  Result: EvList) {

                    //(eventName.add(com.journaldev.retrofitintro.eventpojo.Result.class.getName()));

                   eventName.add(Result.getName());
                  eventID.add(Result.getId());

                    Log.v("**!**",Result.getName());


              }
           ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.list_layout,eventName);

            ListView listview = (ListView) findViewById(R.id.list1);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // Toast.makeText(MainActivity.this,"event: "+eventName.get(position)+"ID: "+eventID.get(position),Toast.LENGTH_SHORT).show();
                    EVENT_ID=eventID.get(position);
                    getAttend();
                }
            });
        }

                @Override
        public void onFailure(Call<EventExample> call, Throwable t) {
            Log.e("Failed on:", t.toString());
            //call.cancel();
            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_LONG).show();
        }


    });


    return Event;
}

}
