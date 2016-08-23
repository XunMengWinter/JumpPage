package top.wefor.jumppage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

/**
 * Created on 16/8/23.
 *
 * @author ice
 */
public class MainActivity extends AppCompatActivity {

    Button mJumpBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJumpBtn = (Button) findViewById(R.id.jump_btn);
        mJumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, JumpActivity.class));
            }
        });
    }
}
