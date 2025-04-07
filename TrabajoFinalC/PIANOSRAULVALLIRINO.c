#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <windows.h>

int x;

struct empleados
{
    int empleado_id;
    char nombre[50];
    char apellido[50];
    int edad;
    char direccion[50];
    char fecha[30];
    int salario;
    int telefono;
    int calificacion;
};

struct clientes
{
    int cliente_id;
    int empleado_id;
    char direccion[50];
    char fecha[30];
    int pago;
};

struct pianos
{
    int piano_id;
    char nombre[50];
    char origen[50];
    int peso;
    int precio;
};

struct servicios
{
    int servicio_id;
    int piano_id;
    char descripcion[50];
    int precio;
    char fecha[30];
};

struct entregas
{
    int entrega_id;
    int piano_id;
    char destino[50];
    int precio;
    char fecha[30];
};
//SERVICIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOS

void modservicio(struct servicios servicio[], struct pianos piano[], int n)
{
       int mod_id;
    int id_encontrada = 0;
    int nueva_id;
    int id_existente = 0;
    int i;
    int x;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL SERVICIO A MODIFICAR: ");
    scanf("%d", &mod_id);

    if (mod_id == 0) {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
        system("pause");
    } else {
        for (x = 0; x < 3; x++) {
            if (servicio[x].servicio_id == mod_id) {
                id_encontrada = 1;

                
                do {
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DEL SERVICIO: ");
                    scanf("%d", &nueva_id);

                    if (nueva_id == 0) {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                    }
                } while (nueva_id == 0);

                
                id_existente = 0;
                for (i = 0; i < 3; i++) {
                    if (i != x && servicio[i].servicio_id == nueva_id) {
                        id_existente = 1;
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID de la entrega ya existe. Ingrese una ID diferente.\n");
                        break;
                    }
                }

                if (!id_existente) {
                    servicio[x].servicio_id = nueva_id;

                    
                    do {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DEL PIANO: ");
                        scanf("%d", &nueva_id);

                        if (nueva_id == 0) {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        } else {
                           
                            id_existente = 0;
                            for (i = 0; i < 3; i++) {
                                if (piano[i].piano_id == nueva_id) {
                                    id_existente = 1;
                                    break;
                                }
                            }

                            if (id_existente) {
                                servicio[x].piano_id = nueva_id;

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO PRECIO DEl SERVICIO: ");
                                scanf("%d", &servicio[x].precio);
                                if (servicio[x].precio <= 0) {
                                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl pago no puede ser nulo ni menor a 0\n");
                                    system("pause");
                                }

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA DESCRIPCION DEL SERVICIO: ");
                                getchar();
                                fgets(servicio[x].descripcion, sizeof(servicio[x].descripcion), stdin);
                                servicio[x].descripcion[strcspn(servicio[x].descripcion, "\n")] = '\0';

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA FECHA DEL SERVICIO: ");
                                fgets(servicio[x].fecha, sizeof(servicio[x].fecha), stdin);
                                servicio[x].fecha[strcspn(servicio[x].fecha, "\n")] = '\0';

                                break;
                            } else {
                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano no existe. Ingrese una ID diferente.\n");
                                system("pause");
                            }
                        }
                    } while (1);
                }
            }
        }

        if (!id_encontrada) {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del servicio no existe. Ingrese una ID diferente.\n");
            system("pause");
        }
    }
}

void ingservicio(struct servicios servicio[], struct pianos piano[], int n, int *serviciocont)
{
	if (*serviciocont < 3)
    {
    	int num_servicio;

        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngresando informacion de un Servicio:\n");
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngrese el numero del servicio (1, 2 o 3): ");
        scanf("%d", &num_servicio);

        if (num_servicio >= 1 && num_servicio <= 3)
        {
            num_servicio--;

            if (servicio[num_servicio].servicio_id == 0)
            {
                int id;
                int id_existente = 0;
                int x;

                do {
                    do {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL SERVICIO: ");
                        scanf("%d", &id);
                        if (id == 0)
                        {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        }
                    } while (id == 0);

                    id_existente = 0;

                    for (x = 0; x < 3; x++)
                    {
                        if (servicio[x].servicio_id == id)
                        {
                            id_existente = 1;
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del servicio ya existe. Ingrese una ID diferente.\n");
                            system("pause");
                            break;
                        }
                    }
                } while (id_existente);

                if (!id_existente)
                {
                    servicio[num_servicio].servicio_id = id;

                    do {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL PRECIO DEL SERVICIO: ");
                        scanf("%d", &servicio[num_servicio].precio);
                        if (servicio[num_servicio].precio <= 0)
                        {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl precio no puede ser nulo ni menor a 0.\n");
                            
                            system("pause");
                        }
                    } while (servicio[num_servicio].precio <= 0);

                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA DESCRIPCION DEL SERVICIO: ");
                    getchar();
                    fgets(servicio[num_servicio].descripcion, sizeof(servicio[num_servicio].descripcion), stdin);
                    servicio[num_servicio].descripcion[strcspn(servicio[num_servicio].descripcion, "\n")] = '\0';

                    int id_piano;
                    int piano_existente = 0;

                    do {
                        do {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL PIANO: ");
                            scanf("%d", &id_piano);
                            if (id_piano == 0)
                            {
                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                            }
                        } while (id_piano == 0);

                        piano_existente = 0;

                        for (x = 0; x < 3; x++)
                        {
                            if (piano[x].piano_id == id_piano)
                            {
                                piano_existente = 1;
                                break;
                            }
                        }

                        if (!piano_existente)
                        {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano no existe. Ingrese una ID diferente.\n");
                            system("pause");
                        }

                    } while (!piano_existente);

                    servicio[num_servicio].piano_id = id_piano;

                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA FECHA DE LA ENTREGA: ");
                    fgets(servicio[num_servicio].fecha, sizeof(servicio[num_servicio].fecha), stdin);
                    servicio[num_servicio].fecha[strcspn(servicio[num_servicio].fecha, "\n")] = '\0';

                    (*serviciocont)++;
                }
            }
            else
            {
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl servicio ya contiene informacion. No se puede volver a ingresar.\n");
                 system("pause");
            }
        }
        else
        {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNumero de servicio no valido. Debe ser 1, 2 o 3.\n");
             system("pause");
        }

        if (servicio[0].servicio_id != 0 && servicio[1].servicio_id != 0 && servicio[2].servicio_id != 0) {
            n = 3;
        }
    }
    else
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe han ingresado la maxima cantidad de servicios");
        system("pause");
    }
}

void elimservicio (struct servicios servicio[],struct pianos piano[], int n, int *serviciocont)
{
	int elim_id;
    int id_encontrada = 0;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL SERVICIO A ELIMINAR: ");
    scanf("%d", &elim_id);
     if(elim_id==0)
     {
     	printf("No se pueden ingresar ID nulas\n");
     	system("pause");
	 }
	 else
	 {
	 	for (x = 0; x < 3; x++)
    {
        if (servicio[x].servicio_id == elim_id)
        {
            id_encontrada = 1;
            servicio[x].servicio_id=0;
            servicio[x].piano_id=0;
        strcpy(servicio[x].descripcion, "");
        strcpy(servicio[x].fecha, "");
        servicio[x].precio=0;
            (*serviciocont)--;
            break; 
        }
    }

    if (!id_encontrada)
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del servicio no existe. Ingrese una ID diferente.\n");
        system("pause");
    }
	 }
    
}
//HASTA ACA SERVICIOSSSSSSSSSSSSSSSSSSSSSSS
//ENTREGAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS
void modentrega(struct entregas entrega[], struct pianos piano[], int n)
{
   int mod_id;
    int id_encontrada = 0;
    int nueva_id;
    int id_existente = 0;
    int i;
    int x;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DE LA ENTREGA A MODIFICAR: ");
    scanf("%d", &mod_id);

    if (mod_id == 0) {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
        system("pause");
    } else {
        for (x = 0; x < 3; x++) {
            if (entrega[x].entrega_id == mod_id) {
                id_encontrada = 1;

                
                do {
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DE LA ENTREGA: ");
                    scanf("%d", &nueva_id);

                    if (nueva_id == 0) {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                    }
                } while (nueva_id == 0);

                id_existente = 0;
                for (i = 0; i < 3; i++) {
                    if (i != x && entrega[i].entrega_id == nueva_id) {
                        id_existente = 1;
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID de la entrega ya existe. Ingrese una ID diferente.\n");
                        break;
                    }
                }

                if (!id_existente) {
                    entrega[x].entrega_id = nueva_id;

                   
                    do {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DEL PIANO: ");
                        scanf("%d", &nueva_id);

                        if (nueva_id == 0) {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        } else {
                         
                            id_existente = 0;
                            for (i = 0; i < 3; i++) {
                                if (piano[i].piano_id == nueva_id) {
                                    id_existente = 1;
                                    break;
                                }
                            }

                            if (id_existente) {
                                entrega[x].piano_id = nueva_id;
                                 
                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO PRECIO DE LA ENTREGA: ");
                                scanf("%d", &entrega[x].precio);
                                if (entrega[x].precio <= 0) {
                                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl pago no puede ser nulo ni menor a 0\n");
                                    system("pause");
                                }

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO DESTINO DE LA ENTREGA: ");
                                getchar();
                                fgets(entrega[x].destino, sizeof(entrega[x].destino), stdin);
                                entrega[x].destino[strcspn(entrega[x].destino, "\n")] = '\0';

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA FECHA DE LA ENTREGA: ");
                                fgets(entrega[x].fecha, sizeof(entrega[x].fecha), stdin);
                                entrega[x].fecha[strcspn(entrega[x].fecha, "\n")] = '\0';

                                break;
                            } else {
                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano no existe. Ingrese una ID diferente.\n");
                                system("pause");
                            }
                        }
                    } while (1);
                }
            }
        }

        if (!id_encontrada) {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID de la entrega no existe. Ingrese una ID diferente.\n");
            system("pause");
        }
    }
}

void elimentrega (struct entregas entrega[],struct pianos piano[], int n, int *entregacont)
{
	int elim_id;
    int id_encontrada = 0;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DE LA ENTREGA A ELIMINAR: ");
    scanf("%d", &elim_id);
     if(elim_id==0)
     {
     	printf("No se pueden ingresar ID nulas\n");
     	system("pause");
	 }
	 else
	 {
	 	for (x = 0; x < 3; x++)
    {
        if (entrega[x].entrega_id == elim_id)
        {
            id_encontrada = 1;
            entrega[x].entrega_id=0;
            entrega[x].piano_id=0;
        strcpy(entrega[x].destino, "");
        strcpy(entrega[x].fecha, "");
        entrega[x].precio=0;
            (*entregacont)--;
            break; 
        }
    }

    if (!id_encontrada)
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID de la entrega no existe. Ingrese una ID diferente.\n");
        system("pause");
    }
	 }
    
}
void ingentrega(struct entregas entrega[], struct pianos piano[], int n, int *entregacont) {
    if (*entregacont < 3) {
        int num_entrega;
        int x;

        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngresando informacion de una Entrega:\n");
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngrese el numero de la entrega (1, 2 o 3): ");
        scanf("%d", &num_entrega);

        if (num_entrega >= 1 && num_entrega <= 3) {
            num_entrega--;

            if (entrega[num_entrega].entrega_id == 0) {
                int id;
                int id_existente = 0;

                do {
                    do {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DE LA ENTREGA: ");
                        scanf("%d", &id);
                        if (id == 0) {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        }
                    } while (id == 0);

                    id_existente = 0;

                    for (x = 0; x < 3; x++) {
                        if (entrega[x].entrega_id == id) {
                            id_existente = 1;
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID de la entrega ya existe. Ingrese una ID diferente.\n");
                            system("pause");
                            break;
                        }
                    }

                    if (!id_existente) {
                        int piano_fk;
                        int piano_existente = 0;

                        do {
                            do {
                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL PIANO: ");
                                scanf("%d", &piano_fk);
                                if (piano_fk == 0) {
                                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                                }
                            } while (piano_fk == 0);

                            piano_existente = 0;

                            for (x = 0; x < 3; x++) {
                                if (piano[x].piano_id == piano_fk) {
                                    piano_existente = 1;
                                    break;
                                }
                            }

                            if (!piano_existente) {
                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano no existe. Ingrese una ID diferente.\n");
                                system("pause");
                            }
                        } while (!piano_existente);

                        if (piano_existente) {
                           
                            entrega[num_entrega].entrega_id = id;
                            entrega[num_entrega].piano_id = piano_fk;
                            do{
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL PRECIO DE LA ENTREGA: ");
                            scanf("%d", &entrega[num_entrega].precio);
                            if(entrega[num_entrega].precio<=0)
                            {
                            	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar valores menores o iguales que 0");
                            	system("pause");
							}
                            }while(entrega[num_entrega].precio<=0);
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL DESTINO DE LA ENTREGA: ");
                            getchar();
                            fgets(entrega[num_entrega].destino, sizeof(entrega[num_entrega].destino), stdin);
                            entrega[num_entrega].destino[strcspn(entrega[num_entrega].destino, "\n")] = '\0';

                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA FECHA DE LA ENTREGA: ");
                            fgets(entrega[num_entrega].fecha, sizeof(entrega[num_entrega].fecha), stdin);
                            entrega[num_entrega].fecha[strcspn(entrega[num_entrega].fecha, "\n")] = '\0';

                           

                            (*entregacont)++;
                        }
                    }

                } while (id_existente);

            } else {
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa entrega ya contiene informacion. No se puede volver a ingresar.\n");
                system("pause");
            }
        } else {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNumero de entrega no valido. Debe ser 1, 2 o 3.\n");
            system("pause");
        }

        if (entrega[0].entrega_id != 0 && entrega[1].entrega_id != 0 && entrega[2].entrega_id != 0) {
            n = 3;
        }

    } else {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe han ingresado la maxima cantidad de entregas");
        system("pause");
    }
}

//HASTA ACA LAS ENTREGASSSSSSSSSSSSSSSSSSSSSSSSSS
//VIENEN LOS CLIENTES
void modcliente(struct empleados empleado[], struct clientes cliente[], int n) {
    int mod_id;
    int id_encontrada = 0;
    int nueva_id;
    int id_existente = 0;
    int i;
    int x;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL CLIENTE A MODIFICAR: ");
    scanf("%d", &mod_id);

    if (mod_id == 0) {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
        system("pause");
    } else {
        for (x = 0; x < 3; x++) {
            if (cliente[x].cliente_id == mod_id) {
                id_encontrada = 1;

                // Modificar ID del Cliente
                do {
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DEL CLIENTE: ");
                    scanf("%d", &nueva_id);

                    if (nueva_id == 0) {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                    }
                } while (nueva_id == 0);

                id_existente = 0;
                for (i = 0; i < 3; i++) {
                    if (i != x && cliente[i].cliente_id == nueva_id) {
                        id_existente = 1;
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del cliente ya existe. Ingrese una ID diferente.\n");
                        break;
                    }
                }

                if (!id_existente) {
                    cliente[x].cliente_id = nueva_id;

                    do {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DEL EMPLEADO: ");
                        scanf("%d", &nueva_id);

                        if (nueva_id == 0) {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        } else {
                            
                            id_existente = 0;
                            for (i = 0; i < 3; i++) {
                                if (empleado[i].empleado_id == nueva_id) {
                                    id_existente = 1;
                                    break;
                                }
                            }

                            if (id_existente) {
                                cliente[x].empleado_id = nueva_id;

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO PAGO DEL CLIENTE: ");
                                scanf("%d", &cliente[x].pago);
                                if (cliente[x].pago <= 0) {
                                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl pago no puede ser nulo ni menor a 0\n");
                                    system("pause");
                                }

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA DIRECCION DEL CLIENTE: ");
                                getchar();
                                fgets(cliente[x].direccion, sizeof(cliente[x].direccion), stdin);
                                cliente[x].direccion[strcspn(cliente[x].direccion, "\n")] = '\0';

                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA FECHA DE COMPRA DEL CLIENTE: ");
                                fgets(cliente[x].fecha, sizeof(cliente[x].fecha), stdin);
                                cliente[x].fecha[strcspn(cliente[x].fecha, "\n")] = '\0';

                                break;
                            } else {
                                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del empleado no existe. Ingrese una ID diferente.\n");
                                system("pause");
                            }
                        }
                    } while (1);
                }
            }
        }

        if (!id_encontrada) {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del cliente no existe. Ingrese una ID diferente.\n");
            system("pause");
        }
    }
}

void ingcliente(struct empleados empleado[], struct clientes cliente[], int n, int *clientecont)
{
    if (*clientecont < 3)
    {
        int num_cliente;

        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngresando informacion de un Cliente:\n");
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngrese el numero del cliente (1, 2 o 3): ");
        scanf("%d", &num_cliente);

        if (num_cliente >= 1 && num_cliente <= 3)
        {
            num_cliente--;

            if (cliente[num_cliente].cliente_id == 0)
            {
                int id;
                int id2;
                int id_existente = 0;
                int x;

                do
                {
                    do
                    {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL CLIENTE: ");
                        scanf("%d", &id);
                        if (id == 0)
                        {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        }
                    } while (id == 0);

                    id_existente = 0;

                    for (x = 0; x < 3; x++)
                    {
                        if (cliente[x].cliente_id == id)
                        {
                            id_existente = 1;
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del cliente ya existe. Ingrese una ID diferente.\n");
                            system("pause");
                            break;
                        }
                    }
                } while (id_existente);

                do
                {
                    do
                    {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL EMPLEADO: ");
                        scanf("%d", &id2);
                        if (id2 == 0)
                        {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        }
                    } while (id2 == 0);

                    id_existente = 0;

                    for (x = 0; x < 3; x++)
                    {
                        if (empleado[x].empleado_id == id2)
                        {
                            id_existente = 1;
                            break;
                        }
                    }

                    if (!id_existente)
                    {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del empleado no existe. Ingrese una ID diferente.\n");
                        system("pause");
                    }
                } while (!id_existente);

                cliente[num_cliente].cliente_id = id;
                cliente[num_cliente].empleado_id = id2;

                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA DIRECCION DEL CLIENTE: ");
                getchar();
                fgets(cliente[num_cliente].direccion, sizeof(cliente[num_cliente].direccion), stdin);
                cliente[num_cliente].direccion[strcspn(cliente[num_cliente].direccion, "\n")] = '\0';

                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA FECHA DEL CLIENTE: ");
                fgets(cliente[num_cliente].fecha, sizeof(cliente[num_cliente].fecha), stdin);
                cliente[num_cliente].fecha[strcspn(cliente[num_cliente].fecha, "\n")] = '\0';

                do
                {
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL PAGO DEL CLIENTE: ");
                    scanf("%d", &cliente[num_cliente].pago);
                    if (cliente[num_cliente].pago <= 0)
                    {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl pago no puede ser nulo ni menor a 0\n");
                        system("pause");
                    }
                } while (cliente[num_cliente].pago <= 0);

                (*clientecont)++;
            }
            else
            {
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl cliente ya contiene información. No se puede volver a ingresar.\n");
                system("pause");
            }
        }
        else
        {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNumero de cliente no válido. Debe ser 1, 2 o 3.\n");
            system("pause");
        }

        if (cliente[0].cliente_id != 0 && cliente[1].cliente_id != 0 && cliente[2].cliente_id != 0)
        {
            n = 3;
        }
    }
    else
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe han ingresado la cantidad máxima de clientes\n");
        system("pause");
    }
}

void elimcliente(struct clientes cliente [],struct empleados empleado[], int n, int *clientecont)
{
    int elim_id;
    int id_encontrada = 0;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL CLIENTE A ELIMINAR: ");
    scanf("%d", &elim_id);
     if(elim_id==0)
     {
     	printf("No se pueden ingresar ID nulas\n");
     	system("pause");
	 }
	 else
	 {
	 	for (x = 0; x < 3; x++)
    {
        if (cliente[x].cliente_id == elim_id)
        {
            id_encontrada = 1;

             cliente[x].cliente_id=0;
             cliente[x].empleado_id=0;
              strcpy(cliente[x].direccion, "");
            cliente[x].pago=0;
            strcpy(cliente[x].fecha, "");

    

            (*clientecont)--;
            break; 
        }
    }

    if (!id_encontrada)
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano no existe. Ingrese una ID diferente.\n");
        system("pause");
    }
	 }
    
}

//HASTA ACA LOS CLIENTESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
//AHORA LO PIANOSSSSSSSSSSSSS
void elimpiano(struct pianos piano[], int n, int *pianocont)
{
    int elim_id;
    int id_encontrada = 0;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL PIANO A ELIMINAR: ");
    scanf("%d", &elim_id);
     if(elim_id==0)
     {
     	printf("No se pueden ingresar ID nulas\n");
     	system("pause");
	 }
	 else
	 {
	 	for (x = 0; x < 3; x++)
    {
        if (piano[x].piano_id == elim_id)
        {
            id_encontrada = 1;

            piano[x].piano_id = 0;
            strcpy(piano[x].nombre, "");
            piano[x].precio = 0;
            piano[x].peso = 0;
            strcpy(piano[x].origen, "");

            (*pianocont)--;
            break; 
        }
    }

    if (!id_encontrada)
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano no existe. Ingrese una ID diferente.\n");
        system("pause");
    }
	 }
    
}

void modpiano(struct pianos piano[], int n)
{
    int mod_id;
    int id_encontrada = 0;
    int nueva_id;
    int id_existente = 0;
    int i;
    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL PIANO A MODIFICAR: ");
    scanf("%d", &mod_id);
      if(mod_id==0)
     {
     	printf("No se pueden ingresar ID nulas\n");
     	system("pause");
	 }
	 else
	 {
	 	for (x = 0; x < 3; x++)
    {
        if (piano[x].piano_id == mod_id)
        {
            id_encontrada = 1;
            do
            {
            	do{
				
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DEL PIANO: ");
                scanf("%d", &nueva_id);
                if(nueva_id==0)
                {
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
     	
				}
                }while(nueva_id==0);
                id_existente = 0;

                for ( i = 0; i < 3; i++)
                {
                    if (i != x && piano[i].piano_id == nueva_id)
                    {
                        id_existente = 1;
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano ya existe. Ingrese una ID diferente.\n");
                        system("pause");
                        break;
                    }
                }
            } while (id_existente);

            piano[x].piano_id = nueva_id;
            do{
             printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO PESO DEL PIANO: ");
            scanf("%d", &piano[x].peso);	
            if(piano[x].peso<=0)
            {
            	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl peso no puede ser nulo ni menor a 0\n");
                        system("pause");
			}
			}while(piano[x].peso<=0);
            
            do{
			
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO PRECIO DEL PIANO: ");
            scanf("%d", &piano[x].precio);
            if(piano[x].precio<=0)
            {
            	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl precio no puede ser nulo ni menor a 0\n");
                        system("pause");
			}
            }while(piano[x].precio<=0);
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO NOMBRE DEL PIANO: ");
            getchar();
            fgets(piano[x].nombre, sizeof(piano[x].nombre), stdin);
            piano[x].nombre[strcspn(piano[x].nombre, "\n")] = '\0';
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO ORIGEN DEL PIANO: ");
            fgets(piano[x].origen, sizeof(piano[x].origen), stdin);
            piano[x].origen[strcspn(piano[x].origen, "\n")] = '\0';
            break;
        }
    }

    if (!id_encontrada)
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano no existe. Ingrese una ID diferente.\n");
        system("pause");
    }
	 }
    
}

void ingpiano(struct pianos piano[],int n, int *pianocont)
{
    if(*pianocont<3)
    {
    	int num_piano;
        
        
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngresando informacion de un Piano:\n");
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngrese el numero del piano (1, 2 o 3): ");
        scanf("%d", &num_piano);

        if (num_piano >= 1 && num_piano <= 3)
        {
            num_piano--; 

            if (piano[num_piano].piano_id == 0)
            {
                int id;
                int id_existente = 0;
                do{
                	do{
                		
					
                 printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL PIANO: ");
                scanf("%d", &id);
				if(id==0)
                {
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
     	
				}	
				}while(id==0);
               

                id_existente = 0;

                for (x = 0; x < 3; x++)
                {
                    if (piano[x].piano_id == id)
                    {
                        id_existente = 1;
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del piano ya existe. Ingrese una ID diferente.\n");
                        system("pause");
                        break;
                    }
                }
              }while(piano[x].piano_id == id);
                if (!id_existente)
                {
                    piano[num_piano].piano_id = id;
                    do{
					
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL PESO DEL PIANO: ");
                    scanf("%d", &piano[num_piano].peso);
                    if(piano[num_piano].peso<=0)
                    {
                    	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl peso no puede ser nulo ni menor a 0\n");
                        system("pause");
					}
                    }while(piano[num_piano].peso<=0);
                    do{
                    	
					
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL PRECIO DEL PIANO: ");
                    scanf("%d", &piano[num_piano].precio);
                    if(piano[num_piano].precio<=0){
                    	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl precio no puede ser nulo ni menor a 0\n");
                        system("pause");
					}
                    }while(piano[num_piano].precio<=0);
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NOMBRE DEL PIANO: ");
                    getchar();
                    fgets(piano[num_piano].nombre, sizeof(piano[num_piano].nombre), stdin);
                    piano[num_piano].nombre[strcspn(piano[num_piano].nombre, "\n")] = '\0';
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL ORIGEN DEL PIANO: ");
                    fgets(piano[num_piano].origen, sizeof(piano[num_piano].origen), stdin);
                    piano[num_piano].origen[strcspn(piano[num_piano].origen, "\n")] = '\0';
                    (*pianocont)++;

                }
                
            }
            else
            {
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl piano ya contiene informacion. No se puede volver a ingresar.\n");
                 system("pause");
            }
        }
        else
        {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNumero de piano no valido. Debe ser 1, 2 o 3.\n");
             system("pause");
        }

        if (piano[0].piano_id != 0 && piano[1].piano_id != 0 && piano[2].piano_id != 0) {
            n = 3;
        }	
		
	}
	else
	{
		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe han ingresado la maxima cantidad de pianos");
		system("pause");
	}
        
		
}



//HASTA ACA ES LO DE PIANOSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
//AHORA VIENEN LOS EMPLEADOS
void ingempleado(struct empleados empleado[], int n, int *empleadocont)
{
    if (*empleadocont < 3)
    {
        int num_empleado;

        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngresando informacion de un Empleado:\n");
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIngrese el numero del empleado (1, 2 o 3): ");
        scanf("%d", &num_empleado);

        if (num_empleado >= 1 && num_empleado <= 3)
        {
            num_empleado--;

            if (empleado[num_empleado].empleado_id == 0)
            {
                int id;
                int id_existente = 0;
                do {
                	do{
                		
					
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL EMPLEADO: ");
                    scanf("%d", &id);
                    if (id == 0)
                    {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                    }
                } while (id == 0);

                id_existente = 0;

                for ( x = 0; x < 3; x++)
                {
                    if (empleado[x].empleado_id == id)
                    {
                        id_existente = 1;
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del empleado ya existe. Ingrese una ID diferente.\n");
                        system("pause");
                        break;
                    }
                }
                }while(empleado[x].empleado_id == id);

                if (!id_existente)
                {
                    empleado[num_empleado].empleado_id = id;

                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NOMBRE DEL EMPLEADO: ");
                    getchar();
                    fgets(empleado[num_empleado].nombre, sizeof(empleado[num_empleado].nombre), stdin);
                    empleado[num_empleado].nombre[strcspn(empleado[num_empleado].nombre, "\n")] = '\0';

                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL APELLIDO DEL EMPLEADO: ");
                    fgets(empleado[num_empleado].apellido, sizeof(empleado[num_empleado].apellido), stdin);
                    empleado[num_empleado].apellido[strcspn(empleado[num_empleado].apellido, "\n")] = '\0';
                    do
                    {
                    	 printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA EDAD DEL EMPLEADO: ");
                    scanf("%d", &empleado[num_empleado].edad);

                    	if(empleado[num_empleado].edad<=0)
                    	{
                    		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa edad no puede ser nula ni menor a 0.\n");
                    		system("pause");
						}
						if( empleado[num_empleado].edad<18 || empleado[num_empleado].edad>100)
						{
							printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa edad no puede ser menor a 18 ni mayor a 100.\n");
                    		system("pause");
						}
					}while(empleado[num_empleado].edad<=0 || empleado[num_empleado].edad<18 || empleado[num_empleado].edad>100);
                   
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA DIRECCION DEL EMPLEADO: ");
                    getchar();
                    fgets(empleado[num_empleado].direccion, sizeof(empleado[num_empleado].direccion), stdin);
                    empleado[num_empleado].direccion[strcspn(empleado[num_empleado].direccion, "\n")] = '\0';

                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA FECHA DE INICIO DEL EMPLEADO: ");
                    fgets(empleado[num_empleado].fecha, sizeof(empleado[num_empleado].fecha), stdin);
                    empleado[num_empleado].fecha[strcspn(empleado[num_empleado].fecha, "\n")] = '\0';
                    
                    do{
                    	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL SALARIO DEL EMPLEADO: ");
                    scanf("%d", &empleado[num_empleado].salario);

                    	if(empleado[num_empleado].salario<=0)
                    	{
                    		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl salario no puede ser nulo ni menor a 0\n");
                        system("pause");
						}
					}while(empleado[num_empleado].salario<=0);
                    do
                    {
                    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL TELEFONO DEL EMPLEADO: ");
                    scanf("%d", &empleado[num_empleado].telefono);
	                 if(empleado[num_empleado].telefono<=0)
	                 {
	                 	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl telefono no puede ser nulo ni menor a 0.\n");
	                 	system("pause");
					 }
					}while(empleado[num_empleado].telefono<=0);
                    do{
                    	 printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA CALIFICACION DEL EMPLEADO: ");
                    scanf("%d", &empleado[num_empleado].calificacion);
                    if(empleado[num_empleado].calificacion<0 || empleado[num_empleado].calificacion>10)
                    {
                    	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa calificacion debe estar entre el 0 y el 10.");
                    	system("pause");
					}
					}while(empleado[num_empleado].calificacion<0 || empleado[num_empleado].calificacion>10);
                   

                    (*empleadocont)++;
                }
            }
            else
            {
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl empleado ya contiene informacion. No se puede volver a ingresar.\n");
                system("pause");
            }
        }
        else
        {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNumero de empleado no valido. Debe ser 1, 2 o 3.\n");
            system("pause");
        }

        if (empleado[0].empleado_id != 0 && empleado[1].empleado_id != 0 && empleado[2].empleado_id != 0)
        {
            n = 3;
        }
    }
    else
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe han ingresado la maxima cantidad de empleados");
        system("pause");
    }
}

void modempleado(struct empleados empleado[], int n)
{
    int mod_id;
    int id_encontrada = 0;
    int nueva_id;
    int id_existente = 0;
    int i;
    
    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL EMPLEADO A MODIFICAR: ");
    scanf("%d", &mod_id);
    
    if (mod_id == 0)
    {
        printf("No se pueden ingresar ID nulas\n");
        system("pause");
    }
    else
    {
        for (x = 0; x < 3; x++)
        {
            if (empleado[x].empleado_id == mod_id)
            {
                id_encontrada = 1;
                do
                {
                    do
                    {
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA ID DEL EMPLEADO: ");
                        scanf("%d", &nueva_id);
                        if (nueva_id == 0)
                        {
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo se pueden ingresar ID nulas\n");
                        }
                    } while (nueva_id == 0);
                    id_existente = 0;

                    for (i = 0; i < 3; i++)
                    {
                        if (i != x && empleado[i].empleado_id == nueva_id)
                        {
                            id_existente = 1;
                            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del empleado ya existe. Ingrese una ID diferente.\n");
                            system("pause");
                            break;
                        }
                    }
                } while (id_existente);

                empleado[x].empleado_id = nueva_id;
                
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO NOMBRE DEL EMPLEADO: ");
                getchar();
                fgets(empleado[x].nombre, sizeof(empleado[x].nombre), stdin);
                empleado[x].nombre[strcspn(empleado[x].nombre, "\n")] = '\0';

                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO APELLIDO DEL EMPLEADO: ");
                fgets(empleado[x].apellido, sizeof(empleado[x].apellido), stdin);
                empleado[x].apellido[strcspn(empleado[x].apellido, "\n")] = '\0';
                do{
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA EDAD DEL EMPLEADO: ");
                scanf("%d", &empleado[x].edad);
                if(empleado[x].edad<=0)
                {
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa edad no puede ser nula ni negativa.\n");
                	system("pause");
				}
				if( empleado[x].edad<18 || empleado[x].edad>100)
						{
							printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa edad no puede ser menor a 18 ni mayor a 100.\n");
                    		system("pause");
						}
				}while(empleado[x].edad<=0 || empleado[x].edad<18 || empleado[x].edad>100);
                

                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA DIRECCION DEL EMPLEADO: ");
                getchar();
                fgets(empleado[x].direccion, sizeof(empleado[x].direccion), stdin);
                empleado[x].direccion[strcspn(empleado[x].direccion, "\n")] = '\0';

                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA FECHA DE INICIO DEL EMPLEADO: ");
                fgets(empleado[x].fecha, sizeof(empleado[x].fecha), stdin);
                empleado[x].fecha[strcspn(empleado[x].fecha, "\n")] = '\0';
                
                do{
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO SALARIO DEL EMPLEADO: ");
                scanf("%d", &empleado[x].salario);
                if(empleado[x].salario<=0)
                {
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl salario no puede ser nulo ni menor a 0\n");
                        system("pause");
				}
                }while(empleado[x].salario<=0);
                do
                {	
                printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE EL NUEVO TELEFONO DEL EMPLEADO: ");
                scanf("%d", &empleado[x].telefono);
                if(empleado[x].telefono<=0)
                {
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEl telefono no puede ser nulo ni menor a 0.\n");
				    system("pause");
				}
                }while(empleado[x].telefono<=0);
                do
                {
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA NUEVA CALIFICACION DEL EMPLEADO: ");
                scanf("%d", &empleado[x].calificacion);
                if(empleado[x].calificacion<0 || empleado[x].calificacion>10)
                {
                	printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa calificacion debe ser del 0 al 10.\n");
                	system("pause");
				}
				}while(empleado[x].calificacion<0 || empleado[x].calificacion>10);
                
            }
        }

        if (!id_encontrada)
        {
            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del empleado no existe. Ingrese una ID diferente.\n");
            system("pause");
        }
    }
}

void elimempleado (struct empleados empleado[], int n, int *empleadocont)
{
	int elim_id;
    int id_encontrada = 0;

    printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tINGRESE LA ID DEL EMPLEADO A ELIMINAR: ");
    scanf("%d", &elim_id);
     if(elim_id==0)
     {
     	printf("No se pueden ingresar ID nulas\n");
     	system("pause");
	 }
	 else
	 {
	 	for (x = 0; x < 3; x++)
    {
        if (empleado[x].empleado_id == elim_id)
        {
            id_encontrada = 1;
            empleado[x].empleado_id=0;
        strcpy(empleado[x].nombre, "");
        strcpy(empleado[x].apellido, "");
        empleado[x].edad=0;
        strcpy(empleado[x].direccion, "");
        strcpy(empleado[x].fecha, "");
        empleado[x].salario=0;
        empleado[x].telefono=0;
        empleado[x].calificacion=0;
            
            (*empleadocont)--;
            break; 
        }
    }

    if (!id_encontrada)
    {
        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tLa ID del empleado no existe. Ingrese una ID diferente.\n");
        system("pause");
    }
	 }
    
}
//HASTA ACA LOS EMPLEADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOSSSSSSSSSSSSSSSSSSSSSSSSSSSS
//MAX CALIFICACION
void imprimirEmpleadoDelMes(struct empleados empleado[]) {
    int max = 0;
    int x;
    for ( x = 1; x < 3; x++) {
        if (empleado[x].calificacion > empleado[max].calificacion) {
            max = x;
        }
    }
    
    printf("\n\nEL EMPLEADO DEL MES:\n");
    printf("ID: %d\n", empleado[max].empleado_id);
    printf("Nombre: %s\n", empleado[max].nombre);
    printf("Apellido: %s\n", empleado[max].apellido);
    printf("Edad: %d\n", empleado[max].edad);
    printf("Direccion: %s\n", empleado[max].direccion);
    printf("Fecha de inicio: %s\n", empleado[max].fecha);
    printf("Salario: %d\n", empleado[max].salario);
    printf("Telefono: %d\n", empleado[max].telefono);
    printf("Calificacion: %d\n", empleado[max].calificacion);
    printf("\n");
}
//FIN MAX
//MAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIIIIIIINNNNNNNNNNNNNNNNNNN
int main()
{
	HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);

    SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE | FOREGROUND_INTENSITY | BACKGROUND_BLUE);

    
    system("cls");


    
    int opcion,n,c=0;
    struct entregas entrega[3];
    struct pianos piano[3];
    struct empleados empleado[3];
    struct clientes cliente [3];
    struct servicios servicio [3];
    int pianocont=0;
	int empleadocont=0;
	int clientecont=0;
	int entregacont=0;
	int serviciocont=0;
	int aux;
	int y;
    for (x = 0; x < 3; x++)
    {
        entrega[x].entrega_id = 0;
        strcpy(entrega[x].destino, "");
        entrega[x].precio = 0;
        strcpy(entrega[x].fecha, "");
    }
    
    for (x = 0; x < 3; x++)
    {
        piano[x].piano_id = 0;
        strcpy(piano[x].nombre, "");
        piano[x].precio = 0;
        piano[x].peso = 0;
        strcpy(piano[x].origen, "");
    }
    for (x = 0; x < 3; x++)
    {
        
        empleado[x].empleado_id=0;
        strcpy(empleado[x].nombre, "");
        strcpy(empleado[x].apellido, "");
        empleado[x].edad=0;
        strcpy(empleado[x].direccion, "");
        strcpy(empleado[x].fecha, "");
        empleado[x].salario=0;
        empleado[x].telefono=0;
        empleado[x].calificacion=0;
    }
    for (x = 0; x < 3; x++)
    {
        cliente[x].cliente_id = 0;
        cliente[x].empleado_id = 0;
        strcpy(cliente[x].direccion, "");
        strcpy(cliente[x].fecha, "");
        cliente[x].pago = 0;
    }
    for (x = 0; x < 3; x++)
    {
        servicio[x].servicio_id = 0;
        servicio[x].piano_id = 0;
        strcpy(servicio[x].descripcion, "");
        strcpy(servicio[x].fecha, "");
        servicio[x].precio = 0;
    }

    do
    {
        do
        {
            system("cls");
            printf("             \t\t\t\t-----PIANOSRAULVALLIRINO-----\n");

            printf("\n        \t1-PIANOS\t2-EMPLEADOS\t3-CLIENTES\t4-ENTREGAS\t5-SERVICIOS\t6-FIN\n");
            imprimirEmpleadoDelMes(empleado);

            printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
             
            scanf("%d", &opcion);
            system("cls");
           
        } while (opcion < 1 || opcion > 6);

        switch (opcion)
        {
            int opcion1;
            case 1:
                do
                {
                    do
                    {
                        system("cls");
                        printf("             \t\t\t\t\t-----PIANOS-----\n");
                        printf("\n      \t1-INGRESO DE PIANO\t2-MODIFICAR INFORMACION DEL PIANO\t3-ELIMINACION DEL PIANO\t      4-ATRAS");
                        printf("\nInformacion de los Pianos:\n");

                        for (x = 0; x < 3; x++)
                        {
                            printf("Piano %d:\n", x + 1);
                            printf("ID: %d\n", piano[x].piano_id);
                            printf("Nombre: %s\n", piano[x].nombre);
                            printf("Precio: %d\n", piano[x].precio);
                            printf("Peso: %d\n", piano[x].peso);
                            printf("Origen: %s\n", piano[x].origen);
                            printf("\n");
                        }

                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
                        scanf("%d", &opcion1);
                    } while (opcion1 < 1 || opcion1 > 4);

                    switch (opcion1)
                    {
                        case 1:
                            ingpiano(piano,n,&pianocont);
                            break;
                            
                            case 2:
                        	if(pianocont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay pianos a modificar\n");
                        		system("pause");
							}
							else{
								modpiano(piano, n);
							}
							break;
							case 3:
								if(pianocont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay pianos a eliminar\n");
                        		system("pause");
							}
							else
							{
								elimpiano(piano,n,&pianocont);
							}
							break;
                    }
                        
                } while (opcion1 != 4);
                break;
                case 2:
                	 do
                {
                    do
                    {
                        system("cls");
                        printf("             \t\t\t\t\t-----EMPLEADOS-----\n");
                        printf("\n      \t1-INGRESO DE EMPLEADO\t2-MODIFICAR INFORMACION DEL EMPLEADO\t3-ELIMINACION DEL EMPLEADO\t4-ATRAS");
                        printf("\nInformacion de los Empledos:\n");

                        for (x = 0; x < 3; x++)
                        {
                            printf("EMPLEADO %d:\n", x + 1);
                            printf("ID: %d\n", empleado[x].empleado_id);
                            printf("Nombre: %s\n", empleado[x].nombre);
                            printf("Apellido: %s\n", empleado[x].apellido);
                            printf("Edad: %d\n", empleado[x].edad);
                            printf("Direccion: %s\n", empleado[x].direccion);
                            printf("Fecha de inicio: %s\n", empleado[x].fecha);
                            printf("Salario: %d\n", empleado[x].salario);
                            printf("Telefono: %d\n", empleado[x].telefono);
                            printf("Calificacion: %d\n", empleado[x].calificacion);
                            printf("\n");
                        }
                          
                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
                        scanf("%d", &opcion1);
                    } while (opcion1 < 1 || opcion1 > 4);

                    switch (opcion1)
                    {
                        case 1:
                            ingempleado(empleado,n,&empleadocont);
                            break;
                            
                            case 2:
                        	if(empleadocont==0)
                        	{
                        		
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay empleados a modificar\n");
                        		system("pause");
							}
							else{
								modempleado(empleado, n);
							}
							break;
							case 3:
								if(empleadocont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay empleados a eliminar\n");
                        		system("pause");
							}
							else
							{
								elimempleado(empleado,n,&empleadocont);
							}
							break;
                    }
                        
                } while (opcion1 != 4);
                break;
                
                
				case 3:
					if(empleadocont==0)
					{
						printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe requiere ingresar empleados anteriormente\n");
						system("pause");
						break;
					}
					else
                {
                do
                {
                    do
                    {
                        system("cls");
                        printf("             \t\t\t\t\t-----CLIENTES-----\n");
                        printf("\n      \t1-INGRESO DE CLIENTE\t2-MODIFICAR INFORMACION DEL CLIENTE\t3-ELIMINACION DEL CLIENTE\t      4-ATRAS");
                        printf("\nInformacion de los Clientes:\n");

                        for (x = 0; x < 3; x++)
                        {
                            printf("Cliente %d:\n", x + 1);
                            printf("ID: %d\n", cliente[x].cliente_id);
                            printf("Empleado ID: %d\n",cliente[x].empleado_id);
                            printf("Pago: %d\n", cliente[x].pago);
                            printf("Fecha de compra: %s\n", cliente[x].fecha);
                            printf("Direccion: %s\n", cliente[x].direccion);
                            printf("\n");
                        }

                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
                        scanf("%d", &opcion1);
                    } while (opcion1 < 1 || opcion1 > 4);

                    switch (opcion1)
                    {
                        case 1:
                            ingcliente(empleado, cliente,n,&clientecont);
                            break;
                            
                            case 2:
                        	if(clientecont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay clientes a modificar\n");
                        		system("pause");
							}
							else{
								modcliente(empleado, cliente, n);
							}
							break;
							case 3:
								if(clientecont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay clientes a eliminar\n");
                        		system("pause");
							}
							else
							{
								elimcliente(cliente, empleado,n,&clientecont);
							}
							break;
                    }
                        
                } while (opcion1 != 4);
                break;
                }
                
                
                case 4:
                	if(pianocont==0)
					{
						printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe requiere ingresar pianos anteriormente\n");
						system("pause");
						break;
					}
                do
                {
                    do
                    {
                        system("cls");
                        printf("             \t\t\t\t\t-----ENTREGAS-----\n");
                        printf("\n      \t1-INGRESO DE LA ENTREGA\t2-MODIFICAR INFORMACION DE LA ENTREGA\t3-ELIMINACION DE LA ENTREGA\t      4-ATRAS");
                        printf("\n\nInformacion de las Entregas:\n");

                        for (x = 0; x < 3; x++)
                        {
                            printf("Entrega %d:\n", x + 1);
                            printf("ID: %d\n", entrega[x].entrega_id);
                            printf("Piano ID: %d\n",entrega[x].piano_id );
                            printf("Fecha: %s\n", entrega[x].fecha);
                            printf("Precio: %d\n", entrega[x].precio);
                            printf("Destino: %s\n", entrega[x].destino);
                            printf("\n");
                        }

                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
                        scanf("%d", &opcion1);
                    } while (opcion1 < 1 || opcion1 > 4);

                    switch (opcion1)
                    {
                        case 1:
                            ingentrega(entrega,piano,n,&entregacont);
                            break;
                            
                            case 2:
                        	if(entregacont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay entregas a modificar\n");
                        		system("pause");
							}
							else{
								modentrega(entrega,piano, n);
							}
							break;
							case 3:
								if(entregacont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay entregas a eliminar\n");
                        		system("pause");
							}
							else
							{
								elimentrega(entrega,piano,n,&entregacont);
							}
							break;
                    }
                        
                } while (opcion1 != 4);
                break;
                case 5:
                	if(pianocont==0)
					{
						printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tSe requiere ingresar pianos anteriormente\n");
						system("pause");
						break;
					}
                do
                {
                    do
                    {
                        system("cls");
                        printf("             \t\t\t\t\t-----SERVICIOS-----\n");
                        printf("\n      \t1-INGRESO DEL SERVICIO\t2-MODIFICAR INFORMACION DEL SERVICIO\t3-ELIMINACION DEL SERVICIO\t      4-ATRAS");
                        printf("\n\nInformacion de las Entregas:\n");

                        for (x = 0; x < 3; x++)
                        {
                            printf("Servicio %d:\n", x + 1);
                            printf("ID: %d\n", servicio[x].servicio_id);
                            printf("Piano ID: %d\n",servicio[x].piano_id);
                            printf("Fecha: %s\n", servicio[x].fecha);
                            printf("Precio: %d\n", servicio[x].precio);
                            printf("Destino: %s\n", servicio[x].descripcion);
                            printf("\n");   
							 
                        }

                        printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    ");
                        scanf("%d", &opcion1);
                    } while (opcion1 < 1 || opcion1 > 4);

                    switch (opcion1)
                    {
                        case 1:
                            ingservicio(servicio,piano,n,&serviciocont);
                            break;
                            case 2:
                        	if(serviciocont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay servicios a modificar\n");
                        		system("pause");
							}
							else{
								modservicio(servicio,piano, n);
							}
							break;
							case 3:
								if(serviciocont==0)
                        	{
                        		printf("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNo hay servicios a eliminar\n");
                        		system("pause");
							}
							else
							{
								elimservicio(servicio,piano,n,&serviciocont);
							}
							break;
                    }
                        
                } while (opcion1 != 4);
                break;
                break;
        }
    } while (opcion != 6);
    
    return 0;
}

