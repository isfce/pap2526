from thonny import res
from cgitb import reset


def estMajuscule(c):
    'Indique si un caractère est une majuscule'
    return (ord(c) & 32) == 0


def intToHex(n):
    assert n >= 0;"n doit être positif"
    if n == 0: 
        return "0x0"
    res = ""
    while n != 0:
        v = n & 15
        c = chr(48 + v if v <= 9 else (55 + 32 + v))
        res = c + res
        n = n >> 4
    return "0x" + res

