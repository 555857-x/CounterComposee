package com.example.countercompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.countercompose.ui.theme.CounterComposeTheme

@Composable
fun DataDiriApp(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DataDiriViewModel = viewModel()
) {
    DataDiriScreen(
        nama = viewModel.nama,
        umur = viewModel.umur,
        onNamaChange = { viewModel.onNamaChange(it) },
        onUmurChange = { viewModel.onUmurChange(it) },
        onBack = onBack,
        modifier = modifier
    )
}

@Composable
fun DataDiriScreen(
    nama: String,
    umur: String,
    onNamaChange: (String) -> Unit,
    onUmurChange: (String) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Data Diri",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Form input nama
        OutlinedTextField(
            value = nama,
            onValueChange = onNamaChange,
            label = { Text("Nama") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Form input umur
        OutlinedTextField(
            value = umur,
            onValueChange = onUmurChange,
            label = { Text("Umur") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Ringkasan hasil inputan di bawah form
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (nama.isNotBlank() && umur.isNotBlank()) {
                    "Nama saya $nama dan umur saya $umur, Salam kenal!"
                } else {
                    "Isi nama dan umur untuk melihat ringkasan"
                },
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = if (nama.isNotBlank() && umur.isNotBlank()) Color.Black else Color.Gray
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("KEMBALI")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DataDiriScreenPreview() {
    CounterComposeTheme {
        DataDiriScreen(
            nama = "Muhammad Ardra Wirya Krisnayadi Putra",
            umur = "19",
            onNamaChange = {},
            onUmurChange = {},
            onBack = {}
        )
    }
}
