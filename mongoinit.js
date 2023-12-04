// Crie um usuário administrador
db.createUser({
  user: 'admin',
  pwd: 'admin123',
  roles: ['userAdminAnyDatabase', 'dbAdminAnyDatabase', 'readWriteAnyDatabase'],
});

// Crie um banco de dados para a aplicação
db = db.getSiblingDB('seu_banco_de_dados');
db.createUser({
  user: 'usuario',
  pwd: 'senha',
  roles: ['readWrite'],
});