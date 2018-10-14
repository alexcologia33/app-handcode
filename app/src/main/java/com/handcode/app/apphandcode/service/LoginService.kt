package com.handcode.app.apphandcode.model

import com.handcode.app.apphandcode.service.BaseService
import com.handcode.app.apphandcode.vo.TokenContainer
import fernandosousa.com.br.lmsapp.HttpHelper

object LoginService : BaseService() {

    @Throws(AlunoNaoEncontradoException::class, SenhaIncorretaException::class)
    fun logar(email : String, senha : String) : TokenContainer {
        val json = HttpHelper.post(loginURL(), Aluno(email,senha).toJson())
        val tokenContainer : TokenContainer = parserJson(json)
        return tokenContainer
    }

    fun informacoesUsuarioAutenticado(tokenContainer : TokenContainer) : Aluno {
        val json = HttpHelper.getAutenticado(usuarioAutenticadoDetalhesURL(),tokenContainer)
        val aluno : Aluno = parserJson(json)
        return aluno
    }
}