/**
 * Created by whizit on 29-06-2018.
 */
'use strict';

const logger = require('winston');
/*const knex = require('knex')(require('../../../knexfile'));*/

exports.insertData = function (knex, callback) {
  callback = callback || function () {};

  /* Drop MACHINE_STATUS, MACHINE tables and re-create these 2 tables */
  logger.info('Re-creating database schema');
  knex('TB_USER').insert({ USERNAME: "admin", PASSWORD: "admin" })
    .then(function (data) {
      return data[0];
    });
};
