/*
 * Exercício 1 da lista
 *
 * Prof. Me. Orlando Saraiva Jr
 * Criado em : 10/04/2018
 * Alterado em : 14/09/2018
 */
#include <stdio.h>
#include <iostream>
#include <stdlib.h>

using namespace std;

#define MAXIMO_VAGAS 10


struct Carro {
    string  placa;
    string modelo;
    int ano;
};

struct Pilha {
    Carro   data[MAXIMO_VAGAS];
    int     size;
};

void inicializar(Pilha *S) {
    int x;
    Carro carro_vazio;
    S->size = 0;
    carro_vazio.modelo = "";
    carro_vazio.placa = "";
    carro_vazio.ano = 0;
    for(x=0; x<MAXIMO_VAGAS; x++) {
        S->data[x] = carro_vazio;
    }

}

void empilhar(Pilha *S) {
    Carro carro_temp;

    if (S->size < MAXIMO_VAGAS) {
        cout << "Digite a placa do carro \n";
	    cin >> carro_temp.placa;
        cout << "Digite o modelo do carro \n";
	    cin >> carro_temp.modelo;
        cout << "Digite o ano \n";
	    cin >> carro_temp.ano;
        S->data[S->size] = carro_temp;
        S->size++;
    }else {
        fprintf(stderr, "Estacionamento cheio.\n");
    }

}

Carro desempilhar(Pilha *S) {
    Carro retorno,carro_vazio;

    if (S->size == 0) {
        fprintf(stderr, "Estacionamento vazio.\n");
        exit(-1);
    } else {
        carro_vazio.modelo = "";
        carro_vazio.placa = "";
        carro_vazio.ano = 00;
        retorno = S->data[S->size-1];
        S->data[S->size-1] = carro_vazio;
        S->size--;
        return(retorno);
    }
}

void imprime_pilha(Pilha *S) {
    int x;
    Carro carro_tmp;
	for (x = S->size; x > 0 ; x--) {
        carro_tmp = S->data[x-1];
        // cout << "Carro \t"<< S->data[x-1].modelo << "\n";
        cout << "Carro \t"<< carro_tmp.modelo << "\tano \t" << carro_tmp.ano << "\tplaca \t" << carro_tmp.placa << "\n";
    }
    cout << "\n\n";
}

void imprime_carro(Carro carro_tmp) {
    cout << "Carro: \t"<< carro_tmp.modelo << "\n";
    cout << "Ano \t" << carro_tmp.ano << " \n";
    cout << "Placa \t" << carro_tmp.placa << "\n";
    cout << "\n\n";
}

int main() {
    Pilha minhaPilha;
    Carro valor;
    char escolha = 'x';
    inicializar(&minhaPilha);

    do {
        cout << "\n********************************\n";
        cout << "Digite uma letra\n\n";
        cout << "e \t Estacionar\n";
        cout << "s \t Check-out\n";
        cout << "i \t imprimir pilha \n";
        cout << "q \t Sair do programa.\n\n\n";
        cin >> escolha;
        if(escolha == 'e' || escolha == 'E'){
            empilhar(&minhaPilha);
        }
        if(escolha == 'i' || escolha == 'I'){
            imprime_pilha(&minhaPilha);
        }
        if(escolha == 's' || escolha == 'S'){
            cout << "Carro de saída: \n";
            valor = desempilhar(&minhaPilha);
            imprime_carro(valor);
        }
    } while( escolha != 'q');
}
