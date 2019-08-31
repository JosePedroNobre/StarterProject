package com.josenobre.starterproject.network.api.adapter

data class Resource<T>(val status: com.josenobre.starterproject.network.api.adapter.Status, val code: Int, val data: T?, val message: String?) {

    companion object {

        fun <T> success(code: Int, data: T?) =
            com.josenobre.starterproject.network.api.adapter.Resource(
                com.josenobre.starterproject.network.api.adapter.Status.SUCCESS,
                code,
                data,
                null
            )

        fun <T> error(message: String?, code: Int, data: T?) =
            com.josenobre.starterproject.network.api.adapter.Resource(
                com.josenobre.starterproject.network.api.adapter.Status.ERROR,
                code,
                data,
                message
            )

        fun <T> loading(data: T? = null, code: Int = 0) =
            com.josenobre.starterproject.network.api.adapter.Resource(
                com.josenobre.starterproject.network.api.adapter.Status.LOADING,
                code,
                data,
                null
            )

        fun <T> empty(status: com.josenobre.starterproject.network.api.adapter.Status, code: Int, message: String?, data: T? = null) =
            com.josenobre.starterproject.network.api.adapter.Resource(status, code, data, message)
    }
}