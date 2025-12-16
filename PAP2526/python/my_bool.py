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


def decodeUtf8(n):
    '''n désigne un code utf8 ==> donne le code unicode'''
    res = 0
    if (n & 0x80) == 0:
        res = n
    elif (n & 0xff0000) == 0:
        res = n & 0x3f | (n & 0x1f00) >> 2
    else:
        res = n & 0x3f | (n & 0x3f00) >> 2 | (n & 0xf0000) >> 4
    return res  
        
