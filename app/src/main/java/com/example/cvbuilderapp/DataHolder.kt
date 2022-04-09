package com.example.cvbuilderapp

class DataHolder private constructor() {
    val homeTitle: ArrayList<String> = ArrayList()
    val homeDesc: ArrayList<String> = ArrayList()
    val aboutMeTitle: ArrayList<String> = ArrayList()
    val aboutMeDesc: ArrayList<String> = ArrayList()
    val workTitle: ArrayList<String> = ArrayList()
    val workDesc: ArrayList<String> = ArrayList()
    val contactTitle: ArrayList<String> = ArrayList()
    val contactDesc: ArrayList<String> = ArrayList()

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