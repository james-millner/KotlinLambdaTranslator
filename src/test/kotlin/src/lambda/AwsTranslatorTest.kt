package src.lambda

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import software.amazon.awssdk.services.translate.TranslateClient
import software.amazon.awssdk.services.translate.model.TranslateTextRequest
import software.amazon.awssdk.services.translate.model.TranslateTextResponse
import kotlin.test.assertEquals

class AwsTranslatorTest {

    @Test
    fun translateTest() {
        val awsTranslator = AwsTranslator()

        val response = awsTranslator.translate("this text", "en", "es")

        assertEquals("este texto", response?.translatedText())
    }
}