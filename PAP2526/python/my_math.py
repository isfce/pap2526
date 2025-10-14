def estPair(n):
    'Indique si une nombre est pair'
    assert n>=0 ;"Le nombre doit être positif"
    return (n & 1) == 0