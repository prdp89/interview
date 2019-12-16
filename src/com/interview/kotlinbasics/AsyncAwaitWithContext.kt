package com.interview.kotlinbasics

/*import kotlinx.coroutines.*

fun main() {
    //exampleAsyncAwait()

   // exampleAsyncAwaitUnique()

    exampleWithContext()
}

fun exampleAsyncAwaitUnique() = runBlocking {
    val startTime = System.currentTimeMillis()

    val deferred1 = async { calculateValues(1) }.await()
    val deferred2 = async { calculateValues(2) }.await()
    val deferred3 = async { calculateValues(3) }.await()

    val sum = deferred1 + deferred2 + deferred3
    println("Result : $sum")

    val endTime = System.currentTimeMillis()
    println("Total Time : ${endTime - startTime}") //Time : 3067 MS
}

//This is running multiple thread concurrently
fun exampleAsyncAwait() = runBlocking {
    val startTime = System.currentTimeMillis()

    val deferred1 = async { calculateValues(1) }
    val deferred2 = async { calculateValues(2) }
    val deferred3 = async { calculateValues(3) }

    val sum = deferred1.await() + deferred2.await() + deferred3.await()
    println("Result : $sum")

    val endTime = System.currentTimeMillis()
    println("Total Time : ${endTime - startTime}") //Time : 1068 MS
}

//WithContext is used when we don't need Concurrent thread but expecting a final result at the end
fun exampleWithContext() = runBlocking {
    val startTime = System.currentTimeMillis()

    val result1 = withContext(Dispatchers.Default) { calculateValues(1) }
    val result2 = withContext(Dispatchers.Default) { calculateValues(2) }
    val result3 = withContext(Dispatchers.Default) { calculateValues(3) }

    val sum = result1 + result2 + result3
    println("Result : $sum")

    val endTime = System.currentTimeMillis()
    println("Total Time WithContext : ${endTime - startTime}") //Time : 1068 MS
}

suspend fun calculateValues(num: Int): Int {
    delay(1000)
    return 10 * num
}*/