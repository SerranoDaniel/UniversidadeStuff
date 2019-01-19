


/* Cabeçalho de uma lista */

struct header {
  int head;              // cabeça da lista
  int used,              // número de nós já usados
      free;              // cabeça da lista dos nós livres
};

/* Lista */

struct list {
  int fd;                // descritor do ficheiro onde a lista reside
  struct header header;  // cabeçalho da lista
};

/* Nó */

struct node {
  int element;           // elemento
  int next;              // próximo nó da lista
};