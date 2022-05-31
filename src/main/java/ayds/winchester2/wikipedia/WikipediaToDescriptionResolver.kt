package ayds.winchester2.wikipedia


import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Response

private const val SNIPPET = "snippet"
private const val SEARCH = "search"
private const val PAGE_ID = "pageid"
private const val QUERY = "query"

interface WikipediaToDescriptionResolver{
    fun getDescriptionFromExternalData(queryWikipediaSearch : Response<String>): WikipediaArticle
}

internal class WikipediaToDescriptionResolverImpl : WikipediaToDescriptionResolver{

    private fun makeDescription(queryWikipediaSearch: JsonObject): String {
        val snippet = getSnippet(queryWikipediaSearch)
        return getArtistDescription(snippet)
    }

    override fun getDescriptionFromExternalData(queryWikipediaSearch : Response<String>): WikipediaArticle {

        val gson = Gson()
        val jObj = gson.fromJson(queryWikipediaSearch.body(), JsonObject::class.java)

        val query = jObj[QUERY].asJsonObject

        val artistDescription = makeDescription(query)
        val pageId = getPageId(query).asString

        return WikipediaArticle(pageId,artistDescription)
    }

    private fun getSnippet(json: JsonObject) : JsonElement {
        return json[SEARCH].asJsonArray[0].asJsonObject[SNIPPET]
    }

    private fun getArtistDescription(snippet: JsonElement) : String{
        return snippet.asString.replace("\\n", "\n")
    }

    private fun getPageId(json: JsonObject) : JsonElement {
        return json[SEARCH].asJsonArray[0].asJsonObject[PAGE_ID]
    }

}