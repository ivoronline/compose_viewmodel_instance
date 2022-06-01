package com.ivoronline.compose_viewmodel_instance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*

//==========================================================
// MAIN ACTIVITY
//==========================================================
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val myViewModel = MyViewModel()         //Create single Model Instance

    setContent {
      Column {
        MyCounter(myViewModel)              //The same Model Instance is the only Parameter
        MyCounter(myViewModel)              //The same Model Instance is the only Parameter
      }
    }

  }
}

//==========================================================
// COUNTER (Destination Composable)
//==========================================================
@Composable
fun MyCounter(myViewModel: MyViewModel) {
  Button({
    myViewModel.increase(10)                                             //Call Model Functions
    myViewModel.concat  (" hi")                                          //Call Model Functions
  }) {
    Text("(Count, Name) = (${myViewModel.count}, ${myViewModel.name})")  //Display State Variables
  }
}

