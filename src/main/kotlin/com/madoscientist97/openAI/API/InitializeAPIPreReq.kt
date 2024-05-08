package com.madoscientist97.openAI.API

import com.madoscientist97.utils.PropertyLoader;

class InitializeAPIPreReq (propFileName: String = "api_key.property") {
    private val API_KEY: String?
    private val keyFieldName: String = "apikey"

    init {
        val propLoader = PropertyLoader(propFileName);
        API_KEY = propLoader.getProperty(propFileName, keyFieldName);
        if (null == API_KEY) throw Exception("Api key for chatgpt was not found in api_key.property file!!")
    }

    fun getAPIKey(): String? {
        return this.API_KEY;
    }
}