package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Buttons extends Activity {
    private Button chicken;
    private Button carrots;
    private Button spaghetti;
    private Button porkchops;
    private Button steak;
    private Button cheese;
    private Button milk;
    private Button corn;

    public static final String EXTRA_REPLY = "ca.nbcc.shoppinglist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);

        chicken = findViewById(R.id.chickenButton);
        carrots = findViewById(R.id.carrotsButton);
        spaghetti = findViewById(R.id.spaghettiButton);
        porkchops = findViewById(R.id.porkchopsButton);
        steak = findViewById(R.id.steakButton);
        cheese = findViewById(R.id.cheeseButton);
        milk = findViewById(R.id.milk);

    }


    public void addToList(View view){
        try {
            Button btnPressed = (Button) view;

            //Getting the item that the user clicked on
            String item = btnPressed.getText().toString();

            Intent reply = new Intent();
            reply.putExtra(EXTRA_REPLY, item);
            setResult(RESULT_OK, reply);
        }catch(Exception e){
            Log.d("Error", e.getMessage());
        }
    }
}
