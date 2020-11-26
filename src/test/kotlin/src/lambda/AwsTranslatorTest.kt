package src.lambda

import org.junit.Test
import kotlin.test.assertEquals

class AwsTranslatorTest {

    @Test
    fun translateTest() {
        val awsTranslator = AwsTranslator()

        val response = awsTranslator.translate("this text", "en", "es")

        assertEquals("este texto", response?.translatedText())
    }
}