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
