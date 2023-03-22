
object ScreenManager {

    private val archivesListScreen = MenuScreen(1,"Создать архив", "Выход")
    private val notesListScreen = MenuScreen(2,"Создать заметку", "Назад")
    private val noteScreen = MenuScreen(3,"Добавить текст", "Назад")

    var isExitPressed = false

    private var currentScreen = archivesListScreen
    var currentArchive: Archive? = null
    var currentNote: Note? = null

    fun renderScreen() {
        currentScreen.renderMenu()
    }

    fun makeChoice() {
        val i = currentScreen.getMenuInput()

        when (currentScreen.screenID) {
            1 -> {
                when (i) {
                    0 -> isExitPressed = true
                    1 -> {
                        println("Введите название нового архива:")
                        archives.add(Archive(currentScreen.getTextInput(), mutableListOf()))
                    }
                    else -> {
                        currentArchive = archives[i - 2]
                        currentScreen = notesListScreen
                    }
                }
            }
            2 -> {
                when (i) {
                    0 -> currentScreen = archivesListScreen
                    1 -> {
                        println("Введите название новой заметки:")
                        currentArchive?.notes?.add(Note(currentScreen.getTextInput(), mutableListOf()))
                    }
                    else -> {
                        currentNote = currentArchive?.notes?.get(i - 2)
                        currentScreen = noteScreen
                    }
                }
            }
            3 -> {
                when (i) {
                    0 -> currentScreen = notesListScreen
                    1 -> {
                        println("Введите текст:")
                        currentNote?.content?.add(currentScreen.getTextInput())
                    }
                    2 -> currentNote?.content?.forEach { println(it) }
                }
            }
        }
    }

}