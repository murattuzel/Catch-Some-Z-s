package com.murattuzel.catchsomezs.internal.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

val Context.connectivityManager
    get() = (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

fun Context.isNetworkAvailable(): Boolean {
    connectivityManager.activeNetwork
    connectivityManager.apply {
        return getNetworkCapabilities(activeNetwork)?.run {
            when {
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } ?: false
    }
}
