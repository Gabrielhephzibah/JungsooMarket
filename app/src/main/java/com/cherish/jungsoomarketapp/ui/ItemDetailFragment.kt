package com.cherish.jungsoomarketapp.ui

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.cherish.jungsoomarketapp.R
import com.cherish.jungsoomarketapp.data.glide.GlideApp
import com.cherish.jungsoomarketapp.model.StoreData
import com.cherish.jungsoomarketapp.viewmodel.StoreViewModel
import kotlinx.android.synthetic.main.item_details_layout.*

class ItemDetailFragment : Fragment() {
    private var itemViewModel: StoreViewModel? = null
    val  mainFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemViewModel = ViewModelProvider(requireActivity()).get(StoreViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_details_layout, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        itemViewModel?.getSelectedValue()?.observe(viewLifecycleOwner, Observer {
            itemViewModel?.getSingleItem(it.toInt())

        })
        itemViewModel?.getSelectedItem()?.observe(viewLifecycleOwner, Observer {
             val item = it
            name.text = item.name
            price.text = "$${item.price}"
            GlideApp.with(requireActivity())
                .load(item.thumbnail)
                .placeholder(R.drawable.ic_image_black)
                .error(R.drawable.ic_image_black)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        Toast.makeText(requireActivity(),R.string.image_error, Toast.LENGTH_SHORT).show()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        return false
                    }

                })
                .into(image)
        })




        accept.setOnClickListener{
            itemViewModel?.addShoppingData()
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragmentLayout,mainFragment).commit()
        }

        cancel.setOnClickListener{
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragmentLayout,mainFragment).commit()
        }
    }


}