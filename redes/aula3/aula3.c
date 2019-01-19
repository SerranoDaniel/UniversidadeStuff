#include <unistd.h>
#include <stdio.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <netinet/in.h>
#include <string.h>
#include <time.h>

#define PORT 1300

void strdate(char *buffer, int len)

{
    time_t now = time(NULL);
    struct tm *ptn = localtime(&now);

    if(ptn == NULL)
    {
        puts("The localtime() function failed");
        return;
    }

    strftime(buffer, len, "%c\n", ptn);
}

int main(int argc, char const *argv[])
{
    int server_fd, new_socket;
    struct sockaddr_in adress;

    int opt = 1;    //for setsockpt() SO_REUSEADOR, below
    int addrlen = sizeof(adress);

    char buffer[256];

    strdate(buffer, 256);

    //Creating socket file descriptor
    if((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0)
    {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }

    //Focefully attaching socket to the port 1300
    if(setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR | SO_REUSEPORT, &opt, sizeof(opt)))
    {
        perror("setsockopt failed");
        exit(EXIT_FAILURE);
    }

    adress.sin_family = AF_INET;
    adress.sin_addr.s_addr = INADDR_ANY;
    adress.sin_port = htons( PORT );

    //Bind the socket to the network adress and port
    if( bind(server_fd, (struct sockaddr *)&adress, sizeof(adress)) < 0 )
    {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }

    if(listen(server_fd, 3) < 0)
    {
        perror("listen failed");
        exit(EXIT_FAILURE);
    }

    //wait for a connection
    if((new_socket = accept(server_fd, (struct sockaddr *)&adress, (socklen_t*)&addrlen))<0)
    {
        perror("accept failed");
        exit(EXIT_FAILURE);
    }

    printf("Client connected.\n");
    send(new_socket, buffer, strlen(buffer), 0);
    printf("Date sent to client\n");
    close(new_socket);
    return 0;
}