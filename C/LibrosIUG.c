/*
 *LibrosIUG.c
 *
 * Created on 01/04/2014
 *    Project #2 in C
 *    Authors: Luis Arturo Mendoza & Mario Jacob García
 *    All Rights Reserved 2014.
*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct nodoLibro
{
       char titulo[15];
       char autor[15];
       char editorial[10];     
       int  cantidad;
       float  precio;
       
       struct nodoLibro *next;
};


struct nodoLibro *primero, *actual, *ultimo, *anterior;
struct nodoLibro buscar;

void nice()
{
  system("PAUSE");
  system("cls");
}

void pedirDatos(struct nodoLibro *nodo)
{
  system("cls");
  printf("Titulo: ");

  gets(nodo->titulo);
  gets(nodo->titulo);
  system("cls");

  printf("Autor: " );
  gets (nodo->autor);
  system("cls");

  printf("Editorial: ");
  gets(nodo->editorial);
  system("cls");

  printf("Cantidad: ");
  scanf("%d",&nodo->cantidad);

  printf("Precio: ");
  scanf("%f",&nodo->precio);
  nice();
}

void capturarNodo()
{
  if (primero == NULL)
  {
     // 1. Crear nuevo nodo

    primero = malloc(sizeof(struct nodoLibro));
     // 2. Pedir los datos del nodo
    pedirDatos(primero);
     // 3. Hacer el enlace del nodo creado
     ultimo = primero;
     ultimo->next = NULL;
     printf("Primer Nodo Creado\nDatos %s     %s     %s    %d    %.2f\n",primero->titulo, primero->autor, primero->editorial, primero->cantidad, primero->precio);
     nice();
  }
  else
  {
    //1. Crear otro nodo

    actual = malloc(sizeof(struct nodoLibro));
    //2. Pedir Datos del nodo 

    pedirDatos(actual);
    //3. Realizar enlace del nuevo nodo
    ultimo->next = actual;
    ultimo = actual;
    ultimo->next = NULL;

    printf("Nodo Creado\nDatos %s     %s     %s    %d   %.2f\n",actual->titulo, actual->autor, actual->editorial, actual->cantidad, actual->precio);
    nice();
  }
}

void consultarNodo()
{

  if (primero == NULL)
  {
    printf("La lista no tiene nodos\n");

  }
  else
  {
    system("cls");
    actual = primero;

    while(actual != NULL)
    {
      printf("Datos %s     %s     %s    %d  %.2f\n",actual->titulo, actual->autor, actual->editorial, actual->cantidad, actual->precio);

      actual = actual->next;
    }
  }
  nice();  
}

int consultar(char parametro[15])
{
  system("cls");
  //encontrado 1 = TRUE
  //encontrado 0 = FALSE
  int encontrado = 0;
  int result=1;
  char buscar[15];
  
  if (primero == NULL)
  {
    printf("La lista esta vacia...\n");
  }
  else
  {
    //Pedimos el valor
    fflush(stdin);
    printf("Inserta %s\n",parametro);
    gets(buscar);
    fflush(stdin);
    //Ejecutamos la busqueda
    actual = primero;
    if (parametro == "titulo")
    {
      while(actual != NULL && encontrado == 0)
      {
        fflush(stdin);
        result = strncmp(actual->titulo,buscar, 15);
        if (result == 0)
        {
          printf("Encontrado: %s     %s     %s    %d   %.2f\n",actual->titulo, actual->autor, actual->editorial, actual->cantidad, actual->precio);
          encontrado = 1;
        }
        else
        {
          actual = actual->next;
        }       
      }//END WHILE
    }
    else
    {
      while(actual != NULL)
      {
        fflush(stdin);
        result = strncmp(actual->editorial,buscar, 15);
        if (result == 0)
        {
          printf("Encontrado: %s     %s     %s    %d  %.2f\n",actual->titulo, actual->autor, actual->editorial, actual->cantidad, actual->precio);
          encontrado = 1;
        }
        
          actual = actual->next;       
      }//END WHILE
    }
    if (encontrado == 0)
    {
      printf("No se encontro el %s %s\n",parametro, buscar);
    }
    
  }
  nice();
  return encontrado;
}

void modificar()
{
   system("cls");
  //encontrado 1 = TRUE
  //encontrado 0 = FALSE
  int encontrado = 0;
  int result=1;
  char buscar[15];
  
  if (primero == NULL)
  {
    printf("La lista esta vacia...\n");
  }
  else
  {
    //Pedimos el valor
    fflush(stdin);
    printf("Inserta Titulo\n");
    gets(buscar);
    fflush(stdin);
    //Ejecutamos la busqueda
    actual = primero;

    while(actual != NULL && encontrado == 0)
      {
        fflush(stdin);
        result = strncmp(actual->titulo,buscar, 15);
        if (result == 0)
        {
          printf("Vas a modificar: %s     %s     %s    %d  %.2f\n",actual->titulo, actual->autor, actual->editorial, actual->cantidad, actual->precio);
          encontrado = 1;
          //Pedimos datos 
          pedirDatos(actual);

          printf("Modificado a: %s     %s     %s    %d   %.2f\n",actual->titulo, actual->autor, actual->editorial, actual->cantidad, actual->precio);
        }
        else
        {
          actual = actual->next;
        }       
      }//END WHILE
  }
}

void eliminarNodo()
{
  int encontrado = 0;
  int result=1;
  char buscar[15];

  if (primero == NULL)
  {
    printf("La lista esta vacia...\n");
  }
  else
  {
    //Pedimos el valor
    fflush(stdin);
    printf("Inserta Titulo\n");
    gets(buscar);
    fflush(stdin);
    //Ejecutamos la busqueda
    actual = primero;
    while(actual != NULL && encontrado == 0)
    {
      fflush(stdin);
      result = strncmp(actual->titulo,buscar, 15);
      if (result == 0)
      {
        printf("Eliminado: %s     %s     %s    %d   %.2f\n",actual->titulo, actual->autor, actual->editorial, actual->cantidad, actual->precio);
        if(actual == primero)
        {

          primero = actual->next;
        }
        else
        {
          if (actual == ultimo)
          {
            ultimo = anterior;
            ultimo->next = NULL;
          }
          else
          {
            anterior->next = actual->next;
          }
        }

        encontrado = 1;
      }
      else
      {
        anterior = actual;
        actual = actual->next;
      }       
    }//END WHILE
  }
}

void opciones()
{
     
     int opcion =5;
     do
     {
     printf("LISTAS ENLAZADAS EN C\n1) Crear nodo Libro\n2) Consultar Libros\n3) Consultar por titulo\n4) Consultar por Editorial\n5) Modificar datos\n6) Eliminar Libro\n7) Salir\nOpcion = ");
     scanf("%d",&opcion);

     if (opcion == 1)
     
       capturarNodo();
     

     if (opcion == 2)
     
       consultarNodo();
     if(opcion == 3)

      consultar("titulo");
    if(opcion == 4)
      consultar("editorial");
    if(opcion == 5)
      modificar();
    if(opcion == 6)
      eliminarNodo();
          
     }while(opcion !=7);
     nice();
}

int main()
{
    opciones();
}
