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
 * @param adult 
 * @param backdrop_path 
 * @param belongs_to_collection 
 * @param budget 
 * @param genres 
 * @param homepage 
 * @param id 
 * @param imdb_id 
 * @param original_language 
 * @param original_title 
 * @param overview 
 * @param popularity 
 * @param poster_path 
 * @param production_companies 
 * @param production_countries 
 * @param release_date 
 * @param revenue 
 * @param runtime 
 * @param spoken_languages 
 * @param status 
 * @param tagline 
 * @param title 
 * @param video 
 * @param vote_average 
 * @param vote_count 
 */
data class DetailedMovie (
        val adult: kotlin.Boolean? = null,
        val backdrop_path: kotlin.String? = null,
        val belongs_to_collection: kotlin.Any? = null,
        val budget: kotlin.Long? = null,
        val genres: kotlin.Array<Genre>? = null,
        val homepage: kotlin.String? = null,
        val id: kotlin.Long? = null,
        val imdb_id: kotlin.String? = null,
        val original_language: kotlin.String? = null,
        val original_title: kotlin.String? = null,
        val overview: kotlin.String? = null,
        val popularity: kotlin.Double? = null,
        val poster_path: kotlin.String? = null,
        val production_companies: kotlin.Array<ProductionCompany>? = null,
        val production_countries: kotlin.Array<ProductionCountry>? = null,
        val release_date: kotlin.String? = null,
        val revenue: kotlin.Long? = null,
        val runtime: kotlin.Long? = null,
        val spoken_languages: kotlin.Array<SpokenLanguage>? = null,
        val status: kotlin.String? = null,
        val tagline: kotlin.String? = null,
        val title: kotlin.String? = null,
        val video: kotlin.Boolean? = null,
        val vote_average: kotlin.Double? = null,
        val vote_count: kotlin.Long? = null
) {

}

