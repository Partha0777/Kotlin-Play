package com.curiozing.kotlinplay.classTypes


fun main() {
    sendEmail(EmailId("rps@gmail.com"))
}

@JvmInline
value class EmailId(val email: String) {
    fun isValid() = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        .toRegex().matches(email)
}

fun sendEmail(emailId: EmailId): String {
    return if (emailId.isValid()) {
        print("Valid")
        "Sending email to: ${emailId.email}"
    } else {
        print("Not Valid")
        "Invalid email: ${emailId.email}"
    }
}

