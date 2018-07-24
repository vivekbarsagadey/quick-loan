const db = require('./sequelize-api');
const User = require("../model/user");

const userData = [{
  firstName: 'admin',
  lastName: 'admin',
  age: 35,
  email: 'admin@gsit.co.in',
  password: 'admin',
  userName: 'admin',
  role: 'admin'
}, {
  firstName: 'Vivek',
  lastName: 'Bar',
  age: 35,
  email: 'vivek@gsit.co.in',
  password: 'vivek',
  userName: 'vivek',
  role: 'user'
}, {
  firstName: 'Shan',
  lastName: 'Bar',
  age: 35,
  email: 'shan@gsit.co.in',
  password: 'shan',
  userName: 'shan',
  role: 'user'
}];

class UserService {

  UserService() {

  }

  authenticate({username, password}) {
    return User.findOne({where: {userName: username, password: password}}).then((data) => {
      console.log("dataVal.get() ", data);
      return data.get();
    });
  }

  findAll(callback) {
    return User.findAll({attributes: {exclude: ['createdAt', 'updatedAt']}}, {offset: 0}).then(function (data) {
      const userData = [];
      data.forEach((dataVal) => userData.push(dataVal.get()));
      return userData
    });
  };

  updateUserData({userData},callback){
    console.log("updateUserDataCreated>....------->>>>>>",userData);
    userData.forEach((user) => {
      db.sequelize.sync().then(function () {
        return User.create(user);
      }).then(function (res) {
        console.log("User is added ..",res);
        callback(res)
      }).catch(function (err) {
        console.log("error measssage.....", err);
       callback(err)
      });
    });
  }

  deleteUserData({userData},callback){
    console.log("UserDataaaaaaadeleting>....------>>>>>>>>>>>->>>>>>",userData);
    userData.forEach((user) => {
       db.sequelize.sync().then(function () {
        return User.destroy({
          where: { firstName: user.firstName, lastName: user.lastName, email: user.email, password: user.password}
        });
      }).then(function (res) {
        console.log("User is deleted ------------- .....>>>>>>>..",res);
         callback(res)
      }).catch(function (err) {
        console.log("error measssage..>>>>>>>>>>>>>>>>>>>>>>...", err);
        callback(err)
      });
    });
  }

  createDummyUserData(callback) {
    userData.forEach((user) => {
      db.sequelize.sync().then(function () {
        return User.create(user);
      }).then(function (res) {
        console.log("User is created ")
      }).catch(function (err) {
        console.log("error measssage.....", err);
        callback("Error during user creation")
      });
    });
    callback("User is created ")
  }

}


module.exports = new UserService();


