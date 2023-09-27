package com.example.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navegacion.components.MainButton
import com.example.navegacion.components.MainIconButton
import com.example.navegacion.components.Space
import com.example.navegacion.components.TitleBar
import com.example.navegacion.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String?){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail View")},
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Red

                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack){
                        navController.popBackStack()
                    }
                }
            )
        }
    ){
        ContentDetailView(navController, id, opcional)
    }
}

@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        TitleView(name = "Detail View")
        Space()
        TitleView(name = id.toString())
        Space()
        if(opcional == ""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = opcional.orEmpty())
        }
        MainButton(name = "Return Home", backColor = Color.Black, color = Color.White
        ) {
            navController.popBackStack()
        }
    }
}