Sample app to reproduce a crash when using CleverTap with Android Gradle Plugin 3.3.0.

Steps to reproduce:

* Build the app: `./gradlew clean assembleDebug`
* Install the app
* Launch the app "CleverTapVerifyError"
* Expected behavior: 
  - The app launches displaying "Hello World!"
  - The following log appears in logcat: `CleverTapVerifyErrorApp: got clevertap instance com.clevertap.android.sdk.CleverTapAPI@82b9d89`
* Actual behavior: crash:

```
01-15 16:28:34.556 28244 28244 E AndroidRuntime: FATAL EXCEPTION: main
01-15 16:28:34.556 28244 28244 E AndroidRuntime: Process: com.example.clevertapverifyerror, PID: 28244
01-15 16:28:34.556 28244 28244 E AndroidRuntime: java.lang.VerifyError: Verifier rejected class com.clevertap.android.sdk.InAppFCManager: int[] com.clevertap.android.sdk.InAppFCManager.getInAppCountsFromPersistentStore(java.lang.String) failed to verify: int[] com.clevertap.android.sdk.In
AppFCManager.getInAppCountsFromPersistentStore(java.lang.String): [0x3B] register v2 has type Conflict but expected Integer (declaration of 'com.clevertap.android.sdk.InAppFCManager' appears in /data/app/com.example.clevertapverifyerror-2/base.apk)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at com.clevertap.android.sdk.CleverTapAPI.<init>(CleverTapAPI.java:225)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at com.clevertap.android.sdk.CleverTapAPI.instanceWithConfig(CleverTapAPI.java:524)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at com.clevertap.android.sdk.CleverTapAPI.getDefaultInstance(CleverTapAPI.java:502)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at com.example.clevertapverifyerror.MainActivity.onCreate(MainActivity.java:16)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.app.Activity.performCreate(Activity.java:6915)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1123)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2746)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2864)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.app.ActivityThread.-wrap12(ActivityThread.java)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1567)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.os.Handler.dispatchMessage(Handler.java:105)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.os.Looper.loop(Looper.java:156)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at android.app.ActivityThread.main(ActivityThread.java:6523)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at java.lang.reflect.Method.invoke(Native Method)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:942)
01-15 16:28:34.556 28244 28244 E AndroidRuntime:        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:832)
01-15 16:28:34.558  1291  3061 W ActivityManager:   Force finishing activity com.example.clevertapverifyerror/.MainActivity
```

Note: changing the version of android gradle plugin to 3.2.1 makes the crash go away.
