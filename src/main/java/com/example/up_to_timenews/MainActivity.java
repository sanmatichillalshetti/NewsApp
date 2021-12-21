package com.example.up_to_timenews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    //NewsModel model;
    NewsAdapter newsAdapter;
  ArrayList<NewsModel> newsarray= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        fetchdata();

       //newsAdapter=new NewsAdapter(this);
       newsAdapter=new NewsAdapter(this,newsarray);

        recyclerView.setAdapter(newsAdapter);




    }
    public void fetchdata(){
         String url="http://api.mediastack.com/v1/news?access_key=97b9b972a5d4f71f91e34be0ce23568d&countries=in";

       // String url="https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=42b0dcc0af0c48dcac7dceb2e91bb7dc";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                   @Override
                    public void onResponse(JSONObject response) {
                       try {
                           JSONArray jsonArray=response.getJSONArray("data");
                           /*ArrayList<NewsModel> newsarray;
                           newsarray=new ArrayList<NewsModel>();*/
                           for(int i=0;i<jsonArray.length();i++){
                               JSONObject jsonObject=jsonArray.getJSONObject(i);
                              /* NewsModel model=new NewsModel(jsonObject.getString("title"));
                               newsarray.add(model);*/
                               String title=jsonObject.getString("title");
                              // String urlimage=jsonObject.getString("url");
                               String author=jsonObject.getString("description");
                               newsarray.add(new NewsModel(title,author));

                           }
                           //newsAdapter.update(newsarray);
                           newsAdapter.notifyDataSetChanged();




                       } catch (JSONException e) {
                           e.printStackTrace();
                       }





                   }



                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }



}