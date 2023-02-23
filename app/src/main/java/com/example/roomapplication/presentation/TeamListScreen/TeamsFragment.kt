package com.example.roomapplication.presentation.TeamListScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapplication.databinding.FragmentTeamsBinding
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TeamsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class TeamsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var leagueId: Int? = null

    private val viewModel: TeamsViewModel by viewModels()
    private lateinit var binding: FragmentTeamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            leagueId = it.getInt("leagueId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTeamsBinding.inflate(layoutInflater)
        initializeUI()
        return binding.root
    }

    private fun initializeUI() {
        viewModel.setup(leagueId ?: 0)

        val teamAdapter = TeamAdapter(listOf())
        binding.rvTeams.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = teamAdapter
        }

        viewModel.teams.observe(viewLifecycleOwner) { dataset ->
            teamAdapter.updateDataset(dataset)
        }

        binding.btAddTeam.setOnClickListener {
            binding.etTeam.text.let {
                if(!it.isNullOrEmpty()) viewModel.addTeam(it.toString())
            }
        }

        viewModel.getTeams()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TeamsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TeamsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}