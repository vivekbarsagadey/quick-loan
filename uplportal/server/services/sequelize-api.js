/**
 * Created by whizit on 09-07-2018.
 */
const Sequelize = require('sequelize');
const config = require('../../db-config');
const sequelize = new Sequelize(config.database, config.username, config.password, config);
//module.exports = sequelize;

const db        = {};
db.sequelize = sequelize;
db.Sequelize = Sequelize;

module.exports = db;
