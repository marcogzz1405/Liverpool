package com.example.liverpool.api

import com.example.liverpool.bases.BaseListener
import com.example.liverpool.models.Productos

interface ListenerBusqueda : BaseListener {

    fun showErrorMessage(message: String)

    fun successEntry(productos: Productos)

}