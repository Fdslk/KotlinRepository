# fragment
* fragment can be used by different activity
* keep the following code which can be used to load fragment content
```kotlin
 override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    val binding = DataBindingUtil.inflate<PlaceholderLayoutBinding>(inflater,
        R.layout.placeholder_layout,container,false)
    return binding.root
} 
```
* navigation
  * how to
    * add navigation dependency
    * add navigation resource file click res->new Resource File->choose type is Navigation
    * create ```navigation host fragment ```
      * should set the attribute "fragment><android:name="androidx.navigation.fragment.NavHostFragment">" 
      * How does NavHostFragment works
        * Each NavHostFragment has a NavController that defines valid navigation within the navigation host. This includes the NavGraph as well as navzigation state such as current location and back stack that will be saved and restored along with the NavHostFragment itself.
    * modify activity_main.xml
      * set navGraph
      * set defaultNavHost (will intercept system back button)
    * add fragment to navigation graph: adding a click event can help to jump to other page
      * click add new destination (if you cannot preview the fragment, after you add this to your navigation, you can add ```tools:layout="@layout/fragment_title"```)
      * add action to connect two different fragment
    * modify system back button behavior in navigation.xml
      * set **PopUp**, this property can specify the back button destination
      * set **PopupToInclusive**, this property is a boolean value. If it is set as **false** or not set, it will keep the popup specified destination. Otherwise, it will remove all the destination actions.
    * add up button
      * This button has the same behavior like the system back button
      * Don't need to make a new one from zero
    * navigation drawer
      * It likes a panel which is appeal to the side of the user screen. 
      * how to
        * create navigation_menu
        * wrap all the elements by the **<DrawerLayout>**
        * when swipe your screen from left to right, the menu navigation will be represented
* share content from internal app
  * how to pass some arguments safer
    * using plugin ```Safe Args```, it will create a ```NavDirection``` class which can pass arguments between fragment.
    * tips: only add ```dependencies``` block in ```buildscript``` can work
    ```xml
     buildscript {
        ....
        dependencies {}
        ....
      }
      ```
    * adding arguments in related fragment
    * using NavDirections to pass parameters
    * receive arguments ```val args = GameWonFragmentArgs.fromBundle(requireArguments())```
    * Intent
      * implicit, generally speaking, you don't need to know who executes this actions
      * explicit

[more details](https://developer.android.com/codelabs/kotlin-android-training-add-navigation#11)
