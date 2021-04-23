package com.cherish.jungsoomarketapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cherish.jungsoomarketapp.R
import com.cherish.jungsoomarketapp.model.ShoppingData
import com.cherish.jungsoomarketapp.viewmodel.StoreViewModel
import kotlinx.android.synthetic.main.main_fragment_layout.*

class MainFragment : Fragment() {
    private var storeViewModel: StoreViewModel? = null
    private var adapter: StoreItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        storeViewModel = ViewModelProvider(requireActivity()).get(StoreViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = StoreItemAdapter(callback = {
            val item = adapter!!.getData(it)
            storeViewModel?.removeShopItem(item)
        })
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            showItemDialog()
        }

        storeViewModel?.shopping?.observe(viewLifecycleOwner, Observer { items ->
            val listOfRecyclerList = items.map { ShoppingData(it.name,it.price?.toInt(), it.id) }
            adapter?.submitList(listOfRecyclerList)
        })

        storeViewModel?.getTotalPrice()?.observe(viewLifecycleOwner, Observer {
            totalAmount.text = "Total amount: $$it"
        })
    }

    private fun showItemDialog() {
        val dialogView = layoutInflater.inflate(R.layout.add_item_layout, null)
        val builder = AlertDialog.Builder(requireActivity())
            .setView(dialogView)
        val additem = dialogView.findViewById<Button>(R.id.addItem)
        val items = dialogView.findViewById<EditText>(R.id.itemName)
        val alertDialog = builder.create()
        additem.setOnClickListener {
            val value = items.text.toString()
            when {
                value.isEmpty() -> Toast.makeText(requireActivity(),R.string.enter_value,Toast.LENGTH_SHORT).show()
                value.toInt() > 10 -> Toast.makeText(requireActivity(),R.string.value_error,Toast.LENGTH_SHORT).show()
                else -> {
                    alertDialog.dismiss()
                    storeViewModel?.setSelectedValue(value)
                    val detailFragment = ItemDetailFragment()
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentLayout, detailFragment).commit()
                }
            }
        }


        alertDialog.show()

    }
}