package ro.pub.cs.systems.eim.practicaltest01var10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class PracticalTest01Var10MainActivity extends AppCompatActivity {
    private Button AddButton = null;
    private Button ComputeButton = null;
    private EditText NextTermEditText = null;
    private TextView AllTermsTextView = null;
    private String sum = null;
    private StringTokenizer tokenizer = null;
    private Integer number_sum = 0;
    private String number = null;
    private Integer sum_sum = 0;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.AddButton:
                    number = NextTermEditText.getText().toString();
                    sum = AllTermsTextView.getText().toString();
                    if(sum.length() == 0) {
                        sum += number;
                        AllTermsTextView.setText(sum);
                    } else {
                        sum += " + " + number;
                        AllTermsTextView.setText(sum);
                    }
                    NextTermEditText.setText("");
                    break;
                case R.id.ComputeButton:
                    sum = AllTermsTextView.getText().toString();
                    tokenizer = new StringTokenizer(sum);
                    while(tokenizer.hasMoreElements()) {
                        number_sum =Integer.parseInt(tokenizer.nextToken("+ "));
                        sum_sum += number_sum;
                    }
                    Toast.makeText(getApplicationContext(), Integer.toString(sum_sum), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var10_main);

        AddButton = findViewById(R.id.AddButton);
        ComputeButton = findViewById(R.id.ComputeButton);
        NextTermEditText = findViewById(R.id.NextTermEditText);
        AllTermsTextView = findViewById(R.id.AllTermsTextView);

        AddButton.setOnClickListener(buttonClickListener);
        ComputeButton.setOnClickListener(buttonClickListener);
    }
}
