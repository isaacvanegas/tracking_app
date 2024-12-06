package ni.gob.manera.seguimiento_proyecto.cookies

import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import java.util.Date

class Cookies : CookieJar {

    private val cookieStore = mutableMapOf<String, MutableList<Cookie>>() // Usar host como clave

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        val existingCookies = cookieStore[url.host]?.toMutableList() ?: mutableListOf()

        cookies.forEach { newCookie ->
            // Remover cookies existentes con el mismo nombre y path
            existingCookies.removeAll { it.name == newCookie.name && it.path == newCookie.path }
            existingCookies.add(newCookie)
        }
        cookieStore[url.host] = existingCookies
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val cookies = cookieStore[url.host] ?: return emptyList()
        val currentTimestamp = Date().time
        return cookies.filter { it.expiresAt > currentTimestamp && url.encodedPath.startsWith(it.path) }
    }

    fun clearCookies() {
        cookieStore.clear()
    }
}