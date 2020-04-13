package ro.pub.cs.systems.eim.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_13MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button northButton;
    private Button southButton;
    private Button eastButton;
    private Button westButton;

    private Integer nrPressedButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String text;
            switch (v.getId()) {
                case R.id.north:
                    text = textView.getText().toString();
                    if (!text.equals("")) {
                        text = text + ", ";
                    }
                    text += "north";
                    textView.setText(text);
                    nrPressedButton++;
                    break;
                case R.id.south:
                    text = textView.getText().toString();
                    if (!text.equals("")) {
                        text = text + ", ";
                    }
                    text += "south";
                    textView.setText(text);
                    nrPressedButton++;
                    break;
                case R.id.east:
                    text = textView.getText().toString();
                    if (!text.equals("")) {
                        text = text + ", ";
                    }
                    text += "east";
                    textView.setText(text);
                    nrPressedButton++;
                    break;
                case R.id.west:
                    text = textView.getText().toString();
                    if (!text.equals("")) {
                        text = text + ", ";
                    }
                    text += "west";
                    textView.setText(text);
                    nrPressedButton++;
                    break;
                case R.id.secondActivity:
                    Intent intent = new Intent("ro.pub.cs.systems.eim.colocviu1_13.Colocviu1_13SecondaryActivity");
                    intent.putExtra("ro.pub.cs.systems.eim.colocviu1_13.Colocviu1_13SecondaryActivity.TEXT_KEY", textView.getText());
                    startActivityForResult(intent, 2017);

                    nrPressedButton = 0;
                    textView.setText("");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            nrPressedButton = 0;
        } else {
            if (savedInstanceState.containsKey("NrPressed")) {
                nrPressedButton = savedInstanceState.getInt("NrPressed");
            }
        }

        Log.d("nrPressed", "NrPressed " + nrPressedButton);

        northButton = findViewById(R.id.north);
        southButton = findViewById(R.id.south);
        westButton = findViewById(R.id.west);
        eastButton = findViewById(R.id.east);
        textView = findViewById(R.id.text);

        northButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);

        String actions = textView.getText().toString();
        if (actions.length() > 0) {
            Intent intent = new Intent("ro.pub.cs.systems.eim.colocviu1_13.Colocviu1_13SecondaryActivity");
            intent.putExtra("ro.pub.cs.systems.eim.colocviu1_13.Colocviu1_13SecondaryActivity.TEXT_KEY", actions);
            startActivityForResult(intent, 2017);
        }

    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("PressedNr", nrPressedButton);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("PressedNr")) {
            nrPressedButton = savedInstanceState.getInt("PressedNr");
        }
    }
}
