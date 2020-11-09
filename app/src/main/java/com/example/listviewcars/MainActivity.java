package com.example.listviewcars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Car> myCars = new ArrayList<Car>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myCars.add(new Car(R.drawable.photo1, "Ford Focus", "20.000 Dt "));
        myCars.add(new Car(R.drawable.photo2, "clio", "30.000 Dt "));
        myCars.add(new Car(R.drawable.photo3, "Citroen", "29.000 Dt "));
        myCars.add(new Car(R.drawable.photo4, "jaguar", "120.000 Dt "));

        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.car);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView < ? > parent, View viewClicked, int
                    position, long id){
                Car clickedCar = myCars.get(position);
                String message = "You clicked position " + position + " Which is car Name"+ clickedCar.getName();
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
        private class MyListAdapter extends ArrayAdapter<Car> {
            public MyListAdapter() {
                super(getApplicationContext(), R.layout.item_view, myCars);
            }

            public View getView(int position, View convertView, ViewGroup parent) {

                View itemView = convertView;
                if (itemView == null) {
                    itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
                }

                Car currentCar = myCars.get(position);

                ImageView imageView = (ImageView)itemView.findViewById(R.id.imageView);
                imageView.setImageResource(currentCar.getIconID());
                TextView TextCar = (TextView) itemView.findViewById(R.id.textCar);
                TextCar.setText(currentCar.getName());
                TextView TextPrice =(TextView)itemView.findViewById(R.id.priceText);
                TextPrice.setText(currentCar.getPrice());
                return itemView;
            }
        }


}