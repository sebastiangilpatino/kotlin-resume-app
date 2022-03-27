package com.example.cvbuilderapp

class DataHolder private constructor() {
    val title: ArrayList<String> = ArrayList()
    val desc: ArrayList<String> = ArrayList()

    companion object {
        var instance: DataHolder? = null
            get() {
                if (field == null) {
                    field = DataHolder()
                }
                return field
            }
            private set
    }
}