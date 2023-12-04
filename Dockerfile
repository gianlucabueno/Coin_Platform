# Use a imagem oficial do MongoDB como base
FROM mongo:latest

# Copie o script de inicialização do MongoDB
COPY ./mongoinit.js /docker-entrypoint-initdb.d/

# Exponha a porta padrão do MongoDB
EXPOSE 27017