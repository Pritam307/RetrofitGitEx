package com.example.pritampc.retrofitgitex;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView list;
    private static final String TAG="MAIN;";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.listview);

        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();

        //Instance of GithubClient class

        GithubClient client=retrofit.create(GithubClient.class);

        Call<List<GithubRepo>> call=client.getUserRepo("Pritam307");
        //Request body in asynchronuos mode i.e. in other thread except main thread

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();
                ArrayList<String> list_array=RepoNames(repos);
                //Log.d(TAG, "onResponse: "+repos.get(1).getName());
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list_array);
                list.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"error!",Toast.LENGTH_LONG).show();
            }
        });

      /* Call<List<ModelClassEX>>  fakeuser=client.getFakeUser();

       fakeuser.enqueue(new Callback<List<ModelClassEX>>() {
           @Override
           public void onResponse(Call<List<ModelClassEX>> call, Response<List<ModelClassEX>> response) {
               List<ModelClassEX> model=response.body();
                ArrayList<String> names=FakeNames(model);
               Log.d(TAG, "onResponse: "+names);
           }

           @Override
           public void onFailure(Call<List<ModelClassEX>> call, Throwable t) {

           }
       });  */

    }

    public ArrayList<String> RepoNames(List<GithubRepo> list)
    {
        ArrayList<String> names=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            names.add(list.get(i).getName());
        }

        return names;
    }

    public ArrayList<String> FakeNames(List<ModelClassEX> list)
    {
        ArrayList<String> names=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            names.add(list.get(i).getTitle()+"\n");
        }

        return names;
    }
}
