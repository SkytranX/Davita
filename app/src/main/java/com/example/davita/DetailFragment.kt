package com.example.davita

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    companion object {
        fun newInstance(data: DataObject): DetailFragment {
            val bundle = Bundle().apply {
                putParcelable("DATA", data)
            }
            return DetailFragment().apply {
                arguments = bundle
            }
        }
    }

    private lateinit var dataObject: DataObject

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getParcelable<DataObject>("DATA")?.let { dataObject = it }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            tvDetailTitle.text = dataObject.title ?: "NullTitle"
            tvDetailSubtitle.text = dataObject.subTitle ?: "NullSubtitle"
        }
    }

}
