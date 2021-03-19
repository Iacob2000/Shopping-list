package com.aplicatie.listacumparaturi20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class MainActivity  extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// go to Add_Activity class when press add button
        add= findViewById(R.id.floatingActionButton);
        add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Add_Activity.class);
            startActivity(intent);
        });
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<Model_class> model_class = databaseHelperClass.getProductsList();

        if (model_class.size() > 0){
            Adapter_class adapter_class = new Adapter_class(model_class,MainActivity.this);
            recyclerView.setAdapter(adapter_class);
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }




    }
}


