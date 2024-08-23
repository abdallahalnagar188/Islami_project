package com.example.islamiproject.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiproject.Constants
import com.example.islamiproject.databinding.FragmentHadethBinding
import com.example.islamiproject.ui.hadeth_details.HadethDetails
import com.example.islamiproject.ui.model.Hadeth

class HadethFragment : Fragment() {

    lateinit var binding: FragmentHadethBinding
    private lateinit var hadethNumberAdapter: HadethNumberAdapter
    lateinit var list: ArrayList<Hadeth>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHadethBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initViews()

    }

    private fun initViews() {
        hadethNumberAdapter = HadethNumberAdapter(null)
        binding.hadethNumberRv.adapter = hadethNumberAdapter
        hadethNumberAdapter.onItemClick = object : HadethNumberAdapter.OnItemClickListener{
            override fun onItemClick(item: Hadeth, position: Int)  {
                showHadethDetails(item)
            }
        }

    }

    private fun showHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity,HadethDetails::class.java)
        intent.putExtra(Constants.EXTRA_HADETH,hadeth)
        startActivity(intent)
    }


    override fun onStart() {
        super.onStart()
        readHadethContent()
        bindHadethList()
    }

    private fun bindHadethList() {
        hadethNumberAdapter.items = hadethList
    }

    val hadethList = mutableListOf<Hadeth>()

    private fun readHadethContent() {
            val fileContent =requireActivity().assets.open("ahadeth.txt")
            .bufferedReader().use{it.readText()}
        val singleHadethList = fileContent.trim().split("#")
        singleHadethList.forEach { elemint->
            val lines  = elemint.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title,content)
            hadethList.add(hadeth)

        }

    }
}