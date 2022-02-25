package com.example.exam5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.exam5.R
import com.example.exam5.adapter.CategoryAdapter
import com.example.exam5.adapter.ItemAdapter
import com.example.exam5.adapter.ViewPagerAdapterHome
import com.example.exam5.model.Category
import com.example.exam5.model.Item
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private lateinit var rvCategory: RecyclerView
    private lateinit var rvItems: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        initViews(view)

        return  view

    }

    private fun initViews(view: View){

        rvCategory = view.findViewById(R.id.rv_categories)
        rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        rvItems = view.findViewById(R.id.rv_item)
        rvItems.layoutManager = GridLayoutManager(requireContext(), 2)

        refreshCategoryAdapter(getAllCategories())
        refreshItemAdapter(getAllItems())
    }

    private fun refreshCategoryAdapter(items : ArrayList<Category>){
        rvCategory.adapter = CategoryAdapter(requireContext(), items)
    }

    private fun refreshItemAdapter(items : ArrayList<Item>){
        rvItems.adapter = ItemAdapter(requireContext(), items)
    }

    private fun getAllCategories() : ArrayList<Category>{
        val item : ArrayList<Category> = ArrayList()

        item.add(Category(R.drawable.img_rectaurant,"Restaurant"))
        item.add(Category(R.drawable.img_rectaurant,"Coffee Shop"))
        item.add(Category(R.drawable.img_rectaurant,"Shopping"))
        item.add(Category(R.drawable.img_rectaurant,"Restaurant"))
        item.add(Category(R.drawable.img_rectaurant,"Coffee Shop"))
        item.add(Category(R.drawable.img_rectaurant,"Shopping"))
        item.add(Category(R.drawable.img_rectaurant,"Restaurant"))
        item.add(Category(R.drawable.img_rectaurant,"Coffee Shop"))
        item.add(Category(R.drawable.img_rectaurant,"Shopping"))

        return item
    }

    private fun getAllItems() : ArrayList<Item>{
        val item : ArrayList<Item> = ArrayList()

        item.add(Item(R.drawable.img_restaurant2,"Gamine", "1231 Filnova st"))
        item.add(Item(R.drawable.img_restaurant2,"Doppi Zero", "1000 Marg st"))
        item.add(Item(R.drawable.img_restaurant2,"Versal", "2546 Best st"))
        item.add(Item(R.drawable.img_restaurant2,"Lupa", "4123 Most st"))
        item.add(Item(R.drawable.img_restaurant2,"Gamine", "1231 Filnova st"))
        item.add(Item(R.drawable.img_restaurant2,"Doppi Zero", "1000 Marg st"))
        item.add(Item(R.drawable.img_restaurant2,"Versal", "2546 Best st"))
        item.add(Item(R.drawable.img_restaurant2,"Lupa", "4123 Most st"))

        return item
    }

}