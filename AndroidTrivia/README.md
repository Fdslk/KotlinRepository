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