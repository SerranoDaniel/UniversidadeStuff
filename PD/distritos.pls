distrito(beja).
distrito(evora).
distrito(faro).
distrito(setubal).
distrito(lisboa).
distrito(portalegre).
distrito(santarem).
distrito(leiria).
distrito(coimbra).
distrito(castelo_branco).
distrito(aveiro).
distrito(viseu).
distrito(guarda).
distrito(porto).
distrito(braga).
distrito(Viana_do_castelo).
distrito(vila_real).
distrito(braganca).


capital(beja,beja).
capital(evora,evora).
capital(faro,faro).
capital(setubal,setubal).
capital(lisboa,lisboa).
capital(portalegre,portalegre).
capital(santarem,santarem).
capital(leiria,lisboa).
capital(coimbra,licoimbrasboa).
capital(castelo_branco,castelo_branco).
capital(aveiro,aveiro).
capital(viseu,viseu).
capital(guarda,guarda).
capital(porto,porta).
capital(braga,braga).
capital(Viana_do_castelo,viana_do_castelo).
capital(vila_real,vila_real).
capital(braganca,braganca).

adjacente(viana_do_castelo, braga).

adjacente(braga, viana_do_castelo).
adjacente(braga, porto).
adjacente(braga, vila_real).

adjacente(vila_real, braga).
adjacente(vila_real, porto).
adjacente(vila_real, braganca).
adjacente(vila_real, viseu).

adjacente(braganca, vila_real).
adjacente(braganca, viseu).
adjacente(braganca, guarda).

adjacente(porto, braga).
adjacente(porto, vila_real).
adjacente(porto, aveiro).
adjacente(porto, viseu).

adjacente(aveiro, porto).
adjacente(aveiro, viseu).
adjacente(aveiro, coimbra).

adjacente(viseu, porto).
adjacente(viseu, vila_real).
adjacente(viseu, braganca).
adjacente(viseu, aveiro).
adjacente(viseu, guarda).
adjacente(viseu, coimbra).

adjacente(guarda, braganca).
adjacente(guarda, viseu).
adjacente(guarda, coimbra).
adjacente(guarda, castelo_branco).

adjacente(coimbra, aveiro).
adjacente(coimbra, viseu).
adjacente(coimbra, guarda).
adjacente(coimbra, castelo_branco).
adjacente(coimbra, leiria).

adjacente(castelo_branco, coimbra).
adjacente(castelo_branco, guarda).
adjacente(castelo_branco, leiria).
adjacente(castelo_branco, santarem).
adjacente(castelo_branco, portalegre).

adjacente(leiria, coimbra).
adjacente(leiria, castelo_branco).
adjacente(leiria, santarem).
adjacente(leiria, lisboa).

adjacente(santarem, lisboa).
adjacente(santarem, leiria).
adjacente(santarem, castelo_branco).
adjacente(santarem, portalegre).
adjacente(santarem, setubal).
adjacente(santarem, evora).

adjacente(lisboa, leiria).
adjacente(lisboa, santarem).

adjacente(portalegre, castelo_branco).
adjacente(portalegre, santarem).
adjacente(portalegre, evora).

adjacente(setubal, santarem).
adjacente(setubal, evora).
adjacente(setubal, beja).

adjacente(evora, beja).
adjacente(evora, setubal).
adjacente(evora, santarem).
adjacente(evora, portalegre).

adjacente(beja, faro).
adjacente(beja, evora).
adjacente(beja, setubal).

adjacente(faro, beja).