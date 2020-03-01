package gr.academic.city.sdmd.intents;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name.to.greet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        TextView greetingTextView = (TextView) findViewById(R.id.tv_greeting);
        greetingTextView.setText("Hello " + getIntent().getStringExtra(EXTRA_NAME));
    }
}
