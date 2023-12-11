fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""
    
    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()
    
    val lowerCase = {str: String -> str.lowercase()}

    println("Slug gerado para o livro:")
    
    println("${lowerCase(slugTitulo)}_${lowerCase(slugAutor)}")
}

fun String.generateSlug(): String {
    var stri = ""
    for (char in this) {
        stri += if (char.isLetterOrDigit()) char else if(char.isWhitespace()) "-" else "" //char.isLetterOrDigit() Verifica se e letra ou caractere
    }
    return stri
}

