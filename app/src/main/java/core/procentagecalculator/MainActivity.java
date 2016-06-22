package core.procentagecalculator;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import static core.procentagecalculator.R.*;


public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageTxt;
    EditText numberTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(id.toolbar);
        setSupportActionBar(toolbar);

        totalTextView = (TextView) findViewById(id.totalTextView);
        percentageTxt = (EditText) findViewById(id.percentageTxt);
        numberTxt = (EditText) findViewById(id.numberTxt);

        Button calcBtn = (Button) findViewById(id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                float percentage = Float.parseFloat(percentageTxt.getText().toString());
                float dec = percentage / 100;
                float total = dec * Float.parseFloat(numberTxt.getText().toString());
                totalTextView.setText(Float.toString(total));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.customemenu,menu);
        MenuItem item = menu.findItem(id.item1);
        Button itemBt = (Button)item.getActionView();
        if(itemBt!=null){
           // Typeface fontU = Typeface.createFromAsset(this.getAssets(),"Hanuman.ttf");
          //  itemBt.setTypeface(fontU);
            itemBt.setText("                ");
            itemBt.setTextColor(Color.WHITE);
            itemBt.setBackgroundColor(Color.TRANSPARENT);
            Drawable icon = getResources().getDrawable(drawable.perclogo);
            itemBt.setCompoundDrawablesWithIntrinsicBounds(icon,null,null,null);

        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
