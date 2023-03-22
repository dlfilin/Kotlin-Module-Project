import java.util.*

class MenuScreen(val screenID: Int, private val createCaption: String, private val exitCaption: String) {

    private var menuTitle: String = ""
    private val menu: MutableMap<Int, String> = mutableMapOf()

    private fun updateMenuItems() {
        menu.clear()
        menu[0] = exitCaption
        menu[1] = createCaption
        when (screenID) {
            1 -> {
                menuTitle = "Архивы"
                archives.forEachIndexed { index, archive ->
                    menu[index+2] = archive.name }
            }
            2 -> {
                menuTitle = ScreenManager.currentArchive?.name ?: ""
                ScreenManager.currentArchive?.notes?.forEachIndexed { index, note ->
                    menu[index+2] = note.name }
            }
            3 -> {
                menuTitle = ScreenManager.currentNote?.name ?: ""
                menu[2] = "Просмотреть заметку"
            }
        }
    }

    fun renderMenu() {
        updateMenuItems()
        println("$menuTitle:")
        menu.forEach { println("[${it.key}] ${it.value}") }
    }

    fun getMenuInput(): Int {
        while (true) {
            val sc = Scanner(System.`in`)
            if (sc.hasNextInt()) {
                val input = sc.nextInt()
                if (input in 0 until menu.size) return input
                else println("Такого пункта меню нет, введите корректное значение:")
            } else println("Следует вводить корректные цифры:")
        }
    }

    fun getTextInput(): String {
        val sc = Scanner(System.`in`)
        return sc.nextLine()
    }

}