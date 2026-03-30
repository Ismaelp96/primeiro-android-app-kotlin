package com.dev.ismaelpatrick.meuprimeiroappandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dev.ismaelpatrick.meuprimeiroappandroid.databinding.FragmentBlankBinding



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NAME = "name"
private const val ARG_AGE = "age"
private const val ARG_IS_MALE = "isMale"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    private var name: String? = null
    private var age: Int? = null
    private var isMale: Boolean? = null

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().getString(R.string.hello_blank_fragment)
        requireContext().getString(R.string.hello_blank_fragment)
        context?.getString(R.string.hello_blank_fragment)
        getString(R.string.hello_blank_fragment)

        requireActivity().applicationContext
        context?.let {
            Toast.makeText(
                it,
                getString(R.string.hello_blank_fragment),
                Toast.LENGTH_SHORT)
                .show()

        }



        arguments?.let {
            name = it.getString(ARG_NAME)
            age = it.getInt(ARG_AGE)
            isMale = it.getBoolean(ARG_IS_MALE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvFragmentContent.text = getString(
            R.string.name_age_is_male,
            name,
            age.toString(),
            if(isMale == true) "Masculino" else "Feminino"
        ).trimIndent()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param name Parameter 1.
         * @param age Parameter 2.
         * @param isMale Parameter 3.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance(name: String, age: Int, isMale: Boolean) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putInt(ARG_AGE, age)
                    putBoolean(ARG_IS_MALE, isMale)
                }
            }
    }
}