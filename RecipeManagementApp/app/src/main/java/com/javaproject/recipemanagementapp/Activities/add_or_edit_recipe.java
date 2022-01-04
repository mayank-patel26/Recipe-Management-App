package com.javaproject.recipemanagementapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.javaproject.recipemanagementapp.R;

public class add_or_edit_recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_recipe);
        setBulletPoints();
    }
    void setBulletPoints()
    {
        EditText edtNoteContent = findViewById(R.id.ingredients_edit_text);

        edtNoteContent.addTextChangedListener(new TextWatcher(){
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
                            edtNoteContent.setText(text);
                            edtNoteContent.setSelection(edtNoteContent.getText().length());
                        }
                        if (text.toString().endsWith("\n")) {
                            text = text.toString().replace("\n", "\n. ");
                            text = text.toString().replace(". .", ".");
                            edtNoteContent.setText(text);
                            edtNoteContent.setSelection(edtNoteContent.getText().length());
                        }
                    }
                }
            }
        });
    }
}