package com.javaproject.recipemanagementapp;

import android.os.Debug;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Console;
import java.sql.SQLWarning;

public class AddBulletPoints
{
    public static void setBulletPoints(EditText editText, String bullet)
    {
        editText.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable e) {
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
            @Override
            public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter)
            {
                if(text!=null) {
                    if (lengthAfter > lengthBefore) {
                        if (text.toString().length() == 1) {
                            text = bullet+" " + text;
                            editText.setText(text);
                            editText.setSelection(editText.getText().length());
                        }
                        if (text.toString().endsWith("\n")) {
                            text = text.toString().replace("\n", "\n"+bullet+" ");
                            text = text.toString().replace(bullet+" "+bullet, bullet);
                            editText.setText(text);
                            editText.setSelection(editText.getText().length());
                        }
                    }
                }
            }
        });
    }

    public static void setBulletPoints(TextView text,String bullet)
    {
        if(text.getText().toString().contains("\n"))
        {
            text.getText().toString().replaceAll("\n","\n"+bullet+" ");
        }
    }
}
