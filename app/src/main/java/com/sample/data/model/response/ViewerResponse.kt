package com.sample.data.model.response

import com.google.gson.annotations.SerializedName

data class ViewerResponse(
    @SerializedName("Abstract")
    val abstract: String,
    @SerializedName("AbstractSource")
    val abstractSource: String,
    @SerializedName("AbstractText")
    val abstractText: String,
    @SerializedName("AbstractURL")
    val abstractUrl: String,
    @SerializedName("Answer")
    val answer: String,
    @SerializedName("AnswerType")
    val answerType: String,
    @SerializedName("Definition")
    val definition: String,
    @SerializedName("DefinitionSource")
    val definitionSource: String,
    @SerializedName("DefinitionURL")
    val definitionUrl: String,
    @SerializedName("Entity")
    val entity: String,
    @SerializedName("Heading")
    val heading: String,
    @SerializedName("Image")
    val image: String,
    @SerializedName("ImageHeight")
    val imageHeight: Long,
    @SerializedName("ImageIsLogo")
    val imageIsLogo: Long,
    @SerializedName("ImageWidth")
    val imageWidth: Long,
    @SerializedName("Infobox")
    val infobox: String,
    @SerializedName("Redirect")
    val redirect: String,
    @SerializedName("RelatedTopics")
    val relatedTopics: List<RelatedTopic>,
    @SerializedName("Results")
    val results: List<Any?>,
    @SerializedName("Type")
    val type: String,
    val meta: Meta,
)

data class RelatedTopic(
    @SerializedName("FirstURL")
    val firstUrl: String,
    @SerializedName("Icon")
    val icon: Icon,
    @SerializedName("Result")
    val result: String,
    @SerializedName("Text")
    val text: String,
)

data class Icon(
    @SerializedName("Height")
    val height: String,
    @SerializedName("URL")
    val url: String,
    @SerializedName("Width")
    val width: String,
)

data class Meta(
    val attribution: Any?,
    val blockgroup: Any?,
    @SerializedName("created_date")
    val createdDate: Any?,
    val description: String,
    val designer: Any?,
    @SerializedName("dev_date")
    val devDate: Any?,
    @SerializedName("dev_milestone")
    val devMilestone: String,
    val developer: List<Developer>,
    @SerializedName("example_query")
    val exampleQuery: String,
    val id: String,
    @SerializedName("is_stackexchange")
    val isStackexchange: Any?,
    @SerializedName("js_callback_name")
    val jsCallbackName: String,
    @SerializedName("live_date")
    val liveDate: Any?,
    val maintainer: Maintainer,
    val name: String,
    @SerializedName("perl_module")
    val perlModule: String,
    val producer: Any?,
    @SerializedName("production_state")
    val productionState: String,
    val repo: String,
    @SerializedName("signal_from")
    val signalFrom: String,
    @SerializedName("src_domain")
    val srcDomain: String,
    @SerializedName("src_id")
    val srcId: Long,
    @SerializedName("src_name")
    val srcName: String,
    @SerializedName("src_options")
    val srcOptions: SrcOptions,
    @SerializedName("src_url")
    val srcUrl: Any?,
    val status: String,
    val tab: String,
    val topic: List<String>,
    val unsafe: Long,
)

data class Developer(
    val name: String,
    val type: String,
    val url: String,
)

data class Maintainer(
    val github: String,
)

data class SrcOptions(
    val directory: String,
    @SerializedName("is_fanon")
    val isFanon: Long,
    @SerializedName("is_mediawiki")
    val isMediawiki: Long,
    @SerializedName("is_wikipedia")
    val isWikipedia: Long,
    val language: String,
    @SerializedName("min_abstract_length")
    val minAbstractLength: String,
    @SerializedName("skip_abstract")
    val skipAbstract: Long,
    @SerializedName("skip_abstract_paren")
    val skipAbstractParen: Long,
    @SerializedName("skip_end")
    val skipEnd: String,
    @SerializedName("skip_icon")
    val skipIcon: Long,
    @SerializedName("skip_image_name")
    val skipImageName: Long,
    @SerializedName("skip_qr")
    val skipQr: String,
    @SerializedName("source_skip")
    val sourceSkip: String,
    @SerializedName("src_info")
    val srcInfo: String,
)
