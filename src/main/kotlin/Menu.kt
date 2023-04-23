class Menu <T: MenuOption> (private val data: MutableList<T>) {
    private val options = mutableListOf("Создать", "Выход")
    fun build() {
        for (item in data) {
            options.add(options.lastIndex, item.menuOption)
        }
    }
    fun print() {
        for (i in options.indices) {
            println("$i. ${options[i]}")
        }
    }
    fun update(option: String) {
        options.add(options.lastIndex, option)
    }
    fun size(): Int {
        return options.size
    }
}