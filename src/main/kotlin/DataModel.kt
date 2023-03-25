data class Note(val name: String, val content: MutableList<String>)

data class Archive(val name: String, val notes: MutableList<Note>)

val archives: MutableList<Archive> = mutableListOf()
