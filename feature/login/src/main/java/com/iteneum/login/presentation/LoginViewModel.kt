package com.iteneum.login.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * The [LoginViewModel] is the ViewModel in charge of notifying all the changes to the [LoginView],
 * here you can find the validations for the email and password fields, which are validated by the
 * login button, this ViewModel is also in charge to handle the login in the application, with email
 * and with the social network buttons below, and finally the register button is in charge to take
 * the user to a registering screen.
 *
 * @author Jesus Lopez
 */
@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    var isEmailError: Boolean by mutableStateOf(false)
        private set

    var email: String by mutableStateOf("")
        private set

    var isPasswordError: Boolean by mutableStateOf(false)
        private set

    var password: String by mutableStateOf("")
        private set

    var isSuccess: Boolean by mutableStateOf(false)
        private set

    var passwordVisible: Boolean by mutableStateOf(false)
        private set

    fun onPasswordVisibilityChanged() {
        passwordVisible = passwordVisible.not()
    }

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    private fun String.isValidEmail(): Boolean {
        val regex = Regex("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+\$")
        return matches(regex)
    }

    private fun String.isValidPassword(): Boolean {
        val minLength = 8
        val maxLength = 20
        return length in minLength..maxLength
    }

    fun onLoginClicked() {
        val isEmailValid = email.isValidEmail()
        val isPasswordValid = password.isValidPassword()

        when {
            isEmailValid && isPasswordValid -> {
                isEmailError = false
                isPasswordError = false
                checkLoginCredentials()
            }
            !isEmailValid && !isPasswordValid -> {
                isEmailError = true
                isPasswordError = true
            }
            else -> {
                isEmailError = false
                isPasswordError = false
                if (!isEmailValid) {
                    isEmailError = true
                }
                if (!isPasswordValid) {
                    isPasswordError = true
                }
            }
        }
    }

    private fun checkLoginCredentials() {
        // Logic to handle logins, either if it is a successful login or the credentials are wrong
        isSuccess = true
    }
}
