
const db = require('../services/sequelize-api');

const User = db.sequelize.define('TB_USER', {
  firstName: {
    field : "FIRST_NAME",
    type: db.Sequelize.STRING,
  },
  lastName: {
    field : "LAST_NAME",
    type: db.Sequelize.STRING,
  },
  age: {
    field : "AGE",
    type: db.Sequelize.INTEGER,
  },
  email: {
    field : "EMAIL",
    type: db.Sequelize.STRING,
  },
  userName: {
    field : "USER_NAME",
    type: db.Sequelize.STRING,
  },
  password: {
    field : "PASSWORD",
    type: db.Sequelize.STRING,
  },
  role: {
    field : "ROLE",
    type: db.Sequelize.STRING,
  }
});


module.exports = User;
