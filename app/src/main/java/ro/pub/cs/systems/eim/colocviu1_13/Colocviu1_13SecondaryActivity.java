package ro.pub.cs.systems.eim.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {
    private Button cancelButton;
    private Button registerButton;
    private TextView textView;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            setResult(Activity.RESULT_CANCELED, new Intent());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);

        cancelButton = findViewById(R.id.cancel);
        registerButton = findViewById(R.id.register);
        textView = findViewById(R.id.content);

        Intent intent = getIntent();
        if (intent != null) {
            String actions = intent.getStringExtra("ro.pub.cs.systems.eim.colocviu1_13.Colocviu1_13SecondaryActivity.TEXT_KEY");
            if (actions != null) {
                textView.setText(actions);
            } else {
                Toast.makeText(this, "text", Toast.LENGTH_LONG).show();
            }
        }

        cancelButton.setOnClickListener(buttonClickListener);
        registerButton.setOnClickListener(buttonClickListener);
    }
}
