/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package src.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class HandlerInput {
    var translatedText: String = ""
}

class HandlerOutput

class S3Handler : RequestHandler<HandlerInput, HandlerOutput> {

    override fun handleRequest(input: HandlerInput?, context: Context?): HandlerOutput {

        val s3 = S3()

        input?.let {
            s3.uploadToS3(it.translatedText)
        }

        return HandlerOutput()
    }

}