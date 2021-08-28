package com.murattuzel.catchsomezs.internal.extension

import java.util.regex.Pattern

fun String.isValidPassword(): Boolean {
    val regex = Pattern.compile(
        "^" +
            "(?=.*[0-9])" + // at least 1 digit
            "(?=.*[A-Z])" + // at least 1 upper case letter
            ".{6,}" + // at least 6 characters
            "$"
    )
    return regex.matcher(this).matches()
}

fun String.isValidUsername(): Boolean = length > 2
