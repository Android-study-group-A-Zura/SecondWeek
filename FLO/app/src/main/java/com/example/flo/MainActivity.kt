package com.example.flo

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.provider.FontsContractCompat.FontRequestCallback.RESULT_OK
import com.example.flo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var isPlaying : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, SongActivity::class.java)

        val song = Song(binding.mainMiniplayerTitleTv.text.toString(), binding.mainMiniplayerSingerTv.text.toString())
        Log.d("Log test", song.title + song.singer)

        binding.mainPlayerLayout.setOnClickListener {
            // 안에 정보를 담으려고 위의 코드를 나누어서 썼음.
            intent.putExtra("title", song.title)
            intent.putExtra("singer", song.singer)
            intent.putExtra("isP",isPlaying)
            startActivityForResult(intent, 100)
        }



        initNavigation()

        binding.mainBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

            }
            false
        }

        binding.mainMiniplayerBtn.setOnClickListener {
            isPlaying = false
            setPlayerStatus(isPlaying)
        }
        binding.mainPauseBtn.setOnClickListener {
            isPlaying = true
            setPlayerStatus(isPlaying)
        }


    }


    private fun initNavigation() {
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

    }

    fun setPlayerStatus(isPlaying : Boolean){
        if(isPlaying){
            //isPlaying 이 true 인 상황: 정지 버튼이 보이는 상황에서 재생 버튼으로 변경
            binding.mainMiniplayerBtn.visibility=View.VISIBLE
            binding.mainPauseBtn.visibility=View.GONE
        }
        else{
            binding.mainMiniplayerBtn.visibility=View.GONE
            binding.mainPauseBtn.visibility=View.VISIBLE
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                100 -> {
                    if(data!!.getBooleanExtra("isPlayingSong", true)){
                        isPlaying=true
                        binding.mainMiniplayerBtn.visibility = View.VISIBLE
                        binding.mainPauseBtn.visibility = View.GONE
                    }
                    else{
                        isPlaying=false
                        binding.mainMiniplayerBtn.visibility = View.GONE
                        binding.mainPauseBtn.visibility = View.VISIBLE
                    }
                }
            }
        }
    }


}

