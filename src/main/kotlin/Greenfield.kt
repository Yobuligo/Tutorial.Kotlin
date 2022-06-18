fun main() {


//    runBlocking {
//        val channel = Channel<Int>()
//        launch {
//            repeat(10) {
//                delay(200)
//                channel.send(it)
//            }
//            channel.close()
//        }
//
//        delay(1000)
//        val flow = flow<Int> {
//            for (value in channel) {
//                emit(value)
//            }
//        }
//
//        flow.collect {
//            println(it)
//        }
//    }
}
