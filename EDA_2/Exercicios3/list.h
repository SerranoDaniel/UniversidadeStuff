#include <stdbool.h>

struct list;
struct list *list_new();
bool list_empty(struct list *list);
bool list_insert(struct list *list, int value);
bool list_remove(struct list *list, int value);
void list_print(struct list *list);
int list_find(struct list *list, int value);
void list_destroy(struct list *list);
int list_length(struct list *list);
int list_nth(struct list *list, int n);


