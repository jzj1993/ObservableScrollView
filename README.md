# ObservableScrollView

ScrollView with scroll state change observer


## Usage

gradle

```groovy
allprojects {
    repositories {
        ...
        maven {
            url 'https://dl.bintray.com/jzj1993/maven/'
        }
    }
}


dependencies {
    ...
    compile 'com.jzj.view:ObservableScrollView:0.0.1'
}
```

project

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
