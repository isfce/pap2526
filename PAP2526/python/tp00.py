def calculDecision(note : int)->str:
    '''
     Calcule la décision sur base de la note
     note => Echec, Ajourné, Réussite
    '''
    assert 0<=note<=100 ;' La note doit être entre 0 et 100'
    if note < 30 : 
        decision = 'Refus'
    elif note<50 :
        decision = 'Ajourné'
    else:
        decision = 'Réussite'
    return decision

if __name__=='__main__':
    #Input
    note = int(input('Entrez une note entre 0 et 100: '))

    #Traitement
    decision = calculDecision(note)

    #Output
    print(f'La note de {note} a comme décision: {decision}')
