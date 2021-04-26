/**
* Movier
* This is the description of the called APIs
*
* OpenAPI spec version: 1.0.0
* Contact: gszasza1@gmail.com
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package com.baei7j.movier.network.models


/**
 * 
 * @param poster_path 
 * @param adult 
 * @param overview 
 * @param release_date 
 * @param genre_ids 
 * @param id 
 * @param original_title 
 * @param original_language 
 * @param title 
 * @param backdrop_path 
 * @param popularity 
 * @param vote_count 
 * @param video 
 * @param vote_average 
 */
data class Movie (
    val poster_path: kotlin.String? = null,
    val adult: kotlin.Boolean? = null,
    val overview: kotlin.String? = null,
    val release_date: kotlin.String? = null,
    val genre_ids: kotlin.Array<kotlin.Int>? = null,
    val id: kotlin.Long? = null,
    val original_title: kotlin.String? = null,
    val original_language: kotlin.String? = null,
    val title: kotlin.String? = null,
    val backdrop_path: kotlin.String? = null,
    val popularity: kotlin.Long? = null,
    val vote_count: kotlin.Long? = null,
    val video: kotlin.Boolean? = null,
    val vote_average: kotlin.Long? = null
) {

}

