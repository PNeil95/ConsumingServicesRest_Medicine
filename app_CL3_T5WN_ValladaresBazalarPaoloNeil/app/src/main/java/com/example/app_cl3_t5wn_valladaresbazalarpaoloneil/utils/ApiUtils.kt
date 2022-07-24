package com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.utils

import com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.api.ApiService


class ApiUtils {

    companion object {
        val BASE_URL="https://modelo-cl3.herokuapp.com"
        fun getAPIService(): ApiService {
            return RetrofitClient.getClient(BASE_URL).create(ApiService::class.java)
        }
    }
}