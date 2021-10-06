package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {
    lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        binding.albumArrowIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
        }

        binding.albumLilacLayoutCl.setOnClickListener {
            Toast.makeText(activity, "라일락", Toast.LENGTH_SHORT).show()//앨범프래그먼트가 있는 곳은 액티비티 위
        }

        binding.albumToggleOffIb.setOnClickListener {
            setToggleStatus(false)
        }
        binding.albumToggleOnIb.setOnClickListener {
            setToggleStatus(true)
        }

        binding.albumMyLikeOffIv.setOnClickListener {
            setLikeStatus(false)
        }

        binding.albumMyLikeOffIv.setOnClickListener {
            setLikeStatus(true)
        }

        return binding.root
    }

    fun setToggleStatus(isToggleOn : Boolean){
        if(isToggleOn){
            //isRandom 이 true 인 상황
            binding.albumToggleOffIb.visibility=View.VISIBLE
            binding.albumToggleOnIb.visibility=View.GONE
        }
        else{
            binding.albumToggleOffIb.visibility=View.INVISIBLE
            binding.albumToggleOnIb.visibility=View.VISIBLE
        }
    }

    fun setLikeStatus(isLike : Boolean){
        if(isLike){
            //isPlaying 이 true 인 상황: 정지 버튼이 보이는 상황에서 재생 버튼으로 변경
            binding.albumMyLikeOffIv.visibility=View.VISIBLE
            binding.albumMyLikeOnIv.visibility=View.GONE
        }
        else{
            //isPlaying 이 false 인 상황: 재생 버튼이 보이는 상황에서 정지 버튼으로 변경
            binding.albumMyLikeOffIv.visibility=View.INVISIBLE
            binding.albumMyLikeOnIv.visibility=View.VISIBLE
        }
    }
}