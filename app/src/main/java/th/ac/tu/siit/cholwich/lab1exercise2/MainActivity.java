package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View v) {
        //Get the unit to convert from
        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        int idFrom = rgFrom.getCheckedRadioButtonId();

        //Get the unit to convert to
        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int idTo = rgTo.getCheckedRadioButtonId();

        //Get the input value
        EditText etInput = (EditText)findViewById(R.id.etInput);
        double input = Double.parseDouble(etInput.getText().toString());

        //Initial the output value to the input value
        double output = input;

        //Convert the temperature value
        switch (idFrom) {
            case R.id.rbFrmC:
                switch (idTo) {
                    case R.id.rbToF:
                        output = input * 9.0 / 5.0 + 32.0;
                        break;
                    case R.id.rbToK:
                        output = input + 273.15;
                        break;
                }
                break;
            case R.id.rbFrmF:
                switch (idTo) {
                    case R.id.rbToC:
                        output = (input - 32.0) * 5.0 / 9.0;
                        break;
                    case R.id.rbToK:
                        output = (input + 459.67) * 5.0 / 9.0;
                        break;
                }
                break;
            case R.id.rbFrmK:
                switch (idTo) {
                    case R.id.rbToC:
                        output = input - 273.15;
                        break;
                    case R.id.rbToF:
                        output = input * 9.0 / 5.0 - 459.67;
                        break;
                }
                break;
        }

        //Display the output
        TextView tv = (TextView)findViewById(R.id.tvOutput);
        tv.setText(String.format("%.2f", output));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
