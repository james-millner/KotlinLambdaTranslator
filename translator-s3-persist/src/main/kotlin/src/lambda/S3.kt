package src.lambda

import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import src.lambda.config.getDefaultCreds
import java.io.File
import java.util.*

class S3 {
    var s3 = S3Client.builder()
            .credentialsProvider(getDefaultCreds())
            .build()

    fun uploadToS3(fileId: UUID, text: String) {

        val fileName = "/tmp/$fileId.txt"

        val file = File(fileName)
        file.createNewFile()
        file.writeText(text)

        val putRequest = PutObjectRequest.builder()
                .bucket("jm-translations")
                .key(fileName)
                .build()

        s3.putObject(putRequest, file.toPath())
    }
}