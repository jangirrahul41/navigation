package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.navigation.databinding.FragmentTitleBinding


class Titlefragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false )

//        binding.playButton.setOnClickListener {view: View ->
//            Navigation.findNavController(view).navigate(R.id.action_titlefragment_to_gameFragment)
//        }
//
//        binding.playButton.setOnClickListener {view: View ->
//            view.findNavController().navigate(R.id.action_titlefragment_to_gameFragment)
//        }

        binding.playButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_titlefragment_to_gameFragment)
        )

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            requireView().findNavController())
                ||super.onOptionsItemSelected(item)
    }
}