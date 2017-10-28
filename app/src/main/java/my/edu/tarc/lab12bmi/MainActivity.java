package my.edu.tarc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editWeight, editHeight;
    private TextView textViewBMI, clearScreen;
    private ImageView imageViewBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking program with UI
        editWeight = (EditText)findViewById(R.id.input_weight);
        editHeight = (EditText)findViewById(R.id.input_height);
        textViewBMI = (TextView)findViewById(R.id.result);
        imageViewBMI = (ImageView) findViewById(R.id.imageView);

    }

    public void displayBMI(View v){
        double bmi, weight, height;

        weight = Double.parseDouble(editWeight.getText().toString());
        height = Double.parseDouble(editHeight.getText().toString()) / 100;


        bmi = weight / (height * height);

        textViewBMI.setText(getString(R.string.result) + " " + String.format("%.2f", bmi));

        if (bmi >= 25.0)
            imageViewBMI.setImageResource(R.drawable.over);
        else if (bmi <= 18.5)
            imageViewBMI.setImageResource(R.drawable.under);
        else
            imageViewBMI.setImageResource(R.drawable.normal);

    }

    public void clearScreen(View v){
        clearScreen = (TextView)findViewById(R.id.result);
        clearScreen.setText(getString(R.string.result) + " ");
        editWeight.setText(" ");
        editHeight.setText(" ");
        imageViewBMI.setImageResource(R.drawable.empty);
    }
}
