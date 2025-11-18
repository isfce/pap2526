def estPair(n):
    'Indique si une nombre est pair'
    assert n >= 0 ;"Le nombre doit être positif"
    return (n & 1) == 0

def fact(n):
    'Calcule la factorielle de n'
    assert n>=0 ;"n doit être positif "
    f = 1
    for i in range(2,n+1):
        f = f * i
    return f

def tableau(n,fct):
    'affiche un tableau avec l''opération fct'
    assert n<10;"n doit être <10"
    print('    ',end='')
    for i in range(1,n+1):
        print(f'{i:4}',end='')
    print()
    for i in range(0,n+1):
        print(f'____',end='')
    print()
    for a in range(1,n+1):
        print(f'{a:3}|',end='')
        for b in range(1,n+1):
            print(f'{fct(a,b):4}',end='')
        print()
    print('----------------------------------')

def nbZero(n):
    'Retourne le nombre de zéros dans n (base10)'
    assert n >= 0 ; "n doit être >=0"
    if n == 0:
        return 1
    cpt = 0
    while n != 0:
        if n % 10 == 0:
            cpt = cpt + 1
        n = n // 10
    return cpt


def nbPassages(n):
    "Nombre de passages avant d'obtenir 1"
    assert n > 0 ; "n doit être > 0"
    cpt = 0
    while n != 1:
        if (n & 1) == 0:
            n = n >> 1
        else:
            n = n * 3 + 1
        cpt = cpt + 1   
    return cpt


def speedConverter(v, unitI, unitD):
    return 0.0

if __name__=="__main__":
    tableau(4,lambda x,y:x+y)
    tableau(4,lambda x,y:x*y)
    tableau(4,lambda x,y:x//y)
    tableau(4,lambda x,y:x%y)
