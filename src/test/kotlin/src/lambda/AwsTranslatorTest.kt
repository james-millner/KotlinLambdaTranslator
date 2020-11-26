package src.lambda

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import software.amazon.awssdk.services.translate.model.TranslateTextRequest
import software.amazon.awssdk.services.translate.model.TranslateTextResponse

class AwsTranslatorTest {

    @Test
    fun translateTest() {
        val awsTranslator = AwsTranslator()

        awsTranslator.translateClient = mockk()

        every { awsTranslator.translateClient.translateText(any<TranslateTextRequest>()) } returns TranslateTextResponse.builder().build()

        awsTranslator.translate("this text", "en", "es")

        verify(exactly = 1) { awsTranslator.translateClient }
    }
}