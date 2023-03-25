class NotesMenu(
    override val createCaption: String,
    override val exitCaption: String
) : Menu() {

    override fun setMenuItems() {
        super.setMenuItems()
        menuTitle = ScreenManager.currentArchive?.name ?: ""
        ScreenManager.currentArchive?.notes?.forEachIndexed { index, note ->
            menu[index + 2] = note.name
        }
    }

    override fun chooseMenuItem() {
        when (val i = getMenuInput()) {
            0 -> ScreenManager.currentScreen = ScreenManager.archivesListScreen
            1 -> {
                println("Введите название новой заметки:")
                ScreenManager.currentArchive?.notes?.add(
                    Note(
                        ScreenManager.currentScreen.getTextInput(),
                        mutableListOf()
                    )
                )
            }
            else -> {
                ScreenManager.currentNote = ScreenManager.currentArchive?.notes?.get(i - 2)
                ScreenManager.currentScreen = ScreenManager.noteScreen
            }
        }
    }


}