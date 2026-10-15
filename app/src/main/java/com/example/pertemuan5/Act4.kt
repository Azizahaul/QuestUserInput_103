package com.example.pertemuan5

@Composable
fun FormDataDiri(modifier: Modifier) {
        //variabel-variabel untuk mengingat nilai masukan dari keyboard
        var textNama by remember {mutableStateOf("")}
        var textAlamat by remember {mutableStateOf("")}
        var textJK by remember {mutableStateOf("")}
        val gender:List<String> = listOf("Laki-laki", "Perempuan")

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}
    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            onValueChange = { textNama = it },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Nama Lengkap") }
            on ValueChalenge = {
                textNama = it
            }
            // ... (lanjutan properti di foto terpotong)
        )
        Row {
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = { textJK = item }
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = textJK == item,
                        onclick = {
                            textJK = item

                        })
                    Text(item)
                }
            }
        }

        OutLinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = { text("Alamat") },
            onValueChange = {
                textAlamat = it
            }

        )
        Divider(
            modifier = Modifier.padding(bottom =
             dimensionResource(id=R.dimen.padding_medium), top = dimensionResource(
                 id = R.dimen.padding_medium
             )),

            thickness = dimensionResource(1dp)
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWitdh(fraction = 1f),
            //the button is enabled when the user makes a selection
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama=textNama
                jenis=textJK
                alamat=textAlamat
            }

        ) {
            Text(stringResource("Submit"))
        }
        Divider(
            modifier = Modifier.padding(bottom =
                dimensionResource(id=R.dimen.padding_medium), top = dimensionResource(
                id = R.dimen.padding_medium
            )),

            thickness = dimensionResource(1dp)
                    color = Color.DarkGray
        )





    }
    }


