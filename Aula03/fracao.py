class Fracao:
    numerador = 0
    denominador = 0

    def set_numerador(self):
        self.numerador = int(input("Digite o numerador: "))

    def set_denominador(self):
        while self.denominador <= 0:
            self.denominador = int(input("Digite o denominador: "))

    def fracao(self):
        return self.numerador / self.denominador


f = Fracao()
f.set_numerador()
f.set_denominador()
print(f.fracao())