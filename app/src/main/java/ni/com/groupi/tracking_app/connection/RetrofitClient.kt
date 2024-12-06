package ni.com.groupi.tracking_app.connection


import ni.gob.manera.seguimiento_proyecto.apiservice.ApiService
import ni.gob.manera.seguimiento_proyecto.cookies.Cookies
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object RetrofitClient {
    private const val BASE_URL = "url host"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun getUnsafeOkHttpClient(): OkHttpClient {
        try {
            // Crea un administrador de confianza que no valida las cadenas de certificados
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
                override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
            })

            // Instala el "TrustManager" que confía en todos los certificados
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            // Crea un "SSL socket factory" con nuestro "TrustManager"
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })
            builder.cookieJar(Cookies())
            builder.addInterceptor(loggingInterceptor)
            return builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }


   private val retrofit: Retrofit =  Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(getUnsafeOkHttpClient())
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}