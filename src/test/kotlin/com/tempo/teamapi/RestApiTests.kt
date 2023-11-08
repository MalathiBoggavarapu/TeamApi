package com.tempo.teamapi

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.tempo.teamapi.dtos.TeamsDTO
import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.client5.http.classic.methods.HttpPatch
import org.apache.hc.client5.http.classic.methods.HttpUriRequest
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.core5.http.ClassicHttpResponse
import org.apache.hc.core5.http.ParseException
import org.apache.hc.core5.http.io.entity.EntityUtils
import org.apache.hc.core5.http.io.entity.StringEntity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.IOException

class RestApiTests {
    @Test
    @Throws(IOException::class, ParseException::class)
    fun test_getTeams() {
        val httpclient: HttpClient = HttpClients.createDefault()
        val request: HttpUriRequest = HttpGet("http://localhost:8080/Teams")
        httpclient.execute(request) { response: ClassicHttpResponse ->
            assertEquals(response.code, 200)
            val jsonFromResponse = EntityUtils.toString(response.entity)
            val mapper = jacksonObjectMapper()
            val teamsDTO: List<TeamsDTO> = mapper.readValue(jsonFromResponse,  object : TypeReference<List<TeamsDTO>>() {})
            assertEquals("7676a4bf-adfe-415c-941b-1739af07039b", teamsDTO[0].id)
            assertEquals("Ordinary Coral Lynx", teamsDTO[0].name)
            assertEquals("b12fa35a-9c4c-4bf9-8f32-27cf03a1f190", teamsDTO[0].teamLeadId)
            response
        }
    }

    @Test
    @Throws(IOException::class)
    fun test_updateRole() {
        val httpClient: HttpClient = HttpClients.createDefault()
        val request = HttpPatch("http://localhost:8080/updateUserRole")
        val json = "{\"teamId\": \"7676a4bf-adfe-415c-941b-1739af07039b\", \"userId\":\"fd282131-d8aa-4819-b0c8-d9e0bfb1b75c\", \"role\": \"TESTER\"}"
        request.entity = StringEntity(json)
        request.setHeader("Content-type", "application/json")
        httpClient.execute(request) { response: ClassicHttpResponse ->
            assertEquals(response.code, 200)
        }
    }

    @Test
    @Throws(IOException::class)
    fun test_updateRole_noRecordFound() {
        val httpClient: HttpClient = HttpClients.createDefault()
        val request = HttpPatch("http://localhost:8080/updateUserRole")
        val json = "{\"teamId\": \"7676a4bf-adfe-415c-941b-1739af070397\", \"userId\":\"fd282131-d8aa-4819-b0c8-d9e0bfb1b75c\", \"role\": \"TESTER\"}"
        request.entity = StringEntity(json)
        request.setHeader("Content-type", "application/json")
        httpClient.execute(request) { response: ClassicHttpResponse ->
            assertEquals(response.code, 404)
        }
    }

    @Test
    @Throws(IOException::class)
    fun test_updateRole_badRequest() {
        val httpClient: HttpClient = HttpClients.createDefault()
        val request = HttpPatch("http://localhost:8080/updateUserRole")
        request.setHeader("Content-type", "application/json")
        httpClient.execute(request) { response: ClassicHttpResponse ->
            assertEquals(response.code, 400)
        }
    }
}
