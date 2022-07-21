# How use local database in app
* make user experience more comfortable when your app cannot access to the internet. It also can persist data in your local machine.
* use annotation to create entity
  * **@Entity** for creating table and defining table name
  * **@PrimaryKey** define the primary key
  * **@ColumnInfo** define the column name in the table
* use **@Dao** to create query interface: ***data access object (DAO)***, which is used to communicate with local DB
  * Dao has provided some basic interface like update, insert, Query, etc.
* using **@Database** to create a new database or get a existing database
* 

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
  ```android:name="MainApplication"```
* add annotation for viewModel injection **@HiltViewModel**
* add annotation **@inject** for being injected construct, filed, method, etc.
* add annotation **AndroidEntryPoint** in Fragment or Activity who needs to use DI data
* add dependency ```implementation 'androidx.fragment:fragment-ktx:1.5.0'``` in app level for view Model provider
  * val viewModel: SleepTrackerViewModel by viewModels()
* add custom DI module
  * using the **@Module** annotation to mark the class as a DI class
  * using the **@InstallIn(SingletonComponent::class)** to define provider life cycle
  * using **@Provides** to annotate the method is related to the specific module
