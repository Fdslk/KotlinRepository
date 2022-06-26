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
    * modify activity_main.xml
      * set navGraph
      * set defaultNavHost (will intercept system back button)
    * add fragment to navigation graph: adding a click event can help to jump to other page
      * click add new destination (if you cannot preview the fragment, after you add this to your navigation, you can add ```tools:layout="@layout/fragment_title"```)
