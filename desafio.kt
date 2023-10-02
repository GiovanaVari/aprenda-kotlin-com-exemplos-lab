// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
         inscritos.add(usuario)
    }
    
    fun exibirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun exibirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    
    //Criando variaveis dos cursos individuais
    val moduloCSharp = ConteudoEducacional("curso c#", 90)
    val moduloJava = ConteudoEducacional("curso java", 110)
    val moduloKotlin = ConteudoEducacional("curso kotlin", 100)
    val moduloLogica = ConteudoEducacional("curso logica", 70)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloCSharp)
    listConteudos.add(moduloJava)
    listConteudos.add(moduloKotlin)
    listConteudos.add(moduloLogica)
    
    //Criando variavel da formação completa com os cursos
    val formacaoProgramacao = Formacao("Formação Programação", listConteudos, Nivel.INTERMEDIARIO)
    
    //Criando a lista de usuarios
    val rose = Usuario("rose", "rose@gmail.com")
    val pedro = Usuario("pedro", "pedro@gmail.com")
    val juliano = Usuario("juliano", "juliano@gmail.com")
    val rafaela = Usuario("rafaela", "rafaela@gmail.com")
    
    //Matriculando usuarios na formação
    formacaoProgramacao.matricular(rose)
    formacaoProgramacao.matricular(pedro)
    formacaoProgramacao.matricular(juliano)
    formacaoProgramacao.matricular(rafaela)
    
    println("---------------------------------------")
    println("Dados da formação: ")
    println("${formacaoProgramacao.nome} - ${formacaoProgramacao.nivel}")
    println("\nGrade formação: ")
    println(formacaoProgramacao.exibirGradeFormacao())
    println("\n---------------------------------------")
    println("Lista de inscritos: ")
    println(formacaoProgramacao.exibirListaInscritos())
}