object ScreenManager {

    val archivesListScreen = ArchivesMenu("Создать архив", "Выход")
    val notesListScreen = NotesMenu("Создать заметку", "Назад")
    val noteScreen = SingleNoteMenu("Добавить текст", "Назад")

    var isExitPressed = false

    var currentScreen: Menu = archivesListScreen
    var currentArchive: Archive? = null
    var currentNote: Note? = null

    fun renderScreen() {
        currentScreen.renderMenu()
    }

    fun makeChoice() {
        currentScreen.chooseMenuItem()
    }

}