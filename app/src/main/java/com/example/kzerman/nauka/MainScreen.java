package com.example.kzerman.nauka;

        import android.app.ActivityOptions;
        import android.content.Intent;
        import android.opengl.Visibility;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.ActionProvider;
        import android.view.View;
        import android.view.inputmethod.InputMethodManager;
        import android.widget.TextView;

        import static android.graphics.Color.GREEN;
        import static com.example.kzerman.nauka.R.id.IncorrectPass;
        import static com.example.kzerman.nauka.R.id.Pass;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
    public void Kliknij (View v){
        TextView haslo = (TextView) findViewById(Pass);
        TextView incorrectPass = (TextView) findViewById(IncorrectPass);
        String hasloo = haslo.getText().toString();
        Intent myIntent = new Intent(this, Menu.class);

        if (hasloo.equals("xD")) {
      startActivity(myIntent);

            incorrectPass.setVisibility(View.INVISIBLE);
        }

        else {
            hideSoftKeyboard();
            incorrectPass.setVisibility(View.VISIBLE);

        }
    }
    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

}
