package subrapidapp.composeapp.resources

fun getStringResource(key: String): String {
    return when (key) {
        "app_name" -> "Subrapid App"
        else -> "Unknown Resource"
    }
}