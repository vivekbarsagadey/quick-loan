/**
 * Created by whizit on 29-06-2018.
 */
const knex = require('knex')(require('../../knexfile'))
const User = require('../model/user');
module.exports = {
  authenticate({ username, password } ){
    return User.where({'USERNAME': username , 'PASSWORD':password}).fetch().then(function(user) {
      console.log("new User", user.toJSON());
      return user.toJSON()
    }).catch(function(err) {
      console.error(err);
      return null;
    });

  }
};
