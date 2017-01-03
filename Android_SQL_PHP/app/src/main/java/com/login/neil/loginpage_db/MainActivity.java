package com.login.neil.loginpage_db;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends ActionBarActivity {

    String name;
    String id;
    String password;
    InputStream is=null;
    String result=null;
    String line=null;
    String date = new SimpleDateFormat("dd-mm-yy").format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void sign(View view)
    {
        Toast.makeText(getApplicationContext(), date,
                   Toast.LENGTH_LONG).show();
    }


    public void insert(View view) {

        final EditText e_id = (EditText) findViewById(R.id.insert1);
        id = e_id.getText().toString();
        name="neil";
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("id1",id));
                nameValuePairs.add(new BasicNameValuePair("name1",name));

                try
                {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.3/test_android/insert.php");

                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    Log.e("pass 1", "connection success ");
                    //Toast.makeText(getApplicationContext(), "success",
                        //    Toast.LENGTH_LONG).show();
                }
                catch(Exception e){}


            }
        }).start();
       /*
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

        nameValuePairs.add(new BasicNameValuePair("id", id));
        nameValuePairs.add(new BasicNameValuePair("name", name));

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.1.3/test_android/insert.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("pass 1", "connection success ");
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
            Toast.makeText(getApplicationContext(), e.toString()+"Invalid IP Address",
                    Toast.LENGTH_LONG).show();
        }

        try {
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.e("pass 2", "connection success ");
        } catch (Exception e) {
            Log.e("Fail 2", e.toString());
        }

        try {
            JSONObject json_data = new JSONObject(result);
            code = (json_data.getInt("code"));

            if (code == 1) {
                Toast.makeText(getBaseContext(), "Inserted Successfully",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(), "Sorry, Try Again",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
        }*/

        Toast.makeText(getBaseContext(), "Inserted Successfully",
                Toast.LENGTH_SHORT).show();
    }
    public void select(View view)
    {
        result=null;
        password=null;
        final EditText e_name = (EditText) findViewById(R.id.select1);
        name = e_name.getText().toString();

        final Handler handler = new Handler();
        new Thread(new Runnable() {



            @Override
            public void run() {

                // TODO Auto-generated method stub
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                //nameValuePairs.add(new BasicNameValuePair("id1",id));
                nameValuePairs.add(new BasicNameValuePair("name1",name));

                try
                {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://192.168.1.3/test_android/select.php");

                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    Log.e("pass 1", "connection success ");
                    //Toast.makeText(getApplicationContext(), "success",
                    //    Toast.LENGTH_LONG).show();
                }
                catch(Exception e){}

                try
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                   // BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    is.close();
                    result = sb.toString();        //result from server in json

                    Log.e("pass 2", "connection success "+result);
                }
                catch(Exception e) {
                    Log.e("Fail 2", e.toString());
                }



                try
                {
                    JSONObject json_data = new JSONObject(result);
                    password=json_data.getString("name2");
                    Log.e("pass 1", "password success " + password);

                   // Toast.makeText(getBaseContext(), "Password : "+password,Toast.LENGTH_SHORT).show();
                    handler.post(new Runnable() {
                        public void run() {
                            Toast.makeText(getBaseContext(), "Password : "+password,Toast.LENGTH_SHORT).show();         //toast or settext() cannot be directly given inside a thread
                        }
                    });





                }
                catch(Exception e)
                {
                    Log.e("Fail 3", e.toString());
                }

            }

        }).start();






    }
}
