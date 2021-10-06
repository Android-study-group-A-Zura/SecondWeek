package com.example.flo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    lateinit var binding: ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            //intent에 title과 singer가 있다면 실행
            binding.songTitleTv.text = intent.getStringExtra("title")
            binding.songSingerTv.text = intent.getStringExtra("singer")
        }

        binding.songAlbumImgIv.clipToOutline = true

        binding.songNuguDownIb.setOnClickListener {
            finish()
        }

        binding.songMiniPlayIb.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songMiniPauseIb.setOnClickListener {
            setPlayerStatus(true)
        }

        binding.songNuguRepeatInactiveIb.setOnClickListener {
            setRepeatStatusSeq(0)
        }
        binding.songNuguRepeatOn1Ib.setOnClickListener {
            setRepeatStatusSeq(1)
        }
        binding.songNuguRepeatOnIb.setOnClickListener {
            setRepeatStatusSeq(2)
        }

        binding.songNuguRandomInactiveIb.setOnClickListener {
            setRandomStatus(false)
        }

        binding.songNuguRandomOnIb.setOnClickListener {
            setRandomStatus(true)
        }

        binding.songMyLikeOffIb.setOnClickListener {
            setLikeStatus(false)
        }

        binding.songMyLikeOnIb.setOnClickListener {
            setLikeStatus(true)
        }

        binding.songPlayerUnlikeOffIb.setOnClickListener {
            setUnlikeStatus(false)
        }
        binding.songPlayerUnlikeOnIb.setOnClickListener {
            setUnlikeStatus(true)
        }
    }
    fun setPlayerStatus(isPlaying : Boolean){
        val intent = Intent()
        if(isPlaying){
            //isPlaying 이 true 인 상황: 정지 버튼이 보이는 상황에서 재생 버튼으로 변경
            binding.songMiniPlayIb.visibility=View.VISIBLE
            binding.songMiniPauseIb.visibility=View.GONE
        }
        else{
            binding.songMiniPlayIb.visibility=View.GONE
            binding.songMiniPauseIb.visibility=View.VISIBLE
        }
        intent.putExtra("isPlaying", isPlaying)
        setResult(Activity.RESULT_OK, intent)
    }

    fun setRepeatStatusSeq(seq:Int){
        if(seq==0){
            //isRepeatOneTime 이 false 인 상황
            binding.songNuguRepeatInactiveIb.visibility=View.INVISIBLE
            binding.songNuguRepeatOn1Ib.visibility=View.VISIBLE
        }
        else if(seq==1){
            //isRepeatOneTime 이 true 인 상황
            binding.songNuguRepeatOnIb.visibility=View.VISIBLE
            binding.songNuguRepeatOn1Ib.visibility=View.GONE
        }
        else{
            binding.songNuguRepeatOnIb.visibility=View.GONE
            binding.songNuguRepeatInactiveIb.visibility=View.VISIBLE
        }
    }

    fun setRandomStatus(isRandom : Boolean){
        if(isRandom){
            //isRandom 이 true 인 상황
            binding.songNuguRandomInactiveIb.visibility=View.VISIBLE
            binding.songNuguRandomOnIb.visibility=View.GONE
        }
        else{
            binding.songNuguRandomInactiveIb.visibility=View.INVISIBLE
            binding.songNuguRandomOnIb.visibility=View.VISIBLE
        }
    }


    fun setLikeStatus(isLike : Boolean){
        if(isLike){
            //isPlaying 이 true 인 상황: 정지 버튼이 보이는 상황에서 재생 버튼으로 변경
            binding.songMyLikeOffIb.visibility=View.VISIBLE
            binding.songMyLikeOnIb.visibility=View.GONE

        }
        else{
            //isPlaying 이 false 인 상황: 재생 버튼이 보이는 상황에서 정지 버튼으로 변경
            binding.songMyLikeOffIb.visibility=View.INVISIBLE
            binding.songMyLikeOnIb.visibility=View.VISIBLE

        }

    }

    fun setUnlikeStatus(isUnlike : Boolean){
        if(isUnlike){
            //isPlaying 이 true 인 상황: 정지 버튼이 보이는 상황에서 재생 버튼으로 변경
            binding.songPlayerUnlikeOffIb.visibility=View.VISIBLE
            binding.songPlayerUnlikeOnIb.visibility=View.GONE
        }
        else{
            //isPlaying 이 false 인 상황: 재생 버튼이 보이는 상황에서 정지 버튼으로 변경
            binding.songPlayerUnlikeOffIb.visibility=View.INVISIBLE
            binding.songPlayerUnlikeOnIb.visibility=View.VISIBLE
        }
    }
}