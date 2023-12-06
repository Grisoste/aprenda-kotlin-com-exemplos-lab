import java.util.*

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String) {

    private val conteudos = mutableListOf<ConteudoEducacional>()
    private val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        try {
            conteudos.add(conteudo)
            println("Conteúdo '${conteudo.nome}' adicionado à formação $nome.")
        } catch (e: Exception) {
            println("Erro ao adicionar conteúdo à formação $nome: ${e.message}")
        }
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        try {
            conteudos.remove(conteudo)
            println("Conteúdo '${conteudo.nome}' removido da formação $nome.")
        } catch (e: Exception) {
            println("Erro ao remover conteúdo da formação $nome: ${e.message}")
        }
    }

    fun matricular(usuario: Usuario) {
        try {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } catch (e: Exception) {
            println("Erro ao matricular usuário na formação $nome: ${e.message}")
        }
    }

    fun desmatricular(usuario: Usuario) {
        try {
            inscritos.remove(usuario)
            println("Usuário ${usuario.nome} removido da formação $nome.")
        } catch (e: Exception) {
            println("Erro ao desmatricular usuário na formação $nome: ${e.message}")
        }
    }

    fun exibirConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEach { conteudo ->
            println("${conteudo.nome} - Duração: ${conteudo.duracao} minutos")
        }
    }

    fun exibirInscritos() {
        println("Usuários matriculados na formação $nome: ${inscritos.joinToString { it.nome }}")
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
    formacaoKotlin.exibirInscritos()

    formacaoKotlin.desmatricular(usuario1)
    formacaoKotlin.removerConteudo(kotlinBasico)

    formacaoKotlin.exibirInscritos()
    formacaoKotlin.exibirConteudos()
}
