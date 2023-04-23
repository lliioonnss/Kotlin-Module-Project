data class Note(val title: String, val text: String): MenuOption {
    override val menuOption: String
        get() = title
    override fun toString(): String {
        return "Заголовок:\n$title\nТекст заметки:\n$text"
    }
}