#include <stdio.h>
#include <stdlib.h>
void Ascendente(){
  int array[100], n, c, d, swap;

  printf("Cuantos elementos desea ordenar?\n");
  scanf("%d", &n);

  printf("Ingresa los %d elementos\n", n);
  for (c = 0; c < n; c++){
    array[c]=rand()%10;
    printf("%d\n",array[c]);
  }

  for (c = 0 ; c < ( n - 1 ); c++){
    for (d = 0 ; d < n - c - 1; d++){
      if (array[d] > array[d+1]){ /* For decreasing order use < */
        swap= array[d];
        array[d]= array[d+1];
        array[d+1]= swap;
      }
    }
  }
  printf("En orden Ascendente:\n");
  for ( c = 0 ; c < n ; c++ )
     printf("%d\n", array[c]);

  return 0;
}
