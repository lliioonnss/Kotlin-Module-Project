abstract class Screen <T: MenuOption> (private val data: MutableList<T>) {
    protected val menu = Menu(data)
    protected var running = true
    open fun show() {
        menu.build()
        while (running) {
            printDescription()
            menu.print()
            executeAction()
        }
    }
    abstract fun printDescription()
    private fun executeAction() {
        val chosenOption = getUserInput()
        execute(chosenOption)
    }
    abstract fun execute(chosenOption: Int)
    protected fun getUserInput(): Int {
        while (true) {
            println("Введите номер пункта меню")
            when (val input = readln().toIntOrNull()) {
                null -> println("Вы ввели не цифру, попробуйте еще раз")
                !in 0 until menu.size() -> println("Такого пункта меню нет, попробуйте еще раз")
                    else -> return input
            }
        }
    }
    protected fun exit() {
        running = false
    }
    abstract fun open(option: Int)
}