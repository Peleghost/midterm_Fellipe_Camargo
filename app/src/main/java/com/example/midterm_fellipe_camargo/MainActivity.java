package com.example.midterm_fellipe_camargo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText number_text;
    int num;
    private static ArrayList<Integer> results = new ArrayList<>(10);
    private ArrayAdapter<Integer> adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.menu_activity) {
//            Intent intent = new Intent(this, HistoryActivity.class);
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        number_text = findViewById(R.id.number);

        // Handle on click
        findViewById(R.id.btn_calc).setOnClickListener(v -> {
            // Validate input and convert to numeric
            if (number_text.getText().length() != 0) {
                num = Integer.parseInt(number_text.getText().toString());
            } else {
                Toast.makeText(this, "number field cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            for (int i = 0; i < 10; i++) {
                results.add(num * i);
            }

            ListView listView = findViewById(R.id.list_view);

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results);
            listView.setAdapter(adapter);


//            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
//            // Pass data to the other activity
//            intent.putExtra("result", results);
//            startActivity(intent);
        });
    }
}