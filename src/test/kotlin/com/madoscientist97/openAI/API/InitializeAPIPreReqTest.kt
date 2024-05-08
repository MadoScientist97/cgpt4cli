package com.madoscientist97.openAI.API

import junit.framework.TestCase
import org.junit.Test
import kotlin.test.assertEquals

class InitializeAPIPreReqTest {

    @Test
    fun checkCorrectKeyRead() {
        val initialized = InitializeAPIPreReq();
        assertEquals("test_key", initialized.getAPIKey());
    }

    @Test(expected = Exception::class)
    fun wrongPropFilePassed() {
        val initialized =InitializeAPIPreReq("wrong_file");
    }

}