package ayds.winchester2.wikipedia

data class Description(
     val id: String,
     val description: String,
     var isLocallyStored: Boolean = false
)
