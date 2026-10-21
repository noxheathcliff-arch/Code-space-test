package com.izumih.flowreply.data

import com.izumih.flowreply.data.remote.GenerationResult

/** Callback used by the bubble to receive the outcome of a generation. */
fun interface GenerationResultListener {
    fun onResult(result: GenerationResult)
}
