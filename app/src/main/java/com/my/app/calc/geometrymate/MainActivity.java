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

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        Map<Integer, List<View>> shapeInputs = new HashMap<>();
        shapeInputs.put(1, Arrays.asList(et_rectangle_height, et_rectangle_width));
        shapeInputs.put(2, Collections.singletonList(et_circle));
        shapeInputs.put(3, Arrays.asList(et_triangle_base, et_triangle_height));


        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //  all fields are hide
                for (List<View> inputs : shapeInputs.values()) {
                    for (View v : inputs) {
                        v.setVisibility(View.GONE);
                    }

                    List<View> viewsToshow = shapeInputs.get(position);
                    if (viewsToshow != null) {
                        for (View v : viewsToshow) {
                            v.setVisibility(view.VISIBLE);
                        }
                    }


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

                if (index == 0) {

                    Toast.makeText(MainActivity.this, "Please select a shape", Toast.LENGTH_SHORT).show();

                    return;
                }

                double area = 0;

                Shape s;
                switch (index) {
                    case 1:
                        s = Shape.RECTANGLE;
                        break;
                    case 2:
                        s = Shape.CIRCLE;
                        break;
                    case 3:
                        s = Shape.TRIANGLE;
                        break;
                    default:
                        s = null;
                        break;
                }

                switch (s) {
                    case RECTANGLE:


                        //Rectangle
                        String h1 = et_rectangle_height.getText().toString().trim();
                        String w1 = et_rectangle_width.getText().toString().trim();

                        if (!TextUtils.isEmpty(h1) && !TextUtils.isEmpty(w1)) {

                            double rect_width = Double.parseDouble(w1);
                            double rect_height = Double.parseDouble(h1);

                            area = AreaCalculator.rectangle(rect_width, rect_height);
                            ;

                        } else {
                            Toast.makeText(MainActivity.this, "Please enter both height and width for rectangle.", Toast.LENGTH_SHORT).show();
                        }

                        break;

                    case CIRCLE:
                        //Circle
                        String r = et_circle.getText().toString().trim();
                        if (!TextUtils.isEmpty(r)) {

                            double cir_radius = Double.parseDouble(r);

                            area = AreaCalculator.circle(cir_radius);

                        } else {
                            Toast.makeText(MainActivity.this, "Please enter radius for circle.", Toast.LENGTH_SHORT).show();
                        }

                        break;

                    case TRIANGLE:

                        //Triangle

                        String th = et_triangle_height.getText().toString().trim();
                        String b = et_triangle_base.getText().toString().trim();
                        if (!TextUtils.isEmpty(th) && !TextUtils.isEmpty(b)) {

                            double tri_height = Double.parseDouble(th);
                            double tri_base = Double.parseDouble(b);

                            area = AreaCalculator.triangle(tri_base, tri_height);
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter both base and height for triangle.", Toast.LENGTH_SHORT).show();
                        }
                        break;


                }
                areas_txt_result.setVisibility(View.VISIBLE);

                DecimalFormat df = new DecimalFormat("#.##");


                areas_txt_result.setText(df.format(area) + " m² ");
            }
        });
    }
}
