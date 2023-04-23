class ArchiveNotesScreen(private val notes: MutableList<Note>): Screen<Note>(notes) {
    override fun printDescription() {
        println("Список заметок:")
    }
    override fun execute(chosenOption: Int) {
        when (chosenOption) {
            0 -> createNote()
            menu.size() - 1 -> exit()
            else -> open(chosenOption)
        }
    }

    private fun createNote() {
        var title: String
        println("Введите имя заметки")
        while (true) {
            title = readln()
            if (title.isBlank()) println("Введите непустой заголовок")
            else break
        }
        println("Введите описание заметки")
        var body = readln()
        if (body.isEmpty()) body = "<No description>"
        val note = Note(title, body)
        notes.add(note)
        menu.update(note.menuOption)
    }
    override fun open(option: Int) {
        NoteScreen(notes, option - 1).show()
    }
}