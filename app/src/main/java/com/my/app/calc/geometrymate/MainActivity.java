package com.my.app.calc.geometrymate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner sp_shapes = findViewById(R.id.sp_shapes);

        //Rectangle
        EditText et_rectangle_height = findViewById(R.id.et_rectangle_height);
        EditText et_rectangle_width = findViewById(R.id.et_rectangle_width);

        //circle
        EditText et_circle = findViewById(R.id.et_circle);

        // Triangle
        EditText et_triangle_base = findViewById(R.id.et_triangle_base);
        EditText et_triangle_height = findViewById(R.id.et_triangle_height);

        Button btn_areas_calc = findViewById(R.id.btn_areas_calc);
        TextView areas_txt_result = findViewById(R.id.areas_txt_result);

        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;
                    case 1:
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_rectangle_width.setVisibility(View.VISIBLE);
                        et_circle.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;
                    case 2:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;
                    case 3:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.VISIBLE);
                        et_triangle_height.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_areas_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = sp_shapes.getSelectedItemPosition();
                double area = 0;
                switch (index) {
                    case 1:
                        //Rectangle
                        String h1 = et_rectangle_height.getText().toString();
                        String w1 = et_rectangle_width.getText().toString();
                        if (!TextUtils.isEmpty(h1) && !TextUtils.isEmpty(w1)) {
                            double rect_width = Double.parseDouble(w1);
                            double rect_height = Double.parseDouble(h1);
                            area = rect_width * rect_height;
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter both height and width for rectangle.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        //Circle
                        String r = et_circle.getText().toString();
                        if (!TextUtils.isEmpty(r)) {
                            double cir_radius = Double.parseDouble(r);
                            area = Math.PI * Math.pow(cir_radius, 2);
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter radius for circle.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3:
                        //Triangle
                        String th = et_triangle_height.getText().toString();
                        String b = et_triangle_base.getText().toString();
                        if (!TextUtils.isEmpty(th) && !TextUtils.isEmpty(b)) {
                            double tri_height = Double.parseDouble(th);
                            double tri_base = Double.parseDouble(b);
                            area = 0.5 * tri_base * tri_height;
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter both base and height for triangle.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

                areas_txt_result.setText(String.valueOf(area));
            }
        });
    }
}
