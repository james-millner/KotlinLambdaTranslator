package src.lambda

import software.amazon.awssdk.services.translate.TranslateClient
import software.amazon.awssdk.services.translate.model.TranslateTextRequest
import software.amazon.awssdk.services.translate.model.TranslateTextResponse
import src.lambda.config.getDefaultCreds

class AwsTranslator {

    var translateClient: TranslateClient = TranslateClient.builder()
            .credentialsProvider(getDefaultCreds())
            .build()

    fun translate(text: String, sourceLangCode: String, targetLangCode: String): TranslateTextResponse? {

        val request = TranslateTextRequest.builder()
                .sourceLanguageCode(sourceLangCode)
                .targetLanguageCode(targetLangCode)
                .text(text)
                .build()

        return translateClient.translateText(request)
    }
}