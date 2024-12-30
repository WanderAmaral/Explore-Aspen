package com.exploreaspen.data.model



data class Booking(
    val id: String,          // ID do agendamento
    val date: String,        // Data no formato "yyyy-MM-dd"
    val dayOfWeek: String,   // Dia da semana
    val time: String,        // Horário
    val doctorName: String   // Nome do médico
)
