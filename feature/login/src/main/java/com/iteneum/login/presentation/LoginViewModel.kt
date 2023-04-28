package com.iteneum.login.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _isEmailError = MutableStateFlow(false)
    val isEmailError: StateFlow<Boolean> = _isEmailError

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _isPasswordError = MutableStateFlow(false)
    val isPasswordError: StateFlow<Boolean> = _isPasswordError

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
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
        val isEmailValid = email.value.isValidEmail()
        val isPasswordValid = password.value.isValidPassword()

        when {
            isEmailValid && isPasswordValid -> {
                _isEmailError.value = false
                _isPasswordError.value = false
                checkLoginCredentials()
            }
            !isEmailValid && !isPasswordValid -> {
                _isEmailError.value = true
                _isPasswordError.value = true
            }
            else -> {
                _isEmailError.value = false
                _isPasswordError.value = false
                if (!isEmailValid) {
                    _isEmailError.value = true
                }
                if (!isPasswordValid) {
                    _isPasswordError.value = true
                }
            }
        }
    }

    private fun checkLoginCredentials() {
        // Logic to handle logins, either if it is a successful login or the credentials are wrong
    }
}
