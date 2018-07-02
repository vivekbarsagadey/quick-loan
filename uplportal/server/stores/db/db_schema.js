/**
 * Created by whizit on 29-06-2018.
 */
'use strict';

const logger = require('winston');
/*const knex = require('knex')(require('../../../knexfile'));*/

exports.recreateSchema = function (knex, callback) {
  callback = callback || function () {};

  /* Drop MACHINE_STATUS, MACHINE tables and re-create these 2 tables */
  logger.info('Re-creating database schema');
  knex.schema.dropTableIfExists('TB_USER')
    .then(function() {
      return knex.schema.dropTableIfExists('TB_USER');
    }).then(function () {
    return knex.schema.createTable('TB_USER', function(tbl) {
      tbl.increments('ID').primary();
      tbl.string('USERNAME').unique().index();
      tbl.string('PASSWORD');
    });
  }).then(function () {
    logger.info('Database schema have been updated');
    callback();
  }).catch(function (err) {
    logger.error('Create schema error: %s', err.toString());
    callback(err);
  });
};
