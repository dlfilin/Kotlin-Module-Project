class ArchivesMenu(
    override val createCaption: String,
    override val exitCaption: String
) : Menu() {

    override fun setMenuItems() {
        super.setMenuItems()
        menuTitle = "Архивы"
        archives.forEachIndexed { index, archive ->
            menu[index + 2] = archive.name
        }
    }

    override fun chooseMenuItem() {
        when (val i = getMenuInput()) {
            0 -> ScreenManager.isExitPressed = true
            1 -> {
                println("Введите название нового архива:")
                archives.add(Archive(getTextInput(), mutableListOf()))
            }
            else -> {
                ScreenManager.currentArchive = archives[i - 2]
                ScreenManager.currentScreen = ScreenManager.notesListScreen
            }
        }
    }


}