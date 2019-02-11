package ca.nbcc.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;

    private ListOfItems cart = new ListOfItems();

    private TextView cartItem1;
    private TextView cartItem2;
    private TextView cartItem3;
    private TextView cartItem4;
    private TextView cartItem5;
    private TextView cartItem6;
    private TextView cartItem7;
    private TextView cartItem8;

    private List<TextView> textviews = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the TextView variables equal to the TextViews
        cartItem1 = findViewById(R.id.listItem1);
        cartItem2 = findViewById(R.id.listItem2);
        cartItem3 = findViewById(R.id.listItem3);
        cartItem4 = findViewById(R.id.listItem4);
        cartItem5 = findViewById(R.id.listItem5);
        cartItem6 = findViewById(R.id.listItem6);
        cartItem7 = findViewById(R.id.listItem7);
        cartItem8 = findViewById(R.id.listItem8);

        //Adding to the list of textviews
        textviews.add(cartItem1);
        textviews.add(cartItem2);
        textviews.add(cartItem3);
        textviews.add(cartItem4);
        textviews.add(cartItem5);
        textviews.add(cartItem6);
        textviews.add(cartItem7);
        textviews.add(cartItem8);


        //If the instance has been saved, load the list
        if(savedInstanceState != null){
            List<ListOfItems.Item> listOfItems = cart.returnItems();

            //Iterating through the list of items in the cart, and filling each textview accordingly
            for(ListOfItems.Item item : listOfItems){
                for(TextView textField : textviews){
                    if(textField.equals("")) {
                        textField.setText(item.getIngredient() + " " + item.getCount());
                        break;
                    }
                }
            }
        }
    }

    protected void displayCart(){
        List<ListOfItems.Item> listOfItems = cart.returnItems();
        //Iterating through the list of items in the cart, and filling each textview accordingly
        for(ListOfItems.Item item : listOfItems){
            for(TextView textField : textviews){
                if(textField.equals("")) {
                    textField.setText(item.getIngredient() + " " + item.getCount());
                    break;
                }
            }
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Test for the right intent reply.
        if (requestCode == TEXT_REQUEST) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(Buttons.EXTRA_REPLY);

                cart.addToCart(item);
                displayCart();
            }
        }
    }


    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        List<ListOfItems.Item> newList = cart.returnItems();
        for(ListOfItems.Item item : newList){
            for(TextView textField : textviews){
                if(textField.equals("")) {
                    textField.setText(item.getIngredient() + " " + item.getCount());
                    outState.putString("reply_text",textField.getText().toString());
                    break;
                }
            }
        }

    }

    protected void redirectToButtons(View view) {
        //Launches the second activity
        Intent intent = new Intent(this, Buttons.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}

