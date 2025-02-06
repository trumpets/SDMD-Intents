package gr.academic.city.sdmd.intents;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name.to.greet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        TextView greetingTextView = findViewById(R.id.tv_greeting);
        greetingTextView.setText("Hello " + getIntent().getStringExtra(EXTRA_NAME));
    }
}
