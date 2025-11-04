def estPair(n):
    'Indique si une nombre est pair'
    assert n >= 0 ;"Le nombre doit être positif"
    return (n & 1) == 0


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
