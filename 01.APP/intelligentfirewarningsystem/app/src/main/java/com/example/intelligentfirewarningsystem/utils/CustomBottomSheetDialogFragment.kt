package com.example.intelligentfirewarningsystem.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intelligentfirewarningsystem.adapter.HistoryListViewAdapter
import com.example.intelligentfirewarningsystem.databinding.BottomSheetDialogFrgmentLayoutBinding
import com.example.intelligentfirewarningsystem.db.HistoryDao
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CustomBottomSheetDialogFragment(private val type: Int) : BottomSheetDialogFragment(),
    HandlerAction {
    private lateinit var binding: BottomSheetDialogFrgmentLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 填充底部弹窗的布局文件
        binding = BottomSheetDialogFrgmentLayoutBinding.inflate(
            inflater,
            container,
            false
        )
        when (type) {
            0 -> {
                val dao = HistoryDao(requireContext())
                val list: MutableList<Any>? = dao.query()
                if (list != null) {
                    if (list.size > 0) {
                        binding.settingList.adapter = HistoryListViewAdapter(requireContext(), list)
                    } else {
                        MToast.mToast(requireContext(), "还没有数据")
                    }
                }
            }
        }

        return binding.root
    }
}
