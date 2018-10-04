package com.example.lasitha.safedrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.lasitha.safedrive.api.APIService;
import com.example.lasitha.safedrive.api.APIUrl;
import com.example.lasitha.safedrive.helper.TagDetailAdapter;
import com.example.lasitha.safedrive.models.TagDetail;
import com.example.lasitha.safedrive.models.TagsDetailsResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewTagsDetails extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TagDetailAdapter adapter;
    private List<TagDetail> tagsDetails;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tags_details);
        getLayoutInflater();

        recyclerView = findViewById(R.id.recyclerViewTagsDetails);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        Call<TagsDetailsResult> call = service.getAllTags();

        call.enqueue(new Callback<TagsDetailsResult>() {
            @Override
            public void onResponse(Call<TagsDetailsResult> call, Response<TagsDetailsResult> response) {
                tagsDetails = response.body().getTagsDetails();
                adapter = new TagDetailAdapter(getApplicationContext(), tagsDetails);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<TagsDetailsResult> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });



    }

}