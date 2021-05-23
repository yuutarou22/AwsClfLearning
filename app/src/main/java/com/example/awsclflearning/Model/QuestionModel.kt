package com.example.awsclflearning.Model

data class QuestionModel (var id: String = "",
                          var contents: String = "",
                          var answers: List<Any> = listOf())
