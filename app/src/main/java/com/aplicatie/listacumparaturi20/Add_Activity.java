package com.aplicatie.listacumparaturi20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Add_Activity extends AppCompatActivity {

    EditText et_product;
    Button add,back;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);

        et_product = findViewById(R.id.editText_add);
        add = findViewById(R.id.button_add);
        back= findViewById(R.id.button_back);

      back.setOnClickListener(v -> {
          Intent intent = new Intent(Add_Activity.this,MainActivity.class);
          startActivity(intent);
      });
// add data
add.setOnClickListener(v -> {
    String stringProduct = et_product.getText().toString();


    if (stringProduct.length() <=0 ){
        Toast.makeText(Add_Activity.this, "Enter a product plese.", Toast.LENGTH_SHORT).show();
    }else {
        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(Add_Activity.this);
        Model_class model_class= new Model_class(stringProduct);
        databaseHelperClass.addProducts(model_class);

        Toast.makeText(Add_Activity.this, "Add  Successfully", Toast.LENGTH_SHORT).show();
        finish();
        startActivity(getIntent());

        Intent intent = new Intent(Add_Activity.this,MainActivity.class);
        startActivity(intent);
    }
});
// code for ads
        MobileAds.initialize(this, initializationStatus -> {
        });

             mAdView = findViewById(R.id.adView);
             AdRequest adRequest = new AdRequest.Builder().build();
             mAdView.loadAd(adRequest);

            }
}