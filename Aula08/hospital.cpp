/*
 * Exercício 3
 *
 * Prof. Me. Orlando Saraiva Jr
 * Criado em : 27/09/2018
 */
#include <iostream>
#include <sstream>

using namespace std;

typedef struct {
    string nome;
    int idade;
}ELEMENTO;

 typedef struct NO{
 	ELEMENTO cliente;
 	struct NO* prox;
 }*FILA;

static FILA fila_emergencia;
static FILA fila_urgencia;
static FILA fila_pouco_urgente;
static FILA fila_nao_urgente;

 void inicializar(){
    fila_emergencia = new NO;
    fila_urgencia = new NO;
    fila_pouco_urgente = new NO;
    fila_nao_urgente = new NO;
 	fila_urgencia->prox = NULL;
    fila_emergencia->prox = NULL;
    fila_nao_urgente->prox = NULL;
    fila_pouco_urgente->prox = NULL;
 	return;
 }

 void enqueue(){
    int urgencia;
     ELEMENTO novo_cliente;
     cout << "Digite o nome do paciente " << endl;
     cin >> novo_cliente.nome;
     cout << "Digite a idade do paciente " << endl;
     cin >> novo_cliente.idade;
     cout << "Gravidade do caso " << endl;
     cout << "1 = Emergência " << endl;
     cout << "2 = Urgência " << endl;
     cout << "3 = Pouco Urgente " << endl;
     cout << "4 = Não Urgente " << endl;
     cin >> urgencia;
    if(urgencia == 1) {
         FILA aux =  new NO;
         aux->cliente = (ELEMENTO) novo_cliente;
         aux->prox  = (FILA)fila_emergencia;
         fila_emergencia = aux;
    } 
    if(urgencia == 2) {
         FILA aux =  new NO;
         aux->cliente = (ELEMENTO) novo_cliente;
         aux->prox  = (FILA)fila_urgencia;
         fila_urgencia = aux;
    }
    if(urgencia == 3) {
         FILA aux =  new NO;
         aux->cliente = (ELEMENTO) novo_cliente;
         aux->prox  = (FILA)fila_pouco_urgente;
         fila_pouco_urgente = aux;
     }
    if(urgencia == 4) {
         FILA aux =  new NO;
         aux->cliente = (ELEMENTO) novo_cliente;
         aux->prox  = (FILA)fila_nao_urgente;
         fila_nao_urgente = aux;
     }
 }


 void mostraFila(){
    FILA no = fila_emergencia;
    cout << "Fila Emergência " << endl;
 	while(no != NULL){
        if (no->prox != NULL) {
            cout <<"[" << no->cliente.nome << "] -> ";
        }
 		no = no->prox;
 	}

    no = fila_urgencia;
    cout << endl << endl << "Fila Urgência " << endl;
    while(no != NULL){
        if (no->prox != NULL) {
            cout <<"[" << no->cliente.nome << "] -> ";
        }
        no = no->prox;
    }
 	cout << endl;

    no = fila_pouco_urgente;
    cout << endl << endl << "Fila Pouco Urgente " << endl;
    while(no != NULL){
        if (no->prox != NULL) {
            cout <<"[" << no->cliente.nome << "] -> ";
        }
        no = no->prox;
    }
    cout << endl;

    no = fila_nao_urgente;
    cout << endl << endl << "Fila Não Urgência " << endl;
    while(no != NULL){
        if (no->prox != NULL) {
            cout <<"[" << no->cliente.nome << "] -> ";
        }
        no = no->prox;
    }
    cout << endl;
 }

 ELEMENTO dequeue(){
    ELEMENTO temp;
    FILA noAnterior;
    FILA noAtual;
    temp.nome = "";
    temp.idade = -1;
    if(fila_emergencia->prox == NULL ) {
        if(fila_urgencia->prox == NULL ) {
            if(fila_pouco_urgente->prox == NULL ) {
                if(fila_nao_urgente->prox == NULL ) {
                    cout << "Nenhum cliente na fila";
                } else {
                    noAnterior = fila_nao_urgente;
                    noAtual = fila_nao_urgente;
                    while(noAtual->prox != NULL){
                        noAnterior = noAtual;
                        noAtual = noAtual->prox;
                    }
                    noAnterior->prox = NULL;
                    temp = noAnterior->cliente;
                    delete noAnterior;
                    }    
            } else {
            noAnterior = fila_pouco_urgente;
            noAtual = fila_pouco_urgente;
            while(noAtual->prox != NULL){
                noAnterior = noAtual;
                noAtual = noAtual->prox;
            }
            noAnterior->prox = NULL;
            temp = noAnterior->cliente;
            delete noAnterior;
            }
        } else {
            noAnterior = fila_urgencia;
            noAtual = fila_urgencia;
         	while(noAtual->prox != NULL){
         		noAnterior = noAtual;
         		noAtual = noAtual->prox;
         	}
         	noAnterior->prox = NULL;
            temp = noAnterior->cliente;
            delete noAnterior;
        }
    } else {
        noAnterior = fila_emergencia;
        noAtual =  fila_emergencia;
     	while(noAtual->prox != NULL){
     		noAnterior = noAtual;
     		noAtual = noAtual->prox;
     	}
     	noAnterior->prox = NULL;
        temp = noAnterior->cliente;
        delete noAnterior;
    }
    return temp;
 }

 int tamanhoFilaEmergencia(){
     FILA fila_local = fila_emergencia;
    int cont = 0;
    while(fila_local != NULL){
        fila_local = fila_local->prox;
        cont++;
    }
    return (cont - 1);
 }

 int tamanhoFilaUrgencia(){
     FILA fila_local = fila_urgencia;
    int cont = 0;
    while(fila_local != NULL){
        fila_local = fila_local->prox;
        cont++;
    }
    return (cont - 1);
 }

int tamanhoFilaPoucoUrgente(){
     FILA fila_local = fila_pouco_urgente;
    int cont = 0;
    while(fila_local != NULL){
        fila_local = fila_local->prox;
        cont++;
    }
    return (cont - 1);
 }

int tamanhoFilaNaoUrgente(){
     FILA fila_local = fila_nao_urgente;
    int cont = 0;
    while(fila_local != NULL){
        fila_local = fila_local->prox;
        cont++;
    }
    return (cont - 1);
 }
 int tamanhoFila(){
    int cont = 0;
    cont = cont + tamanhoFilaEmergencia();
    cont = cont + tamanhoFilaUrgencia();
    cont = cont + tamanhoFilaPoucoUrgente();
    cont = cont + tamanhoFilaNaoUrgente();
    return (cont);
 }

 void destruir(){
    if(fila_emergencia->prox != NULL ) {
        FILA noProximo = fila_emergencia;
        while(noProximo->prox != NULL){
            cout << "| " << noProximo->cliente.nome;
            cout << " - " << noProximo->cliente.idade << endl;
            fila_emergencia = noProximo->prox;
            noProximo->prox = NULL;
            delete noProximo;
            noProximo = fila_emergencia;
     	}
    }
    if(fila_urgencia->prox != NULL ) {
        FILA noProximo = fila_urgencia;
        while(noProximo->prox != NULL){
            cout << "| " << noProximo->cliente.nome;
            cout << " - " << noProximo->cliente.idade << endl;
            fila_urgencia = noProximo->prox;
            noProximo->prox = NULL;
            delete noProximo;
            noProximo = fila_urgencia;
        }
    }
    if(fila_pouco_urgente->prox != NULL ) {
        FILA noProximo = fila_pouco_urgente;
        while(noProximo->prox != NULL){
            cout << "| " << noProximo->cliente.nome;
            cout << " - " << noProximo->cliente.idade << endl;
            fila_pouco_urgente = noProximo->prox;
            noProximo->prox = NULL;
            delete noProximo;
            noProximo = fila_pouco_urgente;
        }
    }
    if(fila_pouco_urgente->prox != NULL ) {
        FILA noProximo = fila_pouco_urgente;
        while(noProximo->prox != NULL){
            cout << "| " << noProximo->cliente.nome;
            cout << " - " << noProximo->cliente.idade << endl;
            fila_pouco_urgente = noProximo->prox;
            noProximo->prox = NULL;
            delete noProximo;
            noProximo = fila_pouco_urgente;
        }
    }


    delete fila_emergencia;
    delete fila_urgencia;
    delete fila_pouco_urgente;
    delete fila_nao_urgente;
 }

int main(){
     char escolha = 'x';
     ELEMENTO paciente_com_medico;
     inicializar();
     do {
           cout << "\n********************************\n";
           cout << "Digite uma letra\n\n";
           cout << "i \t Inserir na fila\n";
           cout << "a \t Atender paciente\n";
           cout << "p \t Exibir as filas \n";
           cout << "q \t Fechar hospital.\n\n\n";
           cin >> escolha;
           if(escolha == 'i' || escolha == 'I'){
               enqueue();
           }
           
           if(escolha == 'a' || escolha == 'A'){
               paciente_com_medico = dequeue();
               if(paciente_com_medico.nome != ""){
                   cout << " Atendimento para : " << endl;
                   cout << paciente_com_medico.nome <<" - ";
                   cout << paciente_com_medico.idade <<" anos ";
                   cout << endl;
               }
           }
           if(escolha == 'p' || escolha == 'P'){
               cout << "Tamanho da fila Emergência: " << tamanhoFilaEmergencia() << endl;
               cout << "Tamanho da fila Urgência: " << tamanhoFilaUrgencia() << endl;
               cout << "Tamanho da fila Pouco Urgência: " << tamanhoFilaPoucoUrgente() << endl;
               cout << "Tamanho da fila Não Urgência: " << tamanhoFilaNaoUrgente() << endl;
               mostraFila();
           }
       } while( escolha != 'q');

     destruir();
     return 0;
 }
