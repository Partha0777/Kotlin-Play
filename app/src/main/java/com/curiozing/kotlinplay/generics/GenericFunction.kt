package com.curiozing.kotlinplay.generics


fun <T : Number> genericFunction(data:T):T{
    return data
}

fun <T : CharSequence> genericFunctionString(data:T):T{
    return data
}