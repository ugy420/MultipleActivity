package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.listview);

        String[] menuItems = {"Message","Map","Image"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                menuItems
        );
        listview.setAdapter(adapter);

        listview.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = menuItems[position];
            handleItemClick(selectedItem);
        });
    }

    private void handleItemClick(String selI){
        switch(selI){
            case "Message":
                messageApp();
                break;
            case "Map":
                mapApp();
                break;
            case "Image":
                openImage();
                break;
        }
    }

    private void messageApp(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(intent);
    }
    private void mapApp(){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
    private void openImage(){
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }
}