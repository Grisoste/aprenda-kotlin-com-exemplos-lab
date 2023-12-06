enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}' adicionado à formação $nome.")
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun exibirConteudos() {
        println("Conteúdos da formação $nome:")
        for (conteudo in conteudos) {
            println("${conteudo.nome} - Duração: ${conteudo.duracao} minutos")
        }
    }
}

fun main() {
    
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 60)
    val kotlinIntermediario = ConteudoEducacional("Programação Kotlin Intermediária", 90)
    val kotlinAvancado = ConteudoEducacional("Desenvolvimento Avançado em Kotlin", 120)

    
    val formacaoKotlin = Formacao("Formação Kotlin")

    
    formacaoKotlin.adicionarConteudo(kotlinBasico)
    formacaoKotlin.adicionarConteudo(kotlinIntermediario)
    formacaoKotlin.adicionarConteudo(kotlinAvancado)

    
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    
    formacaoKotlin.exibirConteudos()
    println("Usuários matriculados na formação ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nome }}")
}
