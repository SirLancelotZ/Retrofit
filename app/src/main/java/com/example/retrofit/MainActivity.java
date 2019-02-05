package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void searchRecipes{
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://recipepupppy.com").addConverterFactory(GsonConverterFactory.create()).build();
    }


    RecipePuppyService service = retrofit.create(RecipePuppyService.class);

    Call<RecipeResponse> recipeResponseCall = service.searchByIngredient("chocolate,potato","eggs");

    recipeResponseCall.enqueue(new Callback<RecipeResponse>(){
        @Override
                public void onResponse(Call<RecipeResponse> call, Throwable t)(

                )
    })


}
