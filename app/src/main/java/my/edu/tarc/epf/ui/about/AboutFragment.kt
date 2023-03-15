package my.edu.tarc.epf.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.edu.tarc.epf.R
import my.edu.tarc.epf.databinding.FragmentAboutBinding


/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    private var _binding : FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAboutBinding.inflate(inflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.kwsp.gov.my")
            startActivity(intent)
        }
        binding.buttonEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            with(intent){
                data = Uri.parse("mailto:service@kwsp.gov.my")
                putExtra("subject", "Request for Service")
            }
            startActivity(intent)
        }

        //Phone: tel:0389226000
        //Location: geo:3.208848,101.742639
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}