package com.example.davita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Create a new project in Android Studio. Build a view that is capable of displaying N number of objects.
 * For this objective, have the view display 10 objects. Have each cell hold unique title and subtitle (Title text and subtitle text is completely up to you).
As you code, please explain all the major steps you are taking.
 */

class MainActivity : AppCompatActivity() {

    private val dataObjectClickListener = View.OnClickListener {
        val dataObject = it.tag as DataObject
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame, DetailFragment.newInstance(dataObject))
            .addToBackStack("DetailFragment")
            .commit()
        frame.visibility = View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDataList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DataAdapter(getList()).apply { onClick = dataObjectClickListener }
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0)
            super.onBackPressed()
        else {
            frame.visibility = View.GONE
            supportFragmentManager.popBackStack()
        }
    }

    private fun getList(): List<DataObject> {
        val list = mutableListOf<DataObject>()
        for (i in 0..10) {
            if (i % 2 == 0)
                list.add(DataObject("Title $i", "Subtitle $i"))
            else
                list.add(DataObject(null, null))
        }
        return list
    }
}
