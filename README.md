# Factor.Library

HomePager is an implementation of Android ViewPager populated by Views/ViewGroups instead of fragments. 

BouncyRecyclerView is a custom RecyclerView that supports IOS style overscroll animation



[![](https://jitpack.io/v/Valkriaine/Factor.svg)](https://jitpack.io/#Valkriaine/Factor)




Add Factor.Library to your project:

In your project build.gradle:
```gradle
    allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
   }
  ```
  
  
In your app module build.gradle:
```
   dependencies {
        implementation 'com.github.Valkriaine:Factor:1.2'
   }
 ```


Usage:
BouncyRecyclerView: 

<img src="./images/BouncyRecyclerViewDemo.gif"/>




Use as normal RecyclerView. Place it in your layout:

```xml
<com.valkriaine.factor.BouncyRecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:fling_bounce_animation_size=".5"
        app:overscroll_bounce_animation_size=".5"/>
```

```fling_bounce_animation_size``` specifies the magnitude of overscroll effect for fling, default is 0.5 if no value is given
```overscroll_bounce_animation_size``` specifies the magnitude of overscroll effect for drag overscroll, default is 0.5 if no value is given

set up layout manager and adapter: 
```kotlin
   recycler_view.adapter = myAdapter
   recycler_view.layoutManager = LinearLayoutManager(this)
```

