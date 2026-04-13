package com.cineflix.android.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.theme.*
import com.cineflix.android.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onLoggedIn: () -> Unit,
) {
    val authState by viewModel.authState.collectAsState()
    val error     by viewModel.errorMessage.collectAsState()
    val loading   by viewModel.isLoading.collectAsState()

    LaunchedEffect(authState) {
        if (authState is TelegramEngine.AuthState.Ready) onLoggedIn()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Background, Color(0xFF0D0D1A)))),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Logo
            Text("🎬", fontSize = 64.sp)
            Spacer(Modifier.height(12.dp))
            Text(
                "Cineflix",
                style = MaterialTheme.typography.displayMedium,
                color = TextPrimary,
                fontWeight = FontWeight.Bold,
            )
            Text(
                "Tus series y películas de Telegram",
                style = MaterialTheme.typography.bodyMedium,
                color = TextMuted,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(48.dp))

            // Card
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = SurfaceCard,
                shape = RoundedCornerShape(20.dp),
                tonalElevation = 4.dp,
            ) {
                Column(Modifier.padding(24.dp)) {
                    AnimatedContent(
                        targetState = authState,
                        transitionSpec = {
                            slideInHorizontally { it } + fadeIn() togetherWith
                            slideOutHorizontally { -it } + fadeOut()
                        },
                        label = "auth_step"
                    ) { state ->
                        when (state) {
                            is TelegramEngine.AuthState.WaitPhone,
                            is TelegramEngine.AuthState.Unknown -> PhoneStep(loading, error, viewModel)
                            is TelegramEngine.AuthState.WaitCode -> CodeStep(loading, error, viewModel)
                            is TelegramEngine.AuthState.WaitPassword -> PasswordStep(loading, error, viewModel)
                            else -> Box(Modifier.height(80.dp), contentAlignment = Alignment.Center) {
                                CircularProgressIndicator(color = CineflixRed)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PhoneStep(loading: Boolean, error: String?, viewModel: AuthViewModel) {
    var phone by remember { mutableStateOf("") }
    val focus = LocalFocusManager.current
    Column {
        Text("Número de teléfono", style = MaterialTheme.typography.labelLarge, color = TextSecondary)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it; viewModel.clearError() },
            placeholder = { Text("+34 600 000 000", color = TextMuted) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focus.clearFocus(); viewModel.sendPhone(phone) }),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors(),
            shape = RoundedCornerShape(12.dp),
        )
        ErrorText(error)
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Enviar código", loading) { viewModel.sendPhone(phone) }
    }
}

@Composable
private fun CodeStep(loading: Boolean, error: String?, viewModel: AuthViewModel) {
    var code by remember { mutableStateOf("") }
    val focus = LocalFocusManager.current
    Column {
        Text("Código de verificación", style = MaterialTheme.typography.labelLarge, color = TextSecondary)
        Text("Revisa la app de Telegram en tu móvil", style = MaterialTheme.typography.bodySmall, color = TextMuted)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = code,
            onValueChange = { code = it.filter { c -> c.isDigit() }.take(6); viewModel.clearError() },
            placeholder = { Text("12345", color = TextMuted) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focus.clearFocus(); viewModel.verifyCode(code) }),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors(),
            shape = RoundedCornerShape(12.dp),
        )
        ErrorText(error)
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Verificar", loading) { viewModel.verifyCode(code) }
    }
}

@Composable
private fun PasswordStep(loading: Boolean, error: String?, viewModel: AuthViewModel) {
    var pass by remember { mutableStateOf("") }
    val focus = LocalFocusManager.current
    Column {
        Text("Contraseña 2FA", style = MaterialTheme.typography.labelLarge, color = TextSecondary)
        Text("Tu cuenta tiene verificación en dos pasos", style = MaterialTheme.typography.bodySmall, color = TextMuted)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it; viewModel.clearError() },
            placeholder = { Text("Contraseña", color = TextMuted) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focus.clearFocus(); viewModel.verify2FA(pass) }),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors(),
            shape = RoundedCornerShape(12.dp),
        )
        ErrorText(error)
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Entrar", loading) { viewModel.verify2FA(pass) }
    }
}

@Composable
private fun PrimaryButton(text: String, loading: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = !loading,
        modifier = Modifier.fillMaxWidth().height(52.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = CineflixRed),
    ) {
        if (loading) CircularProgressIndicator(Modifier.size(20.dp), color = Color.White, strokeWidth = 2.dp)
        else Text(text, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
    }
}

@Composable
private fun ErrorText(error: String?) {
    AnimatedVisibility(visible = !error.isNullOrEmpty()) {
        Text(
            error ?: "",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 6.dp),
        )
    }
}

@Composable
private fun textFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor   = CineflixRed,
    unfocusedBorderColor = Color(0xFF333350),
    focusedTextColor     = TextPrimary,
    unfocusedTextColor   = TextPrimary,
    cursorColor          = CineflixRed,
    focusedContainerColor   = Color(0xFF1A1A28),
    unfocusedContainerColor = Color(0xFF15151F),
)
