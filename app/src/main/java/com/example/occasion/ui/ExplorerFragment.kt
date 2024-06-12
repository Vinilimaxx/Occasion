package com.example.occasion.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.occasion.R


class ExplorerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explorer, container, false)
    }

}
<selector xmlns:android="http://schemas.android.com/apk/res/android">
<item android:state_selected="true" android:drawable="@drawable/tab_button_selected_background"/>
<item android:drawable="@drawable/tab_button_default_background"/>
</selector>

<shape xmlns:android="http://schemas.android.com/apk/res/android">
<solid android:color="#FFFFFF"/>
<corners android:radius="16dp"/>
</shape>

<shape xmlns:android="http://schemas.android.com/apk/res/android">
<solid android:color="#333333"/>
<corners android:radius="16dp"/>
</shape>

<shape xmlns:android="http://schemas.android.com/apk/res/android">
<solid android:color="#333333"/>
<corners android:radius="8dp"/>
</shape>

<shape xmlns:android="http://schemas.android.com/apk/res/android">
<solid android:color="#333333"/>
<corners android:radius="8dp"/>
</shape>