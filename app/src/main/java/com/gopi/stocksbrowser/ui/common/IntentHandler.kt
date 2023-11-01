package com.gopi.stocksbrowser.ui.common

interface IntentHandler<INTENT : Any> {
    fun handleIntent(intent: INTENT)
}
