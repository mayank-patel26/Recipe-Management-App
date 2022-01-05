package com.javaproject.recipemanagementapp.Activities;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.graphics.Rect;
        import android.os.Bundle;
        import android.widget.Button;

        import com.javaproject.recipemanagementapp.R;

public class all_recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipe);
        addOnClicks();
    }

    void addOnClicks()
    {
        Button addButton=findViewById(R.id.add_button);
        addButton.setOnClickListener(view -> {
            Intent intent =new Intent(this,add_or_edit_recipe.class);
            startActivity(intent);
        });
    }
}