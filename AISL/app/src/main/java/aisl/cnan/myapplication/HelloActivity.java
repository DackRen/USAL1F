package aisl.cnan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by licencep on 02/11/16.
 */
public class HelloActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        TextView helloText = (TextView)findViewById(R.id.hello);
        String loginUser = getIntent().getExtras().getString("loginUser", "0");
//        double loginPass = getIntent().getExtras().getDouble("loginPass", 0);

        helloText.setText("hello MR."+loginUser+", welcome");

    }

}
