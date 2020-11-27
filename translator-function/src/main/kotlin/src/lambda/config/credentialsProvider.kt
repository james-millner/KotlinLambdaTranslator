package src.lambda.config

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider

fun getCredentialsByProfile(profileName: String) = ProfileCredentialsProvider
        .builder()
        .profileName(profileName)
        .build()

fun getDefaultCreds() = DefaultCredentialsProvider.builder().build()
