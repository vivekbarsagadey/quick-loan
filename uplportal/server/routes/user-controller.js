const express = require('express');
const router = express.Router();
const userService = require("../services/user-service");

router.post('/authenticate', (req, res) => {
  let user_name = req.body.username;
  let password = req.body.password;
  userService.authenticate({username: user_name, password: password}).then((user) => {
    if (user) {
      res.send({"auth": true, user: user});
    }
    else {
      res.send({"auth": false, user: null});
    }
  });
});

router.post('/updateUserData', (req, res) => {
  let userData = req.body.userData;
  console.log("userDataToUpdate----------------------------->>>>>",userData);
  userService.updateUserData({userData: userData},(user) => {
    if (user) {
      res.send({newUserData: user});
    }
    else {
      res.send({newUserData: null});
    }
  });
});

router.post('/deleteUserData', (req, res) => {
  let userData = req.body.userData;
  console.log("User Data to Delete----------------------------->>>>>",userData);
  userService.deleteUserData({userData: userData},(user) => {
    if (user) {
      res.send({newUserData: user});
    }
    else {
      res.send({newUserData: null});
    }
  });
});

router.get('/', (req, res) => {
  userService.findAll().then((users) => {
    if (users) {
      res.send(users);
    }else {
      res.send([]);
    }
  });
});

router.get('/createDummy', (req, res) => {
  userService.createDummyUserData((message)=>{
    res.send({message : message});
  });
});
module.exports = router;
