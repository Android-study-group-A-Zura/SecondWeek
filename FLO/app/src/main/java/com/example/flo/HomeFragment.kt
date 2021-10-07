package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeBtnAlbum01Iv.clipToOutline = true
        binding.homeBtnAlbum02Iv.clipToOutline = true
        binding.homeBtnAlbum03Iv.clipToOutline = true
        binding.homeBtnRecommendAlbum01Iv.clipToOutline = true
        binding.homeBtnRecommendAlbum02Iv.clipToOutline = true
        binding.homeBtnRecommendAlbum03Iv.clipToOutline = true
        binding.homeBtnVideoCollection01Iv.clipToOutline = true
        binding.homeBtnVideoCollection02Iv.clipToOutline = true

        binding.homeBtnAlbum01Iv.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, AlbumFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }

}