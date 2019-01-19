#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <netdb.h>
#include <unistd.h>
#include <netinet/in.h>

int main(int argc, char *argv[]) {
    int sockf, portno, nM
    struct sockaddr_in serv_addr;
    struct hostent *server;

    char buffer[256];
    portno = 13;

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("ERROR opening socket");
        exit(1);
    }
    server = gethostbyname("time.nist.gov");
    if (server == NULL) {
       fprintf(stderr, "ERROR, no such host\n");
        exit(0);
    }

    bzero((char *) &serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr, serve->h_length);
    serv_addr.sin_port = htons(oprtno);

    // Now connect to the server
    if(connect(sockfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr)) < 0){
        perror("ERROR connecting");
        exit(1);
    }

    //Biw read server response
    bzero(buffer, 256);
    n = read(sockfd, buffer, 255);

    if(n <0)
    {

    }

    return 0;
}