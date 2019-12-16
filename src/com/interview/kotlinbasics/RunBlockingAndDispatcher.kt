package com.interview.kotlinbasics
/*
import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    // callFunRunBlocking("first")

    //callFunRunBlockingDispatcher("Dispatcher")

    //callFunRunBlockingDispatcherWaiting("Dispatcher Launch with waiting")

    //callFunLaunchCoroutineScope("Coroutine Scope..")

    callFunLaunchCoroutineScopeCustomDispatcher("custom dispatcher..")
}

suspend fun delayed(message: String) {
    delay(2000)
    println("$message ${Thread.currentThread().name}")
}

fun callFunRunBlocking(message: String) {
    runBlocking {
        println(message)
        delayed("delayed..")
    }
}

fun callFunRunBlockingDispatcher(message: String) {
    runBlocking(Dispatchers.Default) {
        println("$message  ${Thread.currentThread().name}")
        delayed("delayed")
    }

    println("printing again..  ${Thread.currentThread().name}")
}

fun callFunRunBlockingDispatcherWaiting(message: String) = runBlocking {
    println("$message  ${Thread.currentThread().name}")

    val job = GlobalScope.launch {
        delayed("delayed")
    }

    println("printing again..  ${Thread.currentThread().name}")
    job.join()
}

//Launch is like Dispatcher in Android; fire and forget
fun callFunLaunchCoroutineScope(message: String) = runBlocking {
    println("$message  ${Thread.currentThread().name}")

    launch(Dispatchers.Default) {
        delayed("delayed")
    }

    println("printing again..  ${Thread.currentThread().name}")

    //NOw no need to wait for JOb to finish..
    //job.join()
}

//Launch is like Dispatcher in Android; fire and forget
fun callFunLaunchCoroutineScopeCustomDispatcher(message: String) = runBlocking {
    println("$message  ${Thread.currentThread().name}")

    val customDispatcher = Executors.newFixedThreadPool(2).asCoroutineDispatcher()

    launch(customDispatcher) {

        //now delayed Thread pool will be different from above
        delayed("delayed")
    }

    println("printing again..  ${Thread.currentThread().name}")

    (customDispatcher.executor as ExecutorService).shutdown()
}
*/