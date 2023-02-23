package com.example.roomapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapplication.data.league.League
import com.example.roomapplication.databinding.FragmentLeaguesBinding
import com.example.roomapplication.presentation.main.LeagueAdapter
import com.example.roomapplication.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LeaguesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class LeaguesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentLeaguesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLeaguesBinding.inflate(layoutInflater)
        initializeUi()
        return binding.root
    }

    private fun initializeUi() {
        val leagueAdapter = LeagueAdapter(emptyList(), ::navigate)
        binding.rvLeagues.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = leagueAdapter
        }
        viewModel.leagues.observe(viewLifecycleOwner) { dataset ->
            leagueAdapter.updateDataset(dataset)
        }
        binding.btAddLeague.setOnClickListener {
            binding.etLeague.text.let {
                if(!it.isNullOrEmpty()) viewModel.addLeague(it.toString())
            }
        }
        viewModel.getLeagues()
    }

    private fun navigate(leagueId: Int) {
        val bundle = Bundle()
        bundle.putInt("leagueId", leagueId)
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_leagueFragment_to_teamsFragment, bundle)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LeagueFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LeaguesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}