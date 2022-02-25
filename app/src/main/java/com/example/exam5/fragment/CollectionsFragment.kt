package com.example.exam5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam5.R
import com.example.exam5.adapter.CollectonAdapter
import com.example.exam5.model.Collection


class CollectionsFragment : Fragment() {

    private lateinit var rvCollection: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_collections, container, false)

        initViews(view)

        return view
    }

    private fun initViews(view: View){
        rvCollection = view.findViewById(R.id.rv_collection)
        rvCollection.layoutManager = GridLayoutManager(requireContext(), 1)

        refreshCollectionAdapter(getAllCollections())
    }

    private fun refreshCollectionAdapter(items : ArrayList<Collection>){
        rvCollection.adapter = CollectonAdapter(requireContext(), items)
    }

    private fun getAllCollections() : ArrayList<Collection> {
        val item : ArrayList<Collection> = ArrayList()

        item.add(Collection(R.drawable.img_car, "Cars"))
        item.add(Collection(R.drawable.img_car, "Cars"))
        item.add(Collection(R.drawable.img_car, "Cars"))
        item.add(Collection(R.drawable.img_car, "Cars"))
        item.add(Collection(R.drawable.img_car, "Cars"))
        item.add(Collection(R.drawable.img_car, "Cars"))

        return item
    }
}