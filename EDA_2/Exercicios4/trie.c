/* trie implementation, with arrays */

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#include "trie.h"

#define ALPHABET_MIN 'a'
#define ALPHABET_MAX 'z'
#define ALPHABET_SIZE (ALPHABET_MAX - ALPHABET_MIN + 1)

#define POS(c)  ((c) - ALPHABET_MIN)	// character position in alphabet
#define CHAR(n) ((n) + ALPHABET_MIN)	// n-th alphabet character


/* trie node */
struct node {
  struct node *child[ALPHABET_SIZE];
  bool        word;
};

/* trie */
struct trie {
  struct node *root;
};


/*
  Allocates and returns a new trie node.

  Assumes it is always possible to allocate memory for a new node.
*/
static struct node *node_new()
{
  struct node *node = malloc(sizeof(*node));

  node->word = false;
  for (int i = 0; i < ALPHABET_SIZE; ++i)
    node->child[i] = NULL;

  return node;
}


/* Frees a trie NODE. */
static void node_free(struct node *node)
{
  free(node);
}


/* Destroys the sub-trie with root NODE. */
static void node_destroy(struct node *node)
{
  if (node == NULL)
    return;

  for (int i = 0; i < ALPHABET_SIZE; ++i)
    node_destroy(node->child[i]);

  node_free(node);
}


/* Creates a new, empty trie. */
struct trie *trie_new()
{
  struct trie *trie = malloc(sizeof(struct trie));

  if (trie)
    trie->root = NULL;

  return trie;
}


/* Destroys trie T, freeing the memory it occupies. */
void trie_destroy(struct trie *t)
{
  node_destroy(t->root);

  free(t);
}


/* Checks whether trie T is empty. */
bool trie_empty(struct trie *t)
{
  return t->root == NULL;
}


/* Inserts word P into trie T. */
void trie_insert(struct trie *t, char p[])
{
  struct node *n;
  int i = 0;

  if (t->root == NULL)
    t->root = node_new();

  n = t->root;

  // follow the word down the trie as long as possible,
  // taking care not to go to a nonexisting node
  while (p[i] != '\0' && n->child[POS(p[i])] != NULL)
    {
      n = n->child[POS(p[i])];
      i++;
    }

  // insert the new suffix into the trie
  while (p[i] != '\0')
    {
      n->child[POS(p[i])] = node_new();
      n = n->child[POS(p[i])];

      i++;
    }

  n->word = true;
}


/*
   Searches for word P in trie T.

   Returns true if it finds it, false otherwise.
*/

bool trie_find(struct trie *t, char p[])
{
	struct node *actual = t->root;

	while (p[i] != '\0' && n->child[POS(p[i])] != NULL)
	{
		
	}


 /* 2. Sugestao: compare o codigo dos slides para a pesquisa e para a
     insercao*/
}



/* Counts and returns the number of words in trie T. */
/*
int trie_count(struct trie *t)
{
  3.
}
*/


/* Prints all words in trie T with prefix P. */
/*
void trie_print_completions(struct trie *t, char p[])
{
  4.
}
*/


/* Removes word P from trie T. */
/*
void trie_delete(struct trie *t, char p[])
{
  5. Comece por fazer uma versao que so' apaga a marca de fim de
     palavra. Posteriormente, melhore-a para que apague os nos ja'
     nao usados.
}
*/


/* Prints the full contents of trie T. */
/*
void trie_print(struct trie *t)
{
  6.
}
*/
