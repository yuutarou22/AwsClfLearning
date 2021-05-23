package com.example.awsclflearning.Util

import android.util.Log
import com.example.awsclflearning.Model.Answer
import com.example.awsclflearning.Model.QuestionModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.runBlocking

class FirestoreUtil {

    lateinit var listener: DailyQuestionListener

    fun getDailyQuestion() {
        var data = QuestionModel()

        val db = Firebase.firestore

        // 問題文の取得
        runBlocking {
            db.collection("Questions")
                .document("EmoLBGTZcw43q7QFIo0k")
                .get()
                .addOnSuccessListener { result ->
                    data.apply {
                        contents = result["contents"].toString()
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("TESTEST", "Error", exception)
                }
        }

        // 選択肢の取得
        lateinit var answers: List<Answer>
        db.collection("Questions")
            .document("EmoLBGTZcw43q7QFIo0k")
            .collection("answers")
            .get()
            .addOnSuccessListener { result ->
                answers = result.documents.map { it.data }.mapNotNull { it?.toTask() }
                data.answers = answers
                // 成功している場合は、リスナーにデータを返す
                if(listener != null) listener.onSuccess(data)
            }
            .addOnFailureListener { exception ->
                Log.w("TESTEST", "Error", exception)
            }
    }

    fun setDaylyQuestionListener(_listener: DailyQuestionListener) {
        this.listener = _listener
    }

    interface DailyQuestionListener {
        fun onSuccess(dailyQuestionData: QuestionModel)
    }

    fun Map<String, Any>.toTask(): Answer {
        val contents = this["contents"] as String
        val isAnswer = this["is_answer"] as Boolean
        return Answer(contents, isAnswer)
    }
}