
const knex = require('knex')(require('../../knexfile'))

const bookshelf = require('bookshelf')(knex);

const User = bookshelf.Model.extend({
  tableName: 'TB_USER'
});


module.exports = User;
