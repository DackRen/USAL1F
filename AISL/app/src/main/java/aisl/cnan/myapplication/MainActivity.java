package aisl.cnan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        button = (Button)findViewById(R.id.button);
        //regiest listener
        button.setOnClickListener(lAuditeurDuBouton);
    }
    // rewrite listener
    private View.OnClickListener lAuditeurDuBouton = new View.OnClickListener() {
        public void onClick(View v) {
            Context leContexte=v.getContext();
            if(username.getText().toString().length()<3||password.getText().toString().length()<3){
                //create a new dialog to the screen by toast (context,message,??)
                Toast.makeText(leContexte, "too short", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(leContexte, "good", Toast.LENGTH_LONG).show();
                //create a intent and move to other activity
                Intent i =new Intent(MainActivity.this,HelloActivity.class);
                //send a message to other part by intent ("identified key word","message")
                i.putExtra("loginUser", username.getText().toString());
                i.putExtra("loginPass", password.getText().toString());
                startActivity(i);

            }

        }};
/*
*other way to listenr event
*/
//    public void onClickEmpiler(View v){
//        Context leContexte=v.getContext();
//        if(username.getText().toString().length()<3||password.getText().toString().length()<3){
//            //create a new dialog to the screen by toast (context,message,??)
//            Toast.makeText(leContexte, "too short", Toast.LENGTH_LONG).show();
//        }
//        else{
//            Toast.makeText(leContexte, "good", Toast.LENGTH_LONG).show();
//            //create a intent and move to other activity
//            Intent i =new Intent(MainActivity.this,HelloActivity.class);
//            //send a message to other part by intent ("identified key word","message")
//            i.putExtra("loginUser", username.getText().toString());
//            i.putExtra("loginPass", password.getText().toString());
//            startActivity(i);
//
//        }
//    }

    @Override
    protected void onStart(){
        super.onStart();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }
    @Override
    protected void onPause(){
        super.onPause();

    }
    @Override
    protected void onStop(){
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }



}
