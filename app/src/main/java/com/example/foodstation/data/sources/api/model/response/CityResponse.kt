package com.example.foodstation.data.sources.api.model.response


import com.google.gson.annotations.SerializedName

data class CityResponse(
    @SerializedName("has_more")
    var hasMore: Int?,
    @SerializedName("has_total")
    var hasTotal: Int?,
    @SerializedName("location_suggestions")
    var locationSuggestions: List<LocationSuggestion?>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("user_has_addresses")
    var userHasAddresses: Boolean?
) {
    data class LocationSuggestion(
        @SerializedName("country_flag_url")
        var countryFlagUrl: String?,
        @SerializedName("country_id")
        var countryId: Int?,
        @SerializedName("country_name")
        var countryName: String?,
        @SerializedName("discovery_enabled")
        var discoveryEnabled: Int?,
        @SerializedName("has_go_out_tab")
        var hasGoOutTab: Int?,
        @SerializedName("has_new_ad_format")
        var hasNewAdFormat: Int?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("is_state")
        var isState: Int?,
        @SerializedName("name")
        var name: String?,
        @SerializedName("should_experiment_with")
        var shouldExperimentWith: Int?,
        @SerializedName("state_code")
        var stateCode: String?,
        @SerializedName("state_id")
        var stateId: Int?,
        @SerializedName("state_name")
        var stateName: String?
    )
}