package gr.academic.city.sdmd.intents;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int CHOOSE_COLOR_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_say_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.txt_name)).getText().toString();

                Intent greetingsIntent = new Intent(MainActivity.this, GreetingActivity.class);
                greetingsIntent.putExtra(GreetingActivity.EXTRA_NAME, name);

                startActivity(greetingsIntent);
            }
        });

        findViewById(R.id.btn_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chooseColorIntent = new Intent(MainActivity.this, ColorChooserActivity.class);
                startActivityForResult(chooseColorIntent, CHOOSE_COLOR_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CHOOSE_COLOR_REQUEST) {
            if (resultCode == RESULT_OK) {
                // We got a color!
                int chosenColor = data.getIntExtra(ColorChooserActivity.EXTRA_COLOR, -1);
                findViewById(R.id.top_layout).setBackgroundColor(chosenColor);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
