package com.bhandari.composeplayground

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.bhandari.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val currentTime = MutableLiveData(0L)
    private var timerStartedAt = 0L
    private var timerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
                ActivityView()
            }
        }
    }

    private fun toggle() {
        if (timerRunning) stopTimer()
        else startTimer()
    }

    private fun startTimer() {
        lifecycleScope.launch {
            timerStartedAt = SystemClock.elapsedRealtime()
            timerRunning = true
            while (timerRunning) {
                currentTime.value = SystemClock.elapsedRealtime() - timerStartedAt
                delay(16)
            }
        }
    }

    private fun stopTimer() {
        currentTime.value = 0
        timerRunning = false
        timerStartedAt = 0
    }

    @Composable
    fun ActivityView() {
        Box {
            StopWatch(
                modifier = Modifier.clickable { toggle() },
                currentTime = currentTime,
            )
        }
    }

    @Preview
    @Composable
    fun PreviewActivity(modifier: Modifier = Modifier) {
        ActivityView()
    }
}