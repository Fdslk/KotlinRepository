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
# data binding with viewModel and liveData
* how to integrate with viewModel
  * why?
    * it can unwrap the architecture dependency
      * Views is defined by XML layout
      * data of views is saved by viewModel
      * there is a UI controller between both of them.
    * not need to pass data to UI controller
  * operations
    * viewModel passes data to View XML by data binding directly
    * add data->variable->binding viewModel with view XML
* how to integrate with liveData
  * bind lifeCycle in Fragment class
  * set value in XML by viewModel directly
