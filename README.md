# MDetect

MDetect is yet another library for displaying Burmese texts for Android.

<img src="Screenshot_Zawgyi.png" width="300">        <img src="Screenshot_Unicode.png" width="300">

Zawgyi device and Unicode device

##How it works

MDetect detects the device's font i.e. whether the user is using Unicode or Zawgyi by drawing က္က and compare the width with က. It doesnt embed any font and convert the text to Zawgyi if the user is using Zawgyi and it doesn't effect the performance of the app much.

##Download
Gradle:
```groovy
compile 'myatminsoe.mdetect.android:mdetect-android:1.0'
```
or Maven:
```xml
<dependency>
  <groupId>myatminsoe.mdetect.android</groupId>
  <artifactId>mdetect-android</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```
##How to use

MDetect can be used for deciding whether the user is using Unicode.
```java
if (MDetect.isUnicode()){
  //user is using Unicode
} else {
  //user is using Zawgyi or showing squares
}
```

MDetect have custom views for **TextView**, **EditTexts** and **Buttons**
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="16dp"
    >

  <me.myatminsoe.mdetect.MMTextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:padding="8dp"
      android:text="@string/myanmar_textview"
      android:textColor="@color/grey_900"
      />

  <me.myatminsoe.mdetect.MMEditText
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:hint="@string/myanmar_edittext"
      android:padding="8dp"
      />

  <me.myatminsoe.mdetect.MMButtonView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:onClick="showMyanmarToast"
      android:padding="8dp"
      android:text="@string/myanmar_button"
      />

</LinearLayout>
```

###Setting and Getting Text
use setMMText() and getMMText() instead of setText() and getText() for custom views.

##Toast##
```java
MMToast.makeText(context, "မင်္ဂလာပါ", Toast.LENGTH_LONG).show();
```
See the sample app for more detail.

#License
```
Copyright 2016 Myat Min Soe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
