package com.example.politestyleservice

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.graphics.PixelFormat
import android.os.Build
import android.view.*
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.text.TextUtils

class StyleAccessibilityService : AccessibilityService() {

    private var overlayView: View? = null
    private var windowManager: WindowManager? = null

    override fun onServiceConnected() {
        super.onServiceConnected()
        val info = serviceInfo
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
        info.flags = AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS
        serviceInfo = info
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event?.eventType == AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED) {
            showOverlay()
        }
    }

    override fun onInterrupt() {
        // 인터럽트 시 처리
    }

    private fun showOverlay() {
        if (overlayView != null) return  // 이미 떠 있으면 다시 띄우지 않음

        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        overlayView = inflater.inflate(R.layout.overlay_buttons, null)

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            else
                WindowManager.LayoutParams.TYPE_PHONE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            PixelFormat.TRANSLUCENT
        )

        params.gravity = Gravity.BOTTOM or Gravity.END
        params.y = 200

        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager?.addView(overlayView, params)

        overlayView?.findViewById<Button>(R.id.btnPolite)?.setOnClickListener {
            Toast.makeText(this, "공손하게 변환!", Toast.LENGTH_SHORT).show()
            removeOverlay()
        }
        overlayView?.findViewById<Button>(R.id.btnFriendly)?.setOnClickListener {
            Toast.makeText(this, "친근하게 변환!", Toast.LENGTH_SHORT).show()
            removeOverlay()
        }
        overlayView?.findViewById<Button>(R.id.btnBusiness)?.setOnClickListener {
            Toast.makeText(this, "비즈니스 어투로 변환!", Toast.LENGTH_SHORT).show()
            removeOverlay()
        }
    }

    private fun removeOverlay() {
        if (overlayView != null && windowManager != null) {
            windowManager?.removeView(overlayView)
            overlayView = null
            windowManager = null
        }
    }
}