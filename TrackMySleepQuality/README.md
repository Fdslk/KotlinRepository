# How use local database in app

## traditional Factory to generate viewModel
* add viewModel Factory to generate a params passing viewModel
* implement ```ViewModelProvider.Factory``` interface
* override create method
* usage
  * ```ViewModelProvider(this).get(ViewModel::class.java)```
* tip
  * if error occur to you
    * Inheritance from an interface with '@JvmDefault' members is only allowed with -Xjvm-default option
    * add the following section in app leve build.gradle
        ```
        android {
            ...
            kotlinOptions {
                ...
                freeCompilerArgs += [
                         "-Xjvm-default=all",
                ]
            }
        }
        ```

## DI to generate viewModel
* add dependency in app level build.gradle
  * ```
    // hilt
    implementation "com.google.dagger:hilt-android:2.38.1"
    kapt "com.google.dagger:hilt-android-compiler:2.38.1"
    ```
* add plugin in app level
  * ```id 'dagger.hilt.android.plugin'```
* add dependency in project level
  * ```classpath "com.google.dagger:hilt-android-gradle-plugin:2.38.1"```
* add hilt application entry
  ```kotlin
  @HiltAndroidApp
  class MainApplication: Application() {}
  ```
* add MainApplication to manifest
  * 
  ```android:name=".app.src.main.java.MainApplication"```
* add annotation for viewModel injection **@HiltViewModel**
* add annotation **@inject** for being injected construct, filed, method, etc.
* add annotation **AndroidEntryPoint** in Fragment or Activity who needs to use DI data
* add dependency ```implementation 'androidx.fragment:fragment-ktx:1.5.0'``` in app level for view Model provider
  * val viewModel: SleepTrackerViewModel by viewModels()