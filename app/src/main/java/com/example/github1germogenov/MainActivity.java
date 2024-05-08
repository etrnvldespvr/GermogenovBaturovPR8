package com.example.github1germogenov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.github1germogenov.Contributor;
import com.example.github1germogenov.ContributorAdapter;
import com.example.github1germogenov.GithubService;
import com.example.github1germogenov.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    RecyclerView mRecyclerView;
    List<Contributor> mContributors;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);
        mContributors = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recycler);
        mProgressBar.setVisibility(View.VISIBLE);

        GridLayoutManager manager = new GridLayoutManager(MainActivity.this, 3);
        mRecyclerView.setLayoutManager(manager);

        GithubService contributorsAPI = GithubService.retrofit.create(GithubService.class);
        final Call<List<Contributor>> call = contributorsAPI.repoContributors("square", "picasso");

        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                if (response.isSuccessful()){
                    mContributors.addAll(response.body());
                    ContributorAdapter adapter = new ContributorAdapter(MainActivity.this, mContributors);
                    mRecyclerView.setAdapter(adapter);
                    mProgressBar.setVisibility(View.INVISIBLE);
                } else {
                    ResponseBody errorBody = response.errorBody();
                    try {
                        Toast.makeText(MainActivity.this, errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                        mProgressBar.setVisibility(View.INVISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable throwable) {
                Log.d("GIT", ""+throwable.getMessage());
                Toast.makeText(MainActivity.this, "Что-то пошло не так. ",
                        Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.INVISIBLE);

            }
        });

    }
}