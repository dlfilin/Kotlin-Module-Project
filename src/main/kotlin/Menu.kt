import java.util.*

abstract class Menu {

    abstract val createCaption: String
    abstract val exitCaption: String

    var menuTitle: String = ""
    val menu: MutableMap<Int, String> = mutableMapOf()

    open fun setMenuItems() {
        menu.clear()
        menu[0] = exitCaption
        menu[1] = createCaption
    }

    abstract fun chooseMenuItem()

    fun renderMenu() {
        setMenuItems()
        println("$menuTitle:")
        menu.forEach { println("[${it.key}] ${it.value}") }
    }

    fun getMenuInput(): Int {
        println("Выберите пункт меню:")
        while (true) {
            val sc = Scanner(System.`in`)
            if (sc.hasNextInt()) {
                val input = sc.nextInt()
                if (input in 0 until menu.size) return input
                else {
                    renderMenu()
                    println("Такого пункта меню нет, введите корректное значение:")
                }
            } else {
                renderMenu()
                println("Введите корректные цифры:")
            }
        }
    }

    fun getTextInput(): String = Scanner(System.`in`).nextLine()

}