package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_crime_list.*

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {

    lateinit var adapter: CrimeAdapter

    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProviders.of(this).get(CrimeListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime_list, container, false)

        val crimeRecyclerView = view.findViewById<RecyclerView>(R.id.crime_recycler_view)

        crimeListViewModel.crimeListLiveData.observe(viewLifecycleOwner, Observer { crimes ->
            crimes?.let {
                crimeRecyclerView.adapter = CrimeAdapter(it)
                crimeRecyclerView.layoutManager = LinearLayoutManager(context)
            }
        })
        return view
    }

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }

}