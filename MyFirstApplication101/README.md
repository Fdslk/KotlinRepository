# First Application
* different views
* layout
* event handler
* data binding
  * help app no need to initialize the variable each time, which can save time.
  * findViewById() find view will create or recreate when it is called.
  * It is a global technology for the whole app, like a reference.
  * how to use it
    * enable data binding in your **build.gradle** file
    ```xml
    android {
      buildFeatures {
        dataBinding true
      }
    }
    ```
    * sync your application
    * move the namespace declaration into layout tag and just keep view properties
    * declare a binding variable for binding the specific layout which you have defined a layout tag. Then using the following code to set data to data binding
    ```kotlin
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
     ```
    * replace the findViewById to binding.idView
  * bind string value from a ```data``` class
