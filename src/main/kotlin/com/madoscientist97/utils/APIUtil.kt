package com.madoscientist97.utils

import java.util.HashMap
import java.util.Properties;

class PropertyLoader(propFileName: String) {
    // Load properties file from the default resource folder (src/main/resources)
    private val properties = Properties()
    companion object {
        val propMap = mutableMapOf<String, Map<String, String>>();
    }
    // Use the class loader to load the properties file
    init {
        if (propFileName !in propMap) {
            readProps(propFileName)
        }
    }

    private fun readProps(propFileName: String) {
        val inputStream = Thread.currentThread().contextClassLoader.getResourceAsStream(propFileName)
        // Load properties from the input stream
        inputStream.use { stream ->
            properties.load(stream)
        }
        // Convert properties to a map of key-value pairs
        val propMapForFile = properties.entries.associate {
            it.key.toString() to it.value.toString()
        }
        propMap[propFileName] = propMapForFile;
    }

    // Function to get a specific property value by key
    fun getProperty(fileName: String, key: String): String? {
        return propMap[fileName]?.get(key);
    }

    fun getPropertiesOf(fileName: String): Map<String, String>? {
        return propMap[fileName];
    }
}