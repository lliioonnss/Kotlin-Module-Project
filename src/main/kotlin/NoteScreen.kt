class NoteScreen(private val notes: MutableList<Note>, private val index:
Int): Screen<Note>(notes) {
    override fun printDescription() {
        println("Заметка ${notes[index].title}")
    }
    override fun show() {
        while (running) {
            printDescription()
            printNoteMenu()
            execute(getUserInput())
        }
    }
    private fun printNoteMenu() {
        println("0. Открыть заметку")
        println("1. Выход")
    }
    override fun execute(chosenOption: Int) {
        when (chosenOption) {
            0 -> open(index)
            else -> exit()
        }
    }
    override fun open(option: Int) {
        println(notes[option])
    }
}