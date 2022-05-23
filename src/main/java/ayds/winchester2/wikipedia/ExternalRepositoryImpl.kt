package ayds.winchester2.wikipedia


interface ExternalRepository {
    fun getArtistDescription(artistName: String): Description
}

internal class ExternalRepositoryImpl(
    private var wikipediaAPI: WikipediaAPI,
    private var wikipediaToDescriptionResolver: WikipediaToDescriptionResolver
) : ExternalRepository {

    override fun getArtistDescription(artistName: String): Description {
        val queryWikipediaSearch = wikipediaAPI.getArtistInfo(artistName).execute()

        return wikipediaToDescriptionResolver.getDescriptionFromExternalData(queryWikipediaSearch)
    }
}