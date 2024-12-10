package ni.com.groupi.tracking_app.request

import com.google.gson.annotations.SerializedName

class LoginRequest (
    @SerializedName("userNameOrEmailAddress") val userNameOrEmailAddress: String,
    @SerializedName("password") val password: String,
    @SerializedName("rememberMe") val rememberMe: Boolean,
)