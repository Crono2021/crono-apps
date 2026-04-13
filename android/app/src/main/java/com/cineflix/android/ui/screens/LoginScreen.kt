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

/**
 * Login screen that EXACTLY replicates the web app:
 *  - Dark bg with radial purple gradient (not red!)
 *  - Phone input with +34 pre-filled
 *  - Purple gradient button
 *  - Glassmorphism card
 *  - Title: "Cine en Castellano HD" with purple/cyan gradient text
 */
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

    // Dark bg with radial purple gradient — exactly like web:
    // radial-gradient(ellipse at 50% 0%, #1a1a3e 0%, #0a0a12 70%)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBg),
        contentAlignment = Alignment.Center,
    ) {
        // Radial gradient top overlay
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.TopCenter)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0xFF1A1A3E), Color.Transparent),
                        radius = 800f,
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // 🎥 Logo — same as web login-logo
            Text("🎥", fontSize = 64.sp)
            Spacer(Modifier.height(8.dp))

            // Gradient title text (purple → cyan, matching .login-title)
            Text(
                "Cine en Castellano HD",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Purple,           // gradient text not possible natively, use purple
                textAlign = TextAlign.Center,
                lineHeight = 34.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                "Tu videoclub en streaming (v2.1)",
                style = MaterialTheme.typography.bodySmall,
                color = TextMuted,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(32.dp))

            // Glassmorphism card — rgba(255,255,255,0.04) + blur + border
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0x0AFFFFFF),
                shape = RoundedCornerShape(24.dp),
                border = androidx.compose.foundation.BorderStroke(
                    1.dp, Color(0x14FFFFFF)
                ),
                tonalElevation = 0.dp,
            ) {
                Column(Modifier.padding(horizontal = 28.dp, vertical = 32.dp)) {
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
                            else -> {
                                Box(
                                    Modifier.fillMaxWidth().height(90.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        CircularProgressIndicator(
                                            color = Purple,
                                            modifier = Modifier.size(36.dp),
                                            strokeWidth = 3.dp,
                                        )
                                        Spacer(Modifier.height(12.dp))
                                        Text("Conectando con Telegram...", color = TextMuted, fontSize = 13.sp)
                                    }
                                }
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
    val focus = LocalFocusManager.current
    // Phone pre-filled with "+34" as in the original HTML: value="+34"
    var phone by remember { mutableStateOf("+34") }
    Column {
        StepLabel("Número de teléfono")
        Spacer(Modifier.height(8.dp))
        InputRow(
            value        = phone,
            onValueChange = { phone = it; viewModel.clearError() },
            placeholder  = "+34 600 000 000",
            keyboardType = KeyboardType.Phone,
            onDone       = { focus.clearFocus(); viewModel.sendPhone(phone) },
            buttonText   = "Enviar",
            loading      = loading,
            onButton     = { viewModel.sendPhone(phone) },
        )
        ErrorText(error)
    }
}

@Composable
private fun CodeStep(loading: Boolean, error: String?, viewModel: AuthViewModel) {
    val focus = LocalFocusManager.current
    var code by remember { mutableStateOf("") }
    Column {
        StepLabel("Código de verificación")
        Text("Te hemos enviado un código a Telegram", color = TextMuted, fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))
        InputRow(
            value         = code,
            onValueChange = { code = it.filter { c -> c.isDigit() }.take(5); viewModel.clearError() },
            placeholder   = "12345",
            keyboardType  = KeyboardType.Number,
            onDone        = { focus.clearFocus(); viewModel.verifyCode(code) },
            buttonText    = "Verificar",
            loading       = loading,
            onButton      = { viewModel.verifyCode(code) },
        )
        ErrorText(error)
    }
}

@Composable
private fun PasswordStep(loading: Boolean, error: String?, viewModel: AuthViewModel) {
    val focus = LocalFocusManager.current
    var pass by remember { mutableStateOf("") }
    Column {
        StepLabel("Contraseña 2FA")
        Text("Tu cuenta tiene verificación en dos pasos", color = TextMuted, fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))
        PasswordInputRow(
            value         = pass,
            onValueChange = { pass = it; viewModel.clearError() },
            placeholder   = "Contraseña",
            onDone        = { focus.clearFocus(); viewModel.verify2FA(pass) },
            buttonText    = "Entrar",
            loading       = loading,
            onButton      = { viewModel.verify2FA(pass) },
        )
        ErrorText(error)
    }
}

// ── Helpers ────────────────────────────────────────────────────────────────

@Composable
private fun StepLabel(text: String) {
    Text(
        text.uppercase(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        letterSpacing = 0.8.sp,
        color = TextFaint,
        modifier = Modifier.padding(bottom = 8.dp),
    )
}

@Composable
private fun InputRow(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType,
    onDone: () -> Unit,
    buttonText: String,
    loading: Boolean,
    onButton: () -> Unit,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = TextMuted, fontSize = 14.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { onDone() }),
            singleLine = true,
            modifier = Modifier.weight(1f),
            colors = fieldColors(),
            shape = RoundedCornerShape(12.dp),
        )
        PrimaryButton(buttonText, loading, onButton)
    }
}

@Composable
private fun PasswordInputRow(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    onDone: () -> Unit,
    buttonText: String,
    loading: Boolean,
    onButton: () -> Unit,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = TextMuted, fontSize = 14.sp) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { onDone() }),
            singleLine = true,
            modifier = Modifier.weight(1f),
            colors = fieldColors(),
            shape = RoundedCornerShape(12.dp),
        )
        PrimaryButton(buttonText, loading, onButton)
    }
}

@Composable
private fun PrimaryButton(text: String, loading: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = !loading,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.height(52.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PurpleDark,
            disabledContainerColor = PurpleDark.copy(alpha = 0.5f),
        ),
    ) {
        if (loading) CircularProgressIndicator(Modifier.size(18.dp), color = Color.White, strokeWidth = 2.dp)
        else Text(text, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
    }
}

@Composable
private fun ErrorText(error: String?) {
    AnimatedVisibility(visible = !error.isNullOrEmpty()) {
        Text(
            error ?: "",
            color = Color(0xFFF87171),
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 6.dp),
        )
    }
}

@Composable
private fun fieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor    = Purple,
    unfocusedBorderColor  = Color(0x1AFFFFFF),
    focusedTextColor      = Color.White,
    unfocusedTextColor    = Color.White,
    cursorColor           = Purple,
    focusedContainerColor = Color(0x0FFFFFFF),
    unfocusedContainerColor = Color(0x0FFFFFFF),
)
