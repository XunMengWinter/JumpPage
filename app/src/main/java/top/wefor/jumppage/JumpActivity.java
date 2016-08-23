package top.wefor.jumppage;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ScrollView;

/**
 * Created on 16/8/23.
 *
 * @author ice
 */
public class JumpActivity extends AppCompatActivity {

    AppBarLayout mAppBarLayout;
    ScrollView mScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        WindowManager.LayoutParams p = getWindow().getAttributes();     //获取对话框当前的参数值
        p.width = size.x;
        p.height = size.y;
        p.alpha = 1.0f;                                                 //设置本身透明度
        p.dimAmount = 0.6f;                                             //设置黑暗度
        getWindow().setAttributes(p);
        getWindow().setGravity(Gravity.BOTTOM);

        findViewById(R.id.empty_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);

        mScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = mScrollView.getScrollY(); // For ScrollView
                int scrollX = mScrollView.getScrollX(); // For HorizontalScrollView
                // DO SOMETHING WITH THE SCROLL COORDINATES
                Log.i("xyz", scrollY + "");
                if (scrollY > mEmptyHeight) {
                    if (!isAppBarVisible)
                        showAppBar();
                } else {
                    if (isAppBarVisible)
                        hideAppBar();
                }
            }
        });

        mEmptyHeight = getResources().getDimensionPixelSize(R.dimen.height_empty_view);
        mAppBarHeight = getResources().getDimensionPixelSize(R.dimen.height_app_bar);
        hideAppBar();
    }

    boolean isAppBarVisible;

    int mEmptyHeight, mAppBarHeight;

    public void showAppBar() {
        Log.i("xyz", "showAppBar");
        isAppBarVisible = true;
        mAppBarLayout.setVisibility(View.VISIBLE);
        mAppBarLayout.animate().translationY(0);
    }

    public void hideAppBar() {
        isAppBarVisible = false;
        Log.i("xyz", "hideAppBar");
        mAppBarLayout.animate().translationY(0 - mAppBarHeight);
    }

}
