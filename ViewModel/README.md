# viewModel
* what?
  * It is used to store the UI-related data
  * each fragment owns itself viewModel
  * fragment will be created several times when the configurations are changed. However, viewModel just is created for once.
* How to
  * restore app state
  * add dependency in app level build.gradle ```implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'```
  * init viewModel in related fragment by ```ViewModelProvider```, extract existing UI data
* [recommended layer architecture](https://developer.android.com/topic/architecture)
  * UI layer
    * UI element, for Views and Jetpack Compose
    * state holder, like viewModel classes, which can hold data, expose it to the UI, and handle logic.
  * Domain layer: for writing some complex business logic
  * Data layer
    * repository, 
    * data sources, a file, network resource, or a local database
# liveData
* What?
  * liveData is a observable data holder
    * detect wrapped data changes
    * is wrapper which can be used with any data
    * can be associated with a liecycleOwner(activity and fragment), only updates the observer in active state (STARTED and RESUMED)
    * mutableLive can allow user to edit its value rather than liveData is ReadOnly
      * liveData type value is exposed to other classes, which can restrict the using scope
