package com.mmb.feed_me.ui.mvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mmb.feed_me.FeedMeApplication
import com.mmb.feed_me.R
import com.mmb.feed_me.ui.mvvm.model.Post
import com.mmb.feed_me.ui.mvvm.view_model.PostViewModel
import javax.inject.Inject

class PostFragment :Fragment(){
    @Inject lateinit var viewModel : PostViewModel
    lateinit var recyclerView : RecyclerView
    var adapter : PostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FeedMeApplication.component.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.onActivityCreated()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        viewModel.apply {
            postList.observe(this@PostFragment , Observer {
                println(it)
                adapter = PostAdapter(it)
                recyclerView.adapter = adapter
            })
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_post_list , container , false)
    }
}