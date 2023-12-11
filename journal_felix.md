# journal de felix

## 11 dec 2023

je viens de realiser que nos journaux sont manquants...
c'est pas si mal parce que on vas vraiment donner un boost que durant cette derniere semaine.

je cherche un peu plus d'info sur comment faire un mod minecraft et je me suis dit que j'allais me baser sur ce mod ci: https://github.com/MehVahdJukaar/Supplementaries

en essayant de comprendre la structure de fichiers du projet je suis tombé sur cet article un peu useless a mon avis... https://madelinemiller.dev/blog/forge-vs-fabric/ mais a ma surprise, l'auteur est une senior software engineer à microsoft et a fait le mod WorldEdit, de toutes les choses.

--- 
petit break
---

on a outliné notre plan d'action pour un MVP pendant notre break

il se comprend de 4 morceaux majeurs:
- les zones magiques
  - apparaissent de maniere aleatoire dans le monde
  - optionnel: effet de particules
  - optionnel: grass changes color
- le Magic O'Meter
  - sur right click, dit dans le chat si le joueur est dans une zone magique
- le magicrafter
  - table de craft multiblock
  - peut etre assemblee partout
  - marche que dans les zones magiques
- la bombe magique
  - crafted in magicrafter
  - grosse explosion (BCP plus grande que TNT)
  - optionnel: laisse une zone magique deriere elle dans la blast zone.