package com.example.intelligentfirewarningsystem

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intelligentfirewarningsystem.databinding.ActivitySetBinding
import com.example.intelligentfirewarningsystem.utils.MToast
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar

class SetActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySetBinding
    private lateinit var sharedPreferences: SharedPreferences // 临时存储
    private lateinit var editor: SharedPreferences.Editor // 修改提交
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("local", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        initViews()
    }

    private fun initViews() {
        //设置共同沉浸式样式
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init()
        binding.backBtn.setOnClickListener { finish() }
        setSupportActionBar(binding.toolbar)
        binding.toolbarLayout.title = "紧急联系人"
        binding.submitBtn.setOnClickListener {
            val phone = binding.phoneText.text.toString()
            if (phone.isEmpty()) {
                MToast.mToast(this, "紧急联系人不能为空")
            } else {
                editor.putString("phone", binding.phoneText.text.toString())
                editor.commit()
            }
        }
    }
}