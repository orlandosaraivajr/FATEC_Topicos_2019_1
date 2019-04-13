all:
	g++ estacionamento.c --std=c++11 -g -o estacionamento
	g++ browser.c --std=c++11 -g -o browser
	g++ tarefas.c --std=c++11 -g -o tarefas

gabarito:
	g++ estacionamento_solucao.c --std=c++11 -g -o estacionamento_solucao
	g++ browser_solucao.c --std=c++11 -g -o browser_solucao
	g++ tarefas_solucao.c --std=c++11 -g -o tarefas_solucao

clean:
	rm -rf estacionamento browser tarefas
	rm -rf estacionamento_solucao browser_solucao tarefas_solucao

debug:
	nemiver ./tarefas
