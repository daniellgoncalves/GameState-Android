package com.example.gamestate.ui.data

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroFitService {
    @POST("/user/forgotpwd")
    @Headers("Content-Type: application/json")
    fun sendEmail(@Body body: JsonObject): Call<ResponseBody>

    @POST("/user/register")
    @Headers("Content-Type: application/json")
    fun register(@Body body: JsonObject): Call<ResponseBody>

    @POST("/users/login")
    @Headers("Content-Type: application/json")
    fun login(@Body body: JsonObject): Call<ResponseBody>

    @GET("/games")
    @Headers("Content-Type: application/json")
    fun getPopularGames(@Header("Authorization") authorizationHeader: String, @Query("search") search: String, @Query("ordering") ordering: String): Call<ResponseBody>

    @GET("/games")
    @Headers("Content-Type: application/json")
    fun search(@Header("Authorization") authorizationHeader: String, @Query("search") search: String): Call<ResponseBody>

    @GET("/games/{id}")
    @Headers("Content-Type: application/json")
    fun searchByID(@Header("Authorization") authorizationHeader: String, @Path("id") id: Int): Call<ResponseBody>


    @POST("/game/searchbyid")
    @Headers("Content-Type: application/json")
    fun sendGameByID(@Header("Authorization") authorizationHeader: String, @Body body: JsonObject): Call<ResponseBody>

    @POST("/topics")
    @Headers("Content-Type: application/json")
    fun createTopic(@Header("Authorization") authorizationHeader: String, @Body body: JsonObject): Call<ResponseBody>

    @GET("/users/{username}/topics")
    @Headers("Content-Type: application/json")
    fun sendTopicByUser(@Header("Authorization") authorizationHeader: String, @Path("username") username: String): Call<ResponseBody>

    @GET("/topics/{id}")
    @Headers("Content-Type: application/json")
    fun sendTopicByID(@Header("Authorization") authorizationHeader: String, @Path("id") id: String): Call<ResponseBody>

    @POST("/topics/likedislike")
    @Headers("Content-Type: application/json")
    fun likeDislikeTopic(@Header("Authorization") authorizationHeader: String, @Body body: JsonObject): Call<ResponseBody>

    @POST("/topics/comments")
    @Headers("Content-Type: application/json")
    fun createcomment(@Header("Authorization") authorizationHeader: String, @Body body: JsonObject): Call<ResponseBody>

    @POST("/reviews/create")
    @Headers("Content-Type: application/json")
    fun createReview(@Header("Authorization") authorizationHeader: String, @Body body: JsonObject): Call<ResponseBody>

    @GET("/games/{id}/topics")
    @Headers("Content-Type: application/json")
    fun searchTopicByGameID(@Header("Authorization") authorizationHeader: String, @Path("id") id: Int): Call<ResponseBody>

    @GET("/users/{id}/subscribedgames")
    @Headers("Content-Type: application/json")
    fun getReviewsByUser(@Header("Authorization") authorizationHeader: String, @Path("id") id: String): Call<ResponseBody>

    @GET("/users/{id}/reviews")
    @Headers("Content-Type: application/json")
    fun findByUser(@Header("Authorization") authorizationHeader: String, @Path("id") id: String): Call<ResponseBody>
}