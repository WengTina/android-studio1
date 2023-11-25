package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project.Adapter.CategoryAdapter;
import com.example.project.Adapter.PopularAdapter;
import com.example.project.Domain.CategoryDomain;
import com.example.project.Domain.FoodDomain;
import com.example.project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                Snackbar.make(v, "FAB ..........", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
                // Map point based on address
                Uri location= Uri.parse(
                        "https://www.louisacoffee.co/visit"
                );
                // Or map point based on latitude/longitude
                // val location: Uri = Uri.parse("geo:37.422219,-122.08364?z=14") // z param is zoom level
                Intent mapIntent=new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }


        });
    }

    private void recyclerViewPopular() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("蜂蜜法式吐司", "food1", " 「原味蜂蜜」吸飽牛奶的法式吐司，間的表面煎黃酥脆，但吐司更是柔軟到沒話說，再淋上溫潤可口的蜂蜜，早餐來一份實在太奢華！ ", 55.0));
        foodlist.add(new FoodDomain("鮪魚玉米磚壓", "food2", " 鮪魚玉米是不少台灣人最愛的經典系列，不管是配吐司、蛋餅都很完美。就用酥脆、鬆軟的鮪魚玉米磚壓，為一天揭開序幕！ ", 55.0));
        foodlist.add(new FoodDomain("豬肉瑪芬堡加蛋", "food3", " 大口咬下用“酥脆”開啟這趟迷人的輕食之旅，嘴裡咀嚼著營養芝士片、濃郁起司醬、和鮮嫩多汁的豬肉排，留意你的嘴角，小心沾上玉米粉洩漏了你的輕食新歡—瑪芬堡。 ", 65.0));
        foodlist.add(new FoodDomain(" 100% 一番特濃い抹茶鮮奶", "drink1", " 除了抹茶原有的清甜感外多了些抹茶特有的甘苦，抹茶重度愛好者首選推薦！ ", 100.0));
        foodlist.add(new FoodDomain("小農經典拿鐵", "drink2", " 路易莎支持在地酪農，且飲品升級成小農鮮奶，入口感受濃郁奶香，喜歡奶香味重一點的人推薦可以點選小農經典拿鐵！ ", 95.0));


        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Toast", "cat_15"));
        categoryList.add(new CategoryDomain("Burger", "cat_14"));
        categoryList.add(new CategoryDomain("Bagel", "cat_13"));
        categoryList.add(new CategoryDomain("Drink", "cat_12"));
        categoryList.add(new CategoryDomain("Cake", "cat_11"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}