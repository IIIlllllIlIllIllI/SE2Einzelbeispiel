package com.example.palindrom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_check;
    private TextView textView_result;
    private EditText editText_palindrome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        btn_check=(Button) findViewById(R.id.button_check);
        textView_result=(TextView) findViewById(R.id.textView_result);
        editText_palindrome=(EditText) findViewById(R.id.editText_input);

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp_txt=editText_palindrome.getText().toString();
                if (tmp_txt.trim().length()<1){
                    textView_result.setText(R.string.lbl_inupt_empty);
                }
                else if(tmp_txt.length()<5){
                    textView_result.setText(R.string.lbl_input_too_short);
                }
                else if (checkPalindrome(tmp_txt)){
                    textView_result.setText(R.string.lbl_palindrom_true);
                }
                else{
                    textView_result.setText(R.string.lbl_palindrom_false);
                }
            }
        });
    }

    private boolean checkPalindrome(String palindrome){
        return palindrome.equals(new StringBuilder (palindrome).reverse().toString());
    }
}
