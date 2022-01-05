package com.javaproject.recipemanagementapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class AddBulletPoints
{
    public static void setBulletPoints(EditText editText)
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
                            text = ". " + text;
                            editText.setText(text);
                            editText.setSelection(editText.getText().length());
                        }
                        if (text.toString().endsWith("\n")) {
                            text = text.toString().replace("\n", "\n. ");
                            text = text.toString().replace(". .", ".");
                            editText.setText(text);
                            editText.setSelection(editText.getText().length());
                        }
                    }
                }
            }
        });
    }
}
