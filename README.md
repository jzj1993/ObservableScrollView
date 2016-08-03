# ObservableScrollView

ScrollView with scroll state change observer


## Usage

gradle

```groovy
dependencies {
    ...
    compile 'com.jzj.view:ObservableScrollView:0.0.2'
}
```

project
```xml
<?xml version="1.0" encoding="utf-8"?>
<com.jzj.view.ObservableScrollView
	xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/scroll_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!" />
</com.jzj.view.ObservableScrollView>
```

```java
mScrollView = (ObservableScrollView) findViewById(R.id.scroll_view);

mScrollView.setOnScrollListener(new OnScrollListener() {
    @Override
    public void onScrollStateChanged(ObservableScrollView view, int scrollState) {
        switch (scrollState) {
            case SCROLL_STATE_IDLE:
                Log.d("MainActivity", "idle");
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.d("MainActivity", "touch scroll");
                break;
            case SCROLL_STATE_FLING:
                Log.d("MainActivity", "fling");
                break;
        }
    }

    @Override
    public void onScroll(ObservableScrollView view, boolean isTouchScroll, int l, int t, int oldl, int oldt) {
        Log.d("MainActivity", "onScroll");
    }
});
```
