# Factor.HomePager

HomePager is an implementation of Android ViewPager populated by Views/ViewGroups instead of fragments. 


[![](https://jitpack.io/v/Valkriaine/Factor.svg)](https://jitpack.io/#Valkriaine/Factor)



Add HomePager to your project:

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
        implementation 'com.github.Valkriaine:Factor:1.1'
   }
 ```


Usage:

Add Views inside HomePager:
```xml
<com.valkriaine.factor.HomePager
                android:id="@+id/home_pager"
                android:layout_width="match_parent"
                android:layout_height="match_parent">
  
  
 <androidx.constraintlayout.widget.ConstraintLayout
                    android:id="@+id/first_page"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"/>
   
 <androidx.constraintlayout.widget.ConstraintLayout
                    android:id="@+id/second_page"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"/>
   
  
  </com.valkriaine.factor.HomePager>
   ```
   
In MainActivity.java, add the views to include in the HomePager,
simply pass in the view and its position
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    HomePager homePager = findViewById(R.id.home_pager);
    homePager.addView(findViewById(R.id.first_page), 0);
    homePager.addView(findViewById(R.id.second_page), 1);
}

 ```
or without its position, this will add the view at the next position available 
 ```java
    homePager.addView(findViewById(R.id.first_page));

 ```
