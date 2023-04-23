class ArchiveScreen(private val archives: MutableList<Archive>):
    Screen<Archive>(archives) {
    override fun printDescription() {
        println("Список архивов:")
    }
    override fun execute(chosenOption: Int) {
        when (chosenOption) {
            0 -> createArchive()
            menu.size() - 1 -> exit()
            else -> open(chosenOption)
        }
    }
    private fun createArchive() {
        while (true) {
            println("Введите название архива")
            val input = readln()
            val archive = Archive(input)
            if (archives.contains(archive)) println("Такой архив уже есть")
            else {
                archives.add(archive)
                menu.update(archive.menuOption)
                break
            }
        }
    }
    override fun open(option: Int) {
        ArchiveNotesScreen(archives[option - 1].notes).show()
    }
}
