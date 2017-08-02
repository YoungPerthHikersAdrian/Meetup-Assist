package com.journaldev.retrofitintro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.retrofitintro.Adapters.MyRecyclerViewAdapter;
import com.journaldev.retrofitintro.TaskTable.TaskContract;
import com.journaldev.retrofitintro.eventpojo.Result;
import com.journaldev.retrofitintro.pojo.Example;

import com.journaldev.retrofitintro.eventpojo.EventExample;

import java.util.ArrayList;
import java.util.List;
//import com.journaldev.retrofitintro.Adapter.CheckableLinearLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.journaldev.retrofitintro.TaskTable.TaskDbHelper;
public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{

    TextView responseText;
    APIInterface apiInterface;
    MyRecyclerViewAdapter adapter;
    private ArrayList<Boolean> tempchk= new ArrayList<>();
    private ArrayList<String> tempID = new ArrayList<>();

    private final static String API_KEY = "d7559f69581f1c5121f2b28754c2e";
    private String EVENT_ID = null;
    private final static String GROUP_NAME = "Young-Perth-Hikers";
    private TaskDbHelper mHelper;
    private Toolbar mToolbar;
    private Integer mPos;
    private Integer mCheck;
    private int Statebit = 0;

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

    public List getTicks(List Viewholder) {
        // int i = 0;
        final String TABLE_NAME = "AttendTable";

        //String[] data = new String[10000];
        String selectQuery = "SELECT AttendStatus FROM " + TABLE_NAME;
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // data = null;
        if (cursor != null && cursor.getCount() > 0) {

            if (cursor.moveToFirst()) {
                do {
                    Viewholder.add(cursor.getInt(0));
                } while (cursor.moveToNext());
            }
        }
        db.close();
        return Viewholder;


    }
 public void deleteAll(){

     final String TABLE_NAME = "AttendTable";
     SQLiteDatabase db = mHelper.getWritableDatabase();
     db.execSQL("DELETE FROM " + TABLE_NAME); //delete all rows in a table
     db.close();
 }

public void getNames1() {
    ArrayList<String> data = new ArrayList<String>();
    ArrayList<Integer> viewholder = new ArrayList<Integer>();
    ArrayList<Boolean> viewholder1 = new ArrayList<Boolean>();
    //String[] data = new String[10000];

    getNames(data);
    getTicks(viewholder);
   for(int i=0; i < viewholder.size(); i++){
        if(viewholder.get(i)==1){
            viewholder1.add(i,Boolean.TRUE);
        }
        if(viewholder.get(i)==0){
            viewholder1.add(i,Boolean.FALSE);
        }

    }

    Statebit =1;
    tempchk = viewholder1;
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list1);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new MyRecyclerViewAdapter(this,data,tempchk,1);
    adapter.setClickListener(this);
    recyclerView.setAdapter(adapter);
    viewholder1=tempchk;



/*
     final ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.checkbox_layout,R.id.data,data);

    final ListView listview = (ListView) findViewById(R.id.list1);
    listview.setAdapter(adapter);
    //listview.setadapter ( new adaptername(this));



    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(MainActivity.this,"id:"+id+"pos:"+position+"view"+view,Toast.LENGTH_SHORT).show();
           // Toast.makeText(MainActivity.this,"id:"+listview.isItemChecked(position),Toast.LENGTH_SHORT).show();


            CheckBox cb = (CheckBox) view.findViewById(R.id.CheckBox01);

           Toast.makeText(MainActivity.this,"test:"+viewholder.get(position),Toast.LENGTH_SHORT).show();
            if (viewholder.get(position) == Boolean.TRUE){
                viewholder.add(position, Boolean.FALSE);

            } else{
                viewholder.add(position, Boolean.TRUE);
            }

            Toast.makeText(MainActivity.this,"test:"+viewholder.get(position),Toast.LENGTH_SHORT).show();

            listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);



            //Toast.makeText(MainActivity.this,"id:"+listview.isItemChecked(position),Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();*/


        //}
    //});






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
                values.put(TaskContract.TaskEntry.COLUMN4_NAME,Boolean.FALSE);
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


/*public void getEvents1(ArrayList eventName, ArrayList eventID){


    MyRecyclerViewAdapter1 adapter;

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list1);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    adapter = new MyRecyclerViewAdapter1(this,eventName,eventID);



    recyclerView.setAdapter(adapter);
}*/


public String[] getEvents(){
    String[] Event = new String[2];


    deleteAll();
    Statebit =0;
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
                final ArrayList<String> eventName = new ArrayList<String>();
                final ArrayList<String> eventID = new ArrayList<String>();
                MyRecyclerViewAdapter adapter;

                ContentValues values = new ContentValues();
              for (Result  Result: EvList) {

                    //(eventName.add(com.journaldev.retrofitintro.eventpojo.Result.class.getName()));

                   eventName.add(Result.getName());
                  eventID.add(Result.getId());

                    Log.v("**!**",Result.getName());


              }
              tempID = eventID;

            ArrayList<Boolean> viewholder = new ArrayList<Boolean>();
            //String[] data = new String[10000];


            getTicks(viewholder);
            for(int i=0; i < viewholder.size() -1; i++) {
                if (viewholder.get(i) == Boolean.TRUE) {
                    viewholder.add(i, Boolean.TRUE);
                }
                if (viewholder.get(i) == Boolean.FALSE) {
                    viewholder.add(i, Boolean.FALSE);
                }
            }

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list1);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            adapter = new MyRecyclerViewAdapter(MainActivity.this,eventName,viewholder,0);

            adapter.setClickListener(MainActivity.this);
            recyclerView.setAdapter(adapter);
            mCheck =0;
            if(mPos != null){
                mCheck =1;
                EVENT_ID = eventID.get(mPos);
                getAttend();
            }

     /*     ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.list_layout,eventName);

            ListView listview = (ListView) findViewById(R.id.list2);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // Toast.makeText(MainActivity.this,"event: "+eventName.get(position)+"ID: "+eventID.get(position),Toast.LENGTH_SHORT).show();
                    EVENT_ID=eventID.get(position);
                    getAttend();
                }
            });*/
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
    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        mPos = position;

        if (mCheck == 1) {
            CheckBox cb = (CheckBox) view.findViewById(R.id.CheckBox01);
            if (cb.isChecked()) {
                //cb.performClick();
                tempchk.add(position, Boolean.TRUE);

            } else {
                //cb.performClick();
                tempchk.add(position, Boolean.FALSE);
            }
        } else {
            mCheck =1;
            EVENT_ID=tempID.get(position);
            getAttend();

        }
    }



    public void onItemClick1(View view, int position) {
        EVENT_ID=tempID.get(position);
        getAttend();

    }

}
