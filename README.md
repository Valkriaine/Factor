# Factor.Library

HomePager is an implementation of Android ViewPager populated by Views/ViewGroups instead of fragments. 

[HomePager usage](HomePager.md)

BouncyRecyclerView is a custom RecyclerView that supports IOS style overscroll animation

[BouncyRecyclerView usage](BouncyRecyclerView.md)


<img src="./images/BouncyRecyclerViewDemo.gif"/>


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
        implementation 'com.github.Valkriaine:Factor:1.3'
   }
 ```
