class SingleNoteMenu(
    override val createCaption: String,
    override val exitCaption: String
) : Menu() {

    override fun setMenuItems() {
        super.setMenuItems()
        menuTitle = ScreenManager.currentNote?.name ?: ""
        menu[2] = "Просмотреть заметку"
    }

    override fun chooseMenuItem() {
        when (getMenuInput()) {
            0 -> ScreenManager.currentScreen = ScreenManager.notesListScreen
            1 -> {
                println("Введите текст:")
                ScreenManager.currentNote?.content?.add(ScreenManager.currentScreen.getTextInput())
            }
            2 -> ScreenManager.currentNote?.content?.forEach { println(it) }
        }
    }


}